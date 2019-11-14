package com.openkotlin.jqacoount.api

import com.openkotlin.jqacoount.BaseRetrofitClient
import com.openkotlin.jqacoount.api.UserApi.Companion.UserRetrofitClient.UserApiService
import com.openkotlin.jqacoount.api.UserApi2.Companion.UserRetrofitClient.UserApiService2
import com.openkotlin.jqacoount.data.rsp.UserAccountRsp
import retrofit2.http.GET

/**
 *
 *  Current name : UserApi in `JQAcoount`
 *
 *  Created by Tanck on 2019-11-14 12:32.
 *
 *  Note : N/A
 *
 */
interface UserApi2 {
    @GET("v1/queryAllAccounts")
    suspend fun queryAllAccounts(): List<UserAccountRsp>

    companion object {
        // 1. Config the custom host url
        const val BASE_URL = "http://47.108.66.13/JqAPI/"

        // 2. Generate the request client. TODO : The client should be as a single instance - Tanck
        // TODO : Looking into how to abstract in Kotlin
        object UserRetrofitClient : BaseRetrofitClient() {
            val UserApiService2 by lazy { getAPIService(UserApi2::class.java, BASE_URL) }
        }

        // Operator is the constructor options. The same as the implement in java
        operator fun invoke(): UserApi2 {
            return UserApiService2
        }
    }
}