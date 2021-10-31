package com.khabeer.task.data.repositoryImp

import com.khabeer.task.data.gateways.ServerGateway
import com.khabeer.task.data.network.dto.getPayRollResponse.GetPayRollResponse
import com.khabeer.task.data.network.dto.loginResponse.User
import com.khabeer.task.domain.repository.UserRepo
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val serverGateway: ServerGateway
) :
    UserRepo {
    override suspend fun fetchUserPayroll(token:String): GetPayRollResponse? {
        return serverGateway.getPayroll(token)
    }
}