package com.khabeer.task.data.network.dto.loginResponse

data class LoginResponse(
    val AccountId: Int,
    val AccountRole: Any,
    val Activation: Boolean,
    val ArabicMessage: String,
    val Code: Int,
    val CurrentPage: Int,
    val EnglishMessage: String,
    val IsArabic: Any,
    val PageCount: Int,
    val Success: Boolean,
    val Token: String,
    val UserRole: Any,
    val UserType: Int,
    val VisitStatus: Any,
    val user: User
)