package com.thijsboehme.springboot.thymeleafdemo.service

import com.thijsboehme.springboot.thymeleafdemo.entity.Employee

interface EmployeeService {
    fun findAll(): List<Employee>
    fun findById(id: Int): Employee?
    fun save(employee: Employee)
    fun deleteById(id: Int)
}
