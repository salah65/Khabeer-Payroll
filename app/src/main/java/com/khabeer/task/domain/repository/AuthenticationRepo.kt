package com.khabeer.task.domain.repository

import com.khabeer.task.data.network.dto.loginResponse.LoginResponse
import com.khabeer.task.domain.model.UserCredential


interface AuthenticationRepo {
    suspend fun login(userCredential: UserCredential): LoginResponse?
}