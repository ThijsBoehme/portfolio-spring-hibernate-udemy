package com.thijsboehme.springboot.cruddemo.dao

import com.thijsboehme.springboot.cruddemo.entity.Employee
import org.hibernate.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class EmployeeDAOHibernateImplementation(@Autowired private val entityManager: EntityManager): EmployeeDAO {
    override fun findAll(): List<Employee> {
        val currentSession = entityManager.unwrap(Session::class.java)

        // language=HQL
        val query = currentSession.createQuery("from Employee", Employee::class.java)
        return query.resultList
    }

    override fun findByID(id: Int): Employee? {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession.get(Employee::class.java, id)
    }

    override fun save(employee: Employee) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.saveOrUpdate(employee)
    }

    override fun deleteByID(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)

        // language=HQL
        val query = currentSession.createQuery("delete from Employee where id=:employeeID")
        query.setParameter("employeeID", id)
        query.executeUpdate()
    }
}
