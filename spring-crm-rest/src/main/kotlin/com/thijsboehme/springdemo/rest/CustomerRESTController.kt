package com.thijsboehme.springdemo.rest

import com.thijsboehme.springdemo.entity.Customer
import com.thijsboehme.springdemo.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

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
        return customerService.getCustomer(customerID)
            ?: throw CustomerNotFoundException("Customer not found for ID '$customerID'")
    }

    @PostMapping("/customers")
    fun addCustomer(@RequestBody customer: Customer): Customer {
        customer.id = 0
        customerService.saveCustomer(customer)
        return customer
    }

    @PutMapping("/customers")
    fun updateCustomer(@RequestBody customer: Customer): Customer {
        customerService.saveCustomer(customer)
        return customer
    }

    @DeleteMapping("/customers/{customerID}")
    fun deleteCustomer(@PathVariable customerID: Int): String {
        customerService.getCustomer(customerID)
            ?: throw CustomerNotFoundException("Customer not found for ID '$customerID'")
        
        customerService.deleteCustomer(customerID)
        return "Deleted customer with ID '$customerID'"
    }
}
