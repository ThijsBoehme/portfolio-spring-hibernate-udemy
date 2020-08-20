package com.thijsboehme.springdemo.service

import com.thijsboehme.springdemo.entity.Customer

interface CustomerService {
    fun getCustomers(): List<Customer>
}
