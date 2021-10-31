package com.khabeer.task.data.network.dto.getPayRollResponse

import java.io.Serializable

data class Payroll(
    val Allowences: List<Allowence>,
    val Date: String,
    val Deduction: List<Deduction>,
    val Employee: List<Employee>
):Serializable