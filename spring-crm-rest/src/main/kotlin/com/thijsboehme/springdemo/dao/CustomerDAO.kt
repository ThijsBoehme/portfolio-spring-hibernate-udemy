package com.thijsboehme.springdemo.dao

import com.thijsboehme.springdemo.entity.Customer

interface CustomerDAO {
    fun getCustomers(): List<Customer>
    fun getCustomer(id: Int): Customer?
    fun saveCustomer(customer: Customer)
    fun deleteCustomer(id: Int)
}
