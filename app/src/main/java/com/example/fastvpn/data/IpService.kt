package com.example.fastvpn.data

import retrofit2.http.GET
import retrofit2.http.Query

data class IpResponse(
    val ip: String,
    val country: String,
    val countryCode: String,
    val city: String,
    val timezone: String,
    val isp: String
)

interface IpApiService {
    @GET("json")
    suspend fun getIpInfo(): IpResponse

    @GET("json")
    suspend fun getIpInfoByCountry(@Query("country") country: String): IpResponse
}