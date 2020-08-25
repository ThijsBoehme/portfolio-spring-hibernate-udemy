package com.thijsboehme.springboot.cruddemo.service

import com.thijsboehme.springboot.cruddemo.entity.Employee

interface EmployeeService {
    fun findAll(): List<Employee>
    fun findByID(id: Int): Employee?
    fun save(employee: Employee)
    fun deleteByID(id: Int)
}
