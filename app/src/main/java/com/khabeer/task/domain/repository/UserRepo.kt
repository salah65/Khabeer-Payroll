package com.khabeer.task.domain.repository

import com.khabeer.task.data.network.dto.getPayRollResponse.GetPayRollResponse


interface UserRepo {
    suspend fun fetchUserPayroll(token:String): GetPayRollResponse?
}