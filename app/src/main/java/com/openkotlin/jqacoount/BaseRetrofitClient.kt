package com.openkotlin.jqacoount

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 *  Current name : BaseRetrofitClient in `KArch`
 *
 *  Created by Tanck on 2019-11-05 14:11.
 *
 *  Note : N/A
 *
 */
abstract class BaseRetrofitClient {

    companion object CLIENT {
        private const val TIME_OUT = 5
    }

    // Generate an innerClient as default for OkHttpClient
    private val innerClient: OkHttpClient
        // Let do the init in the get method. Such as the builder...
        get() {
            val clientBuilder = OkHttpClient.Builder()
            // To updating the log level
            val logging = HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.BASIC
            }
            // Let the build has custom logging and time out
            return clientBuilder.apply {
                addInterceptor(logging)
                connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            }.build()
        }

    /**
     * This is a custom builder if the default build can't be used in your case,
     * You can invoke this method to generate your builder for OKHTTP
     */
    @SuppressWarnings("unused")
    open fun customBuilder(builder: OkHttpClient.Builder) = Unit

    open fun <APIService> getAPIService(serviceClass: Class<APIService>, baseUrl: String): APIService {
        // The following snippet code has the same function
//        return Retrofit.Builder()
//            .client(innerClient)
//            .addConverterFactory(JacksonConverterFactory.create())
//            .baseUrl(baseUrl)
//            .build()
//            .create(serviceClass)

        // This is struct has break the restful
        return Retrofit.Builder().apply {
            client(innerClient)
//            addConverterFactory(JacksonConverterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(baseUrl)
        }.build().create(serviceClass)
    }
}