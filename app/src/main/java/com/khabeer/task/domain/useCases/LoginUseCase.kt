package com.khabeer.task.domain.useCases

import com.khabeer.task.data.mapper.mapToPayrollDomainModel
import com.khabeer.task.domain.model.EmployeeModel
import com.khabeer.task.domain.model.UserCredential
import com.khabeer.task.domain.repository.AuthenticationRepo
import com.khabeer.task.domain.repository.UserRepo
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val authRepository: AuthenticationRepo,
    private val userRepository: UserRepo,
) {
    suspend operator fun invoke(userCredential: UserCredential): List<EmployeeModel>? {
        return runCatching {
            authRepository.login(userCredential)
                ?.let {
                    userRepository.fetchUserPayroll(it.Token)?.Payroll?.Employee?.mapToPayrollDomainModel()
                        ?: emptyList()
                }
        }.getOrNull()
    }
}
