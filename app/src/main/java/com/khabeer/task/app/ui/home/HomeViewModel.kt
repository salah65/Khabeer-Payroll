package com.khabeer.task.app.ui.home

import androidx.lifecycle.ViewModel
import com.khabeer.task.domain.model.EmployeeModel
import com.khabeer.task.domain.useCases.calculateEmployeeNetSalary
import com.khabeer.task.domain.useCases.getEmployeeTotalAllowancesUseCase
import com.khabeer.task.domain.useCases.getEmployeeTotalDeductionsUseCase

class HomeViewModel : ViewModel() {

    fun getTableData(employeeModel: EmployeeModel): HashMap<String, String> {
        val data = HashMap<String, String>()
        for (allowance in employeeModel.allowances!!) {
            data[allowance.description] = allowance.value.toString()
        }
        for (deduction in employeeModel.deductions!!)
            data[deduction.description] = deduction.value.toString()
        return data
    }

    fun getNetSalary(employeeModel: EmployeeModel) =
        calculateEmployeeNetSalary(employeeModel)

    fun getEmployeeTotalAllowances(employeeModel: EmployeeModel) =
        getEmployeeTotalAllowancesUseCase(employeeModel)

    fun getEmployeeTotalDeductions(employeeModel: EmployeeModel) =
        getEmployeeTotalDeductionsUseCase(employeeModel)
}