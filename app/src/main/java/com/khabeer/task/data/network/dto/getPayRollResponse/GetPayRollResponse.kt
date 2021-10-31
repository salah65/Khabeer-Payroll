package com.khabeer.task.data.network.dto.getPayRollResponse

data class GetPayRollResponse(
    val Activation: Boolean,
    val ArabicMessage: String,
    val EnglishMessage: String,
    val Payroll: Payroll,
    val Success: Boolean
)