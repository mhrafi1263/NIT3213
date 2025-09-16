package com.meherazrafi.nit3213.data.remote
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
data class LoginReq(
    val username: String,
    val password: String
)

data class LoginRes(
    val keypass: String
)

@Parcelize
data class FashionItem(
    val itemName: String,
    val designer: String,
    val yearIntroduced: Int,
    val category: String,
    val material: String,
    val description: String
) : Parcelable

data class DashboardRes(
    val entities: List<FashionItem>,
    val entityTotal: Int
)
