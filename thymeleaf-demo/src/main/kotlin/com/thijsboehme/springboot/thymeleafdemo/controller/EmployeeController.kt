package com.thijsboehme.springboot.thymeleafdemo.controller

import com.thijsboehme.springboot.thymeleafdemo.model.Employee
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/employees")
class EmployeeController {
    private val list = listOf(
        Employee(1, "Leslie", "Andrews", "leslie@luv2code.com"),
        Employee(2, "Emma", "Baumgarten", "emma@luv2code.com"),
        Employee(3, "Avani", "Gupta", "avani@luv2code.com")
    )

    @GetMapping("/list")
    fun listEmployees(model: Model): String {
        model.addAttribute("employees", list)
        return "list-employees"
    }
}
