package com.thijsboehme.springboot.thymeleafdemo.service

import com.thijsboehme.springboot.thymeleafdemo.dao.EmployeeRepository
import com.thijsboehme.springboot.thymeleafdemo.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImplementation(@Autowired private val employeeRepository: EmployeeRepository): EmployeeService {
    override fun findAll(): List<Employee> = employeeRepository.findAllByOrderByLastNameAsc()

    override fun findById(id: Int): Employee? = employeeRepository.findById(id).orElse(null)

    override fun save(employee: Employee) {
        employeeRepository.save(employee)
    }

    override fun deleteById(id: Int) {
        employeeRepository.deleteById(id)
    }
}
