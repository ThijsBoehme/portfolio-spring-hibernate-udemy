package com.thijsboehme.springdemo.rest

import com.thijsboehme.springdemo.entity.Customer
import com.thijsboehme.springdemo.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CustomerRESTController(
    @Autowired
    private val customerService: CustomerService
) {
    @GetMapping("/customers")
    fun getCustomers(): List<Customer> {
        return customerService.getCustomers()
    }

    @GetMapping("/customers/{customerID}")
    fun getCustomer(@PathVariable customerID: Int): Customer {
        return customerService.getCustomer(customerID) ?: throw RuntimeException("Customer not found")
    }
}
