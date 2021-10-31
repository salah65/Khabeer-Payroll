package com.khabeer.task.data.di

import android.content.Context
import com.khabeer.task.app.MyApplication
import com.khabeer.task.data.gateways.ServerGateway
import com.khabeer.task.data.gateways.ServerGatewayImplementer
import com.khabeer.task.data.network.Endpoints
import com.khabeer.task.data.repositoryImp.AuthenticationRepositoryImp
import com.khabeer.task.data.repositoryImp.UserRepositoryImp
import com.khabeer.task.domain.repository.AuthenticationRepo
import com.khabeer.task.domain.repository.UserRepo
import com.khabeer.task.domain.useCases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): MyApplication = app as MyApplication

    @Singleton
    @Provides
    fun provideServerGateWay(api: Endpoints): ServerGateway =
        ServerGatewayImplementer(api)


    @Provides
    @Singleton
    fun provideAuthenticationRepository(serverGateway: ServerGateway): AuthenticationRepo =
        AuthenticationRepositoryImp(serverGateway)

    @Provides
    @Singleton
    fun provideUserRepository(serverGateway: ServerGateway): UserRepo =
        UserRepositoryImp(serverGateway)

    @Provides
    @Singleton
    fun provideLoginUseCase(authenticationRepo: AuthenticationRepo, userRepo: UserRepo) =
        LoginUseCase(authenticationRepo, userRepo)


}