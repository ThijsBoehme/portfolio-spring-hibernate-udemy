package com.thijsboehme.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

@Aspect
@Component
class MyDemoLoggingAspect {
    // This is where we add all of our related advices for logging

    // Let's start with an @Before advice
    @Pointcut("execution(* com.thijsboehme.aopdemo.dao.*.*(..))")
    fun forDAOPackage() {
    }

    // Create pointcut for getter methods
    @Pointcut("execution(* com.thijsboehme.aopdemo.dao.*.get*(..))")
    fun getter() {
    }

    // Create pointcut for setter methods
    @Pointcut("execution(* com.thijsboehme.aopdemo.dao.*.set*(..))")
    fun setter() {
    }

    // Create pointcut to include package but exclude getter/setter
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    fun forDAOPackageNoGetterSetter() {
    }

    @Before("forDAOPackageNoGetterSetter()")
    fun beforeAddAccountAdvice() {
        println("\n==========>>> Executing @Before advice on method")
    }

    @Before("forDAOPackageNoGetterSetter()")
    fun performAPIAnalytics() {
        println("\n==========>>> Performing API Analytics")
    }
}
