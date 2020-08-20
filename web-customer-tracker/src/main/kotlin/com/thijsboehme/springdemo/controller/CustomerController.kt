package com.thijsboehme.springdemo.controller

import com.thijsboehme.springdemo.dao.CustomerDAO
import com.thijsboehme.springdemo.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/customer")
class CustomerController {
    // Need to inject the Customer Service
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/list")
    fun listCustomers(model: Model): String {
        // Get customers from the DAO
        val customers = customerService.getCustomers()

        // Add the customers to the model
        model.addAttribute("customers", customers)

        return "list-customers"
    }
}
