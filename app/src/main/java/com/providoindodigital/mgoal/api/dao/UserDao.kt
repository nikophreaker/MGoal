package com.providoindodigital.mgoal.api.dao


import com.google.gson.annotations.SerializedName

data class UserDao(
    @SerializedName("address")
    val address: Any,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("email_verified_at")
    val emailVerifiedAt: String,
    @SerializedName("f_point")
    val fPoint: Any,
    @SerializedName("fb_id")
    val fbId: Any,
    @SerializedName("follow")
    val follow: Any,
    @SerializedName("gender")
    val gender: Int,
    @SerializedName("google_id")
    val googleId: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isAggree")
    val isAggree: Int,
    @SerializedName("isJOin")
    val isJOin: Int,
    @SerializedName("isVerified")
    val isVerified: Int,
    @SerializedName("kode_otp")
    val kodeOtp: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone_number")
    val phoneNumber: Any,
    @SerializedName("r_point")
    val rPoint: Any,
    @SerializedName("referral")
    val referral: String,
    @SerializedName("tanggal_lahir")
    val tanggalLahir: Any,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("username")
    val username: String
)