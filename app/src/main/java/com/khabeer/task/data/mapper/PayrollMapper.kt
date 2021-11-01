package com.khabeer.task.data.mapper

import com.khabeer.task.data.network.dto.getPayRollResponse.Employee
import com.khabeer.task.data.network.dto.getPayRollResponse.Payroll
import com.khabeer.task.domain.model.EmployeeModel

fun List<Employee>.mapToPayrollDomainModel(): List<EmployeeModel> {
    val list = ArrayList<EmployeeModel>()
    for (item in this) {
        list.add(
            EmployeeModel(
                item.EMP_DATA_EN,
                item.JOBNAME_EN,
                item.SEC_NAME_EN,
                item.MAR_STATUS_EN,
                item.STATUS_EN
            )
        )

    }
    return list
}
