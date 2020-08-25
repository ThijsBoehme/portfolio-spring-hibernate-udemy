package com.thijsboehme.springdemo.config

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

class SpringMVCDispatcherServletInitialiser: AbstractAnnotationConfigDispatcherServletInitializer() {
    override fun getServletMappings(): Array<String> {
        return arrayOf("/")
    }

    override fun getRootConfigClasses(): Array<Class<*>>? {
        return null
    }

    override fun getServletConfigClasses(): Array<Class<*>>? {
        return arrayOf(DemoAppConfig::class.java)
    }
}
