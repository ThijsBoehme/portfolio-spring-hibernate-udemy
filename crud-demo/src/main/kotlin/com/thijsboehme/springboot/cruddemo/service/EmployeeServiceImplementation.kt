package com.thijsboehme.springboot.cruddemo.service

import com.thijsboehme.springboot.cruddemo.dao.EmployeeRepository
import com.thijsboehme.springboot.cruddemo.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmployeeServiceImplementation(@Autowired private val employeeRepository: EmployeeRepository): EmployeeService {

    @Transactional
    override fun findAll(): List<Employee> = employeeRepository.findAll()

    @Transactional
    override fun findByID(id: Int): Employee? = employeeRepository.findById(id).orElse(null)

    @Transactional
    override fun save(employee: Employee) {
        employeeRepository.save(employee)
    }

    @Transactional
    override fun deleteByID(id: Int) {
        employeeRepository.deleteById(id)
    }
}
