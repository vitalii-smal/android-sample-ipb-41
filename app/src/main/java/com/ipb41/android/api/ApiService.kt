package com.ipb41.android.api

import com.ipb41.android.models.EmployeeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("employees")
    suspend fun getEmployees(): EmployeeResponse
}