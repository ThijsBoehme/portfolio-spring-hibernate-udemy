package com.thijsboehme.springsecurity.demo.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
class DemoSecurityConfiguration(
    // Add reference to our security data source
    @Autowired
    val securityDataSource: DataSource
): WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
        // Use JDBC authentication
        auth?.jdbcAuthentication()?.dataSource(securityDataSource)
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
            ?.antMatchers("/")?.hasRole("EMPLOYEE")
            ?.antMatchers("/leaders/**")?.hasRole("MANAGER")
            ?.antMatchers("/systems/**")?.hasRole("ADMIN")
            ?.and()
            ?.formLogin()?.loginPage("/showMyLoginPage")?.loginProcessingUrl("/authenticateTheUser")?.permitAll()
            ?.and()
            ?.logout()?.permitAll()
            ?.and()
            ?.exceptionHandling()?.accessDeniedPage("/access-denied")
    }
}
