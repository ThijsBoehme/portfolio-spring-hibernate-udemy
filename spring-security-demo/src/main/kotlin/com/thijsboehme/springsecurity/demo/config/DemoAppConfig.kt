package com.thijsboehme.springsecurity.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = arrayOf("com.thijsboehme.springsecurity.demo"))
class DemoAppConfig {
    // Define a bean for the ViewResolver
    @Bean
    fun viewResolver(): ViewResolver {
        val viewResolver = InternalResourceViewResolver()

        viewResolver.setPrefix("/WEB-INF/view/")
        viewResolver.setSuffix(".jsp")

        return viewResolver
    }
}
