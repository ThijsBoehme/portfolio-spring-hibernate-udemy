package com.thijsboehme.springdemo.dao

import com.thijsboehme.springdemo.entity.Customer
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class CustomerDAOImplementation: CustomerDAO {
    // Need to inject the session factory
    @Autowired
    private lateinit var sessionFactory: SessionFactory

    @Transactional
    override fun getCustomers(): List<Customer> {
        // Get the current hibernate session
        val session = sessionFactory.currentSession

        // Create a query
        // language=HQL
        val query = session.createQuery("from Customer", Customer::class.java)

        // Execute the query and get the results list
        // Return the results
        return query.resultList
    }
}
