package com.khabeer.task.data.repositoryImp

import com.khabeer.task.data.gateways.ServerGateway
import com.khabeer.task.data.network.dto.loginResponse.LoginResponse
import com.khabeer.task.domain.model.UserCredential
import com.khabeer.task.domain.repository.AuthenticationRepo
import javax.inject.Inject

class AuthenticationRepositoryImp @Inject constructor(private val server: ServerGateway) :
    AuthenticationRepo {
    override suspend fun login(userCredential: UserCredential): LoginResponse? {
        return server.login(userCredential)
    }


}