package com.thijsboehme.springdemo.config

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.*
import java.util.logging.Logger
import javax.sql.DataSource

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.thijsboehme.springdemo")
@PropertySource("classpath:persistence-mysql.properties")
class DemoAppConfig(
    @Autowired
    private val environment: Environment
): WebMvcConfigurer {
    private val logger = Logger.getLogger(javaClass.name)

    @Bean
    fun dataSource(): DataSource {
        // Create connection pool
        val dataSource = ComboPooledDataSource()

        // Set the JDBC driver
        dataSource.driverClass = "com.mysql.jdbc.Driver"

        // For sanity's sake, let's log url and user ... just to make sure we are reading the data
        logger.info("jdbc.url = ${environment.getProperty("jdbc.url")}")
        logger.info("jdbc.user = ${environment.getProperty("jdbc.user")}")

        // Set the database connection properties
        dataSource.jdbcUrl = environment.getProperty("jdbc.url")
        dataSource.user = environment.getProperty("jdbc.user")
        dataSource.password = environment.getProperty("jdbc.password")

        // Set the connection pool properties
        dataSource.initialPoolSize = getIntProperty("connection.pool.initialPoolSize")
        dataSource.minPoolSize = getIntProperty("connection.pool.minPoolSize")
        dataSource.maxPoolSize = getIntProperty("connection.pool.maxPoolSize")
        dataSource.maxIdleTime = getIntProperty("connection.pool.maxIdleTime")

        return dataSource
    }

    @Bean
    fun sessionFactory(): LocalSessionFactoryBean {
        // Create session factories
        val sessionFactory = LocalSessionFactoryBean()

        // Set the properties
        sessionFactory.setDataSource(dataSource())
        sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"))
        sessionFactory.hibernateProperties = getHibernateProperties()

        return sessionFactory
    }

    @Bean
    @Autowired
    fun transactionManager(sessionFactory: SessionFactory): HibernateTransactionManager {
        // Set up transaction manager based on session factory
        val transactionManager = HibernateTransactionManager()
        transactionManager.sessionFactory = sessionFactory

        return transactionManager
    }

    private fun getIntProperty(propertyName: String): Int {
        val propertyValue = environment.getProperty(propertyName)
        return propertyValue.toInt()
    }

    private fun getHibernateProperties(): Properties {
        // Set Hibernate properties
        val properties = Properties()

        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"))
        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"))

        return properties
    }
}
