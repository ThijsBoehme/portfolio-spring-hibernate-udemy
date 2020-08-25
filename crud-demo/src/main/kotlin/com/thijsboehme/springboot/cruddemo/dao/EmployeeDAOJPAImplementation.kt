package com.thijsboehme.springboot.cruddemo.dao

import com.thijsboehme.springboot.cruddemo.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class EmployeeDAOJPAImplementation(@Autowired private val entityManager: EntityManager): EmployeeDAO {
    override fun findAll(): List<Employee> {
        // language=HQL
        val query = entityManager.createQuery("from Employee")
        return query.resultList.filterIsInstance<Employee>()
    }

    override fun findByID(id: Int): Employee? = entityManager.find(Employee::class.java, id)

    override fun save(employee: Employee) {
        val dbEmployee = entityManager.merge(employee)
        employee.id = dbEmployee.id
    }

    override fun deleteByID(id: Int) {
        val query = entityManager.createQuery("delete from Employee where id=:employeeID")
        query.setParameter("employeeID", id)
        query.executeUpdate()
    }
}
