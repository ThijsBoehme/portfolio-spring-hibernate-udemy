package com.thijsboehme.springdemo.dao

import com.thijsboehme.springdemo.entity.Customer

interface CustomerDAO {
    fun getCustomers(): List<Customer>
}
