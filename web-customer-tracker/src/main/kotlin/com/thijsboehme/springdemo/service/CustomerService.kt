package com.thijsboehme.springdemo.service

import com.thijsboehme.springdemo.entity.Customer

interface CustomerService {
    fun getCustomers(): List<Customer>
    fun saveCustomer(customer: Customer)
    fun getCustomer(id: Int): Customer?
}
