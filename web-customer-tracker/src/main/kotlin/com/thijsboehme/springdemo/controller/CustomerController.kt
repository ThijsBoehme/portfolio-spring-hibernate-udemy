package com.thijsboehme.springdemo.controller

import com.thijsboehme.springdemo.dao.CustomerDAO
import com.thijsboehme.springdemo.entity.Customer
import com.thijsboehme.springdemo.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
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

    @GetMapping("/showFormForAdd")
    fun showFormForAdd(model: Model): String {
        val customer = Customer()
        model.addAttribute("customer", customer)
        return "customer-form"
    }

    @PostMapping("/saveCustomer")
    fun saveCustomer(@ModelAttribute("customer") customer: Customer): String {
        // Save the customer using our service
        customerService.saveCustomer(customer)

        return "redirect:/customer/list"
    }
}
