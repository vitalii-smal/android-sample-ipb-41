package com.ipb41.android.employees

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipb41.android.datasource.ApiDataSource
import com.ipb41.android.models.Employee
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmployeesViewModel(private val apiDataSource: ApiDataSource) : ViewModel() {

    private val _employees = MutableStateFlow<List<Employee>>(emptyList())
    val employees: StateFlow<List<Employee>> = _employees

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        loadEmployees()
    }

    private fun loadEmployees() {
        viewModelScope.launch {
            try {
                val employeesResult = apiDataSource.getEmployees()
                _employees.value = employeesResult
            } catch (e: Exception) {
                _errorMessage.value = "Помилка завантаження: ${e.localizedMessage}"
            }
        }
    }
}