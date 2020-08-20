package com.thijsboehme.springdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/customer")
class CustomerController {
    @RequestMapping("/list")
    fun listCustomers(model: Model): String {
        return "list-customers"
    }
}
