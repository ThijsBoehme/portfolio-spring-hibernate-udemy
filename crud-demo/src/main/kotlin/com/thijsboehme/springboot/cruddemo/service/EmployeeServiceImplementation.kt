package com.thijsboehme.springboot.cruddemo.service

import com.thijsboehme.springboot.cruddemo.dao.EmployeeDAO
import com.thijsboehme.springboot.cruddemo.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmployeeServiceImplementation(@Autowired private val employeeDAO: EmployeeDAO): EmployeeService {
    @Transactional
    override fun findAll(): List<Employee> {
        return employeeDAO.findAll()
    }

    @Transactional
    override fun findByID(id: Int): Employee? {
        return employeeDAO.findByID(id)
    }

    @Transactional
    override fun save(employee: Employee) {
        employeeDAO.save(employee)
    }

    @Transactional
    override fun deleteByID(id: Int) {
        employeeDAO.deleteByID(id)
    }
}
