package com.ipb41.android.datasource

import com.ipb41.android.models.Employee

interface ApiDataSource {
    suspend fun getEmployees(): List<Employee>
}