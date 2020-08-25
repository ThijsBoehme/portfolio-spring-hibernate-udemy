package com.thijsboehme.springdemo.service

import com.thijsboehme.springdemo.dao.CustomerDAO
import com.thijsboehme.springdemo.entity.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerServiceImplementation(
    @Autowired
    private val customerDAO: CustomerDAO
): CustomerService {
    @Transactional
    override fun getCustomers(): List<Customer> {
        return customerDAO.getCustomers()
    }

    @Transactional
    override fun getCustomer(id: Int): Customer? {
        return customerDAO.getCustomer(id)
    }

    @Transactional
    override fun saveCustomer(customer: Customer) {
        customerDAO.saveCustomer(customer)
    }

    @Transactional
    override fun deleteCustomer(id: Int) {
        customerDAO.deleteCustomer(id)
    }
}
