package com.thijsboehme.springsecurity.demo.config

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.view.InternalResourceViewResolver
import java.util.logging.Logger
import javax.sql.DataSource

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = ["com.thijsboehme.springsecurity.demo"])
@PropertySource("classpath:persistence-mysql.properties")
class DemoAppConfig(
    // Setup variable to hold the properties
    @Autowired
    val environment: Environment
) {
    // Setup a logger for diagnostics
    private val logger = Logger.getLogger(javaClass.simpleName)

    // Define a bean for the ViewResolver
    @Bean
    fun viewResolver(): ViewResolver {
        val viewResolver = InternalResourceViewResolver()

        viewResolver.setPrefix("/WEB-INF/view/")
        viewResolver.setSuffix(".jsp")

        return viewResolver
    }

    // Define a bean for our security datasource
    @Bean
    fun securityDataSource(): DataSource {
        // Create a connection pool
        val securityDataSource = ComboPooledDataSource()

        // Set the jdbc driver class
        securityDataSource.driverClass = environment.getProperty("jdbc.driver")

        // Log the connection properties for sanity's sake, log this info just to make sure we are really reading data
        // from the properties file
        logger.info(">>> jdbc.url=${environment.getProperty("jdbc.url")}")
        logger.info(">>> jdbc.user=${environment.getProperty("jdbc.user")}")

        // Set the database connection properties
        securityDataSource.jdbcUrl = environment.getProperty("jdbc.url")
        securityDataSource.user = environment.getProperty("jdbc.user")
        securityDataSource.password = environment.getProperty("jdbc.password")

        // Set the connection pool properties
        securityDataSource.initialPoolSize = getIntProperty("connection.pool.initialPoolSize")
        securityDataSource.minPoolSize = getIntProperty("connection.pool.minPoolSize")
        securityDataSource.maxPoolSize = getIntProperty("connection.pool.maxPoolSize")
        securityDataSource.maxIdleTime = getIntProperty("connection.pool.maxIdleTime")

        return securityDataSource
    }

    /**
     * Helper method read an environment property and convert it to Int
     */
    private fun getIntProperty(propertyName: String): Int {
        val propertyValue = environment.getProperty(propertyName) ?: ""
        return propertyValue.toInt()
    }
}
