package com.providoindodigital.mgoal.api.dao


import com.google.gson.annotations.SerializedName

data class profilItemDao(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("total_cash")
    val totalCash: Any,
    @SerializedName("total_point")
    val totalPoint: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user")
    val user: UserDao,
    @SerializedName("user_id")
    val userId: Int
)