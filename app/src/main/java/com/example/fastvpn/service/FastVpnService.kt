package com.example.fastvpn.service

import android.content.Intent
import android.net.VpnService
import android.os.Handler
import android.os.Looper

class FastVpnService : VpnService() {

    companion object {
        private const val TAG = "FastVpnService"
        const val ACTION_CONNECT = "com.example.fastvpn.CONNECT"
        const val ACTION_DISCONNECT = "com.example.fastvpn.DISCONNECT"
    }

    private var vpnThread: Thread? = null
    private val handler = Handler(Looper.getMainLooper())

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return when (intent?.action) {
            ACTION_CONNECT -> {
                startVpn(intent)
                START_STICKY
            }
            ACTION_DISCONNECT -> {
                stopVpn()
                START_STICKY
            }
            else -> START_STICKY
        }
    }

    private fun startVpn(intent: Intent) {
        if (vpnThread != null) {
            return
        }

        vpnThread = Thread {
            try {
                val builder = Builder()
                builder.setSession("FastVPN")
                builder.addAddress("10.0.0.2", 24)
                builder.addDnsServer("8.8.8.8")
                builder.addDnsServer("8.8.4.4")
                builder.addRoute("0.0.0.0", 0)
                builder.setMtu(1500)

                val vpnInterface = builder.establish()
                if (vpnInterface != null) {
                    // VPN connected
                    handler.post {
                        // Update UI
                    }
                    Thread.sleep(60000) // Keep VPN alive
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                vpnThread = null
            }
        }
        vpnThread?.start()
    }

    private fun stopVpn() {
        vpnThread?.interrupt()
        vpnThread = null
    }

    override fun onDestroy() {
        stopVpn()
        super.onDestroy()
    }
}