package com.example.fastvpn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fastvpn.data.ServerRepository
import com.example.fastvpn.data.VpnServer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VpnState(
    val isConnected: Boolean = false,
    val currentIp: String = "Loading...",
    val currentCountry: String = "Unknown",
    val servers: List<VpnServer> = emptyList(),
    val selectedServer: VpnServer? = null,
    val connectionSpeed: Int = 0,
    val connectionPing: Int = 0
)

@HiltViewModel
class VpnViewModel @Inject constructor(
    private val serverRepository: ServerRepository
) : ViewModel() {

    private val _vpnState = MutableStateFlow(VpnState())
    val vpnState: StateFlow<VpnState> = _vpnState

    init {
        loadServers()
    }

    private fun loadServers() {
        viewModelScope.launch {
            val servers = serverRepository.getServers()
            _vpnState.value = _vpnState.value.copy(
                servers = servers,
                selectedServer = serverRepository.getFastestServer()
            )
        }
    }

    fun connectVpn(server: VpnServer) {
        viewModelScope.launch {
            _vpnState.value = _vpnState.value.copy(
                isConnected = true,
                selectedServer = server,
                currentIp = "Connected",
                currentCountry = server.country
            )
        }
    }

    fun disconnectVpn() {
        viewModelScope.launch {
            _vpnState.value = _vpnState.value.copy(
                isConnected = false,
                currentIp = "Disconnected",
                currentCountry = "Unknown"
            )
        }
    }

    fun selectServer(server: VpnServer) {
        _vpnState.value = _vpnState.value.copy(selectedServer = server)
    }
}