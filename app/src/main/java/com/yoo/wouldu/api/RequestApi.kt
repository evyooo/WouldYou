package com.yoo.wouldu.api

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RequestApi {
    @GET("/{school}/requests")
    suspend fun getRequestList(@Path("school") school: String): ResponseBody

    @POST("request")
    suspend fun postRequest()
}