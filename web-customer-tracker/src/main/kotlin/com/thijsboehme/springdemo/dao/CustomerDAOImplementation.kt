package com.thijsboehme.springdemo.dao

import com.thijsboehme.springdemo.entity.Customer
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class CustomerDAOImplementation: CustomerDAO {
    // Need to inject the session factory
    @Autowired
    private lateinit var sessionFactory: SessionFactory

    override fun getCustomers(): List<Customer> {
        // Get the current Hibernate session
        val session = sessionFactory.currentSession

        // Create a query
        // language=HQL
        val query = session.createQuery(
            "from Customer order by lastName",
            Customer::class.java
        )

        // Execute the query and get the results list
        // Return the results
        return query.resultList
    }

    override fun saveCustomer(customer: Customer) {
        // Get current Hibernate session
        val session = sessionFactory.currentSession

        // Save/Update the customer
        session.saveOrUpdate(customer)
    }

    override fun getCustomer(id: Int): Customer? {
        // Get current Hibernate session
        val session = sessionFactory.currentSession

        // Retrieve/read from the database using the primary key
        return session.get(Customer::class.java, id)
    }
}
