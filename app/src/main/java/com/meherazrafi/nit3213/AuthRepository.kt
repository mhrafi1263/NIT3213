package com.meherazrafi.nit3213.data


import com.meherazrafi.nit3213.data.remote.LoginReq
import com.meherazrafi.nit3213.data.remote.NIT3213Api
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: NIT3213Api
) {
    suspend fun login(firstName: String, idNo: String, campus: String = "br"): String {
        return api.login(campus, LoginReq(firstName, idNo)).keypass
    }
}
