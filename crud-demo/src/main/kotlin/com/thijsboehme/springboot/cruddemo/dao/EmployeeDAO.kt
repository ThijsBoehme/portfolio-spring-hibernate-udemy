package com.thijsboehme.springboot.cruddemo.dao

import com.thijsboehme.springboot.cruddemo.entity.Employee

interface EmployeeDAO {
    fun findAll(): List<Employee>
    fun findByID(id: Int): Employee?
    fun save(employee: Employee)
    fun deleteByID(id: Int)
}
