package com.example.fastvpn.data

data class VpnServer(
    val id: String,
    val country: String,
    val countryCode: String,
    val city: String,
    val ip: String,
    val protocol: String = "OpenVPN",
    val speed: Int = 0,
    val ping: Int = 0,
    val flag: String = ""
)

class ServerRepository {
    fun getServers(): List<VpnServer> {
        return listOf(
            VpnServer(
                id = "us-01",
                country = "United States",
                countryCode = "US",
                city = "New York",
                ip = "45.32.105.48",
                speed = 950,
                ping = 12,
                flag = "🇺🇸"
            ),
            VpnServer(
                id = "gb-01",
                country = "United Kingdom",
                countryCode = "GB",
                city = "London",
                ip = "195.34.89.241",
                speed = 920,
                ping = 18,
                flag = "🇬🇧"
            ),
            VpnServer(
                id = "de-01",
                country = "Germany",
                countryCode = "DE",
                city = "Berlin",
                ip = "45.76.104.62",
                speed = 940,
                ping = 22,
                flag = "🇩🇪"
            ),
            VpnServer(
                id = "fr-01",
                country = "France",
                countryCode = "FR",
                city = "Paris",
                ip = "95.179.135.74",
                speed = 930,
                ping = 25,
                flag = "🇫🇷"
            ),
            VpnServer(
                id = "jp-01",
                country = "Japan",
                countryCode = "JP",
                city = "Tokyo",
                ip = "45.76.175.50",
                speed = 880,
                ping = 85,
                flag = "🇯🇵"
            ),
            VpnServer(
                id = "au-01",
                country = "Australia",
                countryCode = "AU",
                city = "Sydney",
                ip = "45.76.177.133",
                speed = 850,
                ping = 120,
                flag = "🇦🇺"
            ),
            VpnServer(
                id = "ca-01",
                country = "Canada",
                countryCode = "CA",
                city = "Toronto",
                ip = "104.156.225.105",
                speed = 960,
                ping = 15,
                flag = "🇨🇦"
            ),
            VpnServer(
                id = "nl-01",
                country = "Netherlands",
                countryCode = "NL",
                city = "Amsterdam",
                ip = "45.32.100.71",
                speed = 970,
                ping = 20,
                flag = "🇳🇱"
            )
        )
    }

    fun getFastestServer(): VpnServer {
        return getServers().maxByOrNull { it.speed } ?: getServers().first()
    }

    fun getServersByCountry(country: String): List<VpnServer> {
        return getServers().filter { it.country.contains(country, ignoreCase = true) }
    }
}