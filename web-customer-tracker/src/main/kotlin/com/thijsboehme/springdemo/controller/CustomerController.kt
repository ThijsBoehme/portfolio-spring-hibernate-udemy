package com.thijsboehme.springdemo.controller

import com.thijsboehme.springdemo.dao.CustomerDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/customer")
class CustomerController {
    // Need to inject the Customer DAO
    @Autowired
    private lateinit var customerDAO: CustomerDAO

    @RequestMapping("/list")
    fun listCustomers(model: Model): String {
        // Get customers from the DAO
        val customers = customerDAO.getCustomers()

        // Add the customers to the model
        model.addAttribute("customers", customers)

        return "list-customers"
    }
}
