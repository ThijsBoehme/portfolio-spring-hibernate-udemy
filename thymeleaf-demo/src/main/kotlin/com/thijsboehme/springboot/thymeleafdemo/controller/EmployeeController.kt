package com.thijsboehme.springboot.thymeleafdemo.controller

import com.thijsboehme.springboot.thymeleafdemo.entity.Employee
import com.thijsboehme.springboot.thymeleafdemo.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/employees")
class EmployeeController(@Autowired private val employeeService: EmployeeService) {
    @GetMapping("/list")
    fun listEmployees(model: Model): String {
        model.addAttribute("employees", employeeService.findAll())
        return "employees/list-employees"
    }

    @GetMapping("/showFormForAdd")
    fun showFormForAdd(model: Model): String {
        val employee = Employee()
        model.addAttribute("employee", employee)
        return "employees/employee-form"
    }

    @GetMapping("/showFormForUpdate")
    fun showFormForUpdate(@RequestParam("employeeId") id: Int, model: Model): String {
        val employee = employeeService.findById(id) ?: throw RuntimeException("Employee not found")
        model.addAttribute("employee", employee)
        return "employees/employee-form"
    }

    @PostMapping("/save")
    fun saveEmployee(@ModelAttribute("employee") employee: Employee): String {
        employeeService.save(employee)
        return "redirect:/employees/list"
    }

    @GetMapping("/delete")
    fun delete(@RequestParam("employeeId") id: Int): String {
        employeeService.deleteById(id)
        return "redirect:/employees/list"
    }
}
