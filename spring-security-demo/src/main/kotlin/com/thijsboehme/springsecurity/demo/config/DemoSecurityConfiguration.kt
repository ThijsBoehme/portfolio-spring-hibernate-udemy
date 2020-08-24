package com.thijsboehme.springsecurity.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User

@Configuration
@EnableWebSecurity
class DemoSecurityConfiguration: WebSecurityConfigurerAdapter() {
    override fun configure(auth: AuthenticationManagerBuilder?) {
        val users = User.withDefaultPasswordEncoder()

        auth?.inMemoryAuthentication()
            ?.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
            ?.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
            ?.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"))
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
            ?.anyRequest()
            ?.authenticated()
            ?.and()
            ?.formLogin()
            ?.loginPage("/showMyLoginPage")
            ?.loginProcessingUrl("/authenticateTheUser")
            ?.permitAll()
            ?.and()
            ?.logout()
            ?.permitAll()
    }
}
