package com.thijsboehme.springboot.cruddemo.rest

import com.thijsboehme.springboot.cruddemo.entity.Employee
import com.thijsboehme.springboot.cruddemo.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class EmployeeRESTController(@Autowired private val employeeService: EmployeeService) {

    @GetMapping("/employees")
    fun findAll(): List<Employee> = employeeService.findAll()

    @GetMapping("/employees/{employeeID}")
    fun getEmployee(@PathVariable employeeID: Int): Employee =
        employeeService.findByID(employeeID) ?: throw RuntimeException("Employee not found")

    @PostMapping("/employees")
    fun addEmployee(@RequestBody employee: Employee): Employee {
        employee.id = 0
        employeeService.save(employee)
        return employee
    }

    @PutMapping("/employees")
    fun updateEmployee(@RequestBody employee: Employee): Employee {
        employeeService.save(employee)
        return employee
    }

    @DeleteMapping("/employees/{employeeID}")
    fun deleteEmployee(@PathVariable employeeID: Int): String {
        employeeService.findByID(employeeID) ?: throw RuntimeException("Employee not found for ID: '$employeeID'")
        employeeService.deleteByID(employeeID)
        return "Deleted employee for ID '$employeeID'"
    }
}
