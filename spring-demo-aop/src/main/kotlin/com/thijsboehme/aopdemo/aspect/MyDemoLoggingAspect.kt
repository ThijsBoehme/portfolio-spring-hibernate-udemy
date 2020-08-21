package com.thijsboehme.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class MyDemoLoggingAspect {
    // This is where we add all of our related advices for logging

    // Let's start with an @Before advice
    @Before("execution(* add*())")
    fun beforeAddAccountAdvice() {
        println("\n==========>>> Executing @Before advice on method addAccount()\n")
    }
}
