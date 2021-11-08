package com.khabeer.task.data.network.dto.getPayRollResponse

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Payroll(
    @SerializedName("Allowences")
    val allowancesDto: List<AllowanceDto>,
    val Date: String,
    @SerializedName("Deduction")
    val DeductionsDTO: List<DeductionDTO>,
    val Employee: List<Employee>
):Serializable