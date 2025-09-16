package com.meherazrafi.nit3213.data.remote

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NIT3213Api {

    @POST("{campus}/auth")
    suspend fun login(
        @Path("campus") campus: String,
        @Body body: LoginReq
    ): LoginRes

    @GET("dashboard/{keypass}")
    suspend fun dashboard(
        @Path("keypass") keypass: String
    ): DashboardRes
}
