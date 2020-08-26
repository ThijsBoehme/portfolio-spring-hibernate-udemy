package com.thijsboehme.springboot.thymeleafdemo.dao

import com.thijsboehme.springboot.thymeleafdemo.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository: JpaRepository<Employee, Int> {
    fun findAllByOrderByLastNameAsc(): List<Employee>
}
