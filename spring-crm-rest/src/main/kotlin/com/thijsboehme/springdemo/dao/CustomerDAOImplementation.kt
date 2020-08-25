package com.thijsboehme.springdemo.dao

import com.thijsboehme.springdemo.entity.Customer
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class CustomerDAOImplementation(
    @Autowired
    private val sessionFactory: SessionFactory
): CustomerDAO {
    override fun getCustomers(): List<Customer> {
        val currentSession = sessionFactory.currentSession
        val query = currentSession.createQuery("from Customer order by lastName", Customer::class.java)
        return query.resultList
    }

    override fun getCustomer(id: Int): Customer? {
        val currentSession = sessionFactory.currentSession
        return currentSession.get(Customer::class.java, id)
    }

    override fun saveCustomer(customer: Customer) {
        val currentSession = sessionFactory.currentSession
        currentSession.saveOrUpdate(customer)
    }

    override fun deleteCustomer(id: Int) {
        val currentSession = sessionFactory.currentSession
        val query = currentSession.createQuery("delete from Customer where id=:customerID")
        query.setParameter("customerID", id)
        query.executeUpdate()
    }

}
