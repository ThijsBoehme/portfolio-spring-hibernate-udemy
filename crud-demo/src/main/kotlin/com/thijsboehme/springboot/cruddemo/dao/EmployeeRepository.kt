package com.thijsboehme.springboot.cruddemo.dao

import com.thijsboehme.springboot.cruddemo.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository: JpaRepository<Employee, Int>
