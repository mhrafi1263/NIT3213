package com.meherazrafi.nit3213.data


import com.meherazrafi.nit3213.data.remote.DashboardRes
import com.meherazrafi.nit3213.data.remote.NIT3213Api
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    private val api: NIT3213Api
) {
    suspend fun load(keypass: String): DashboardRes = api.dashboard(keypass)
}
