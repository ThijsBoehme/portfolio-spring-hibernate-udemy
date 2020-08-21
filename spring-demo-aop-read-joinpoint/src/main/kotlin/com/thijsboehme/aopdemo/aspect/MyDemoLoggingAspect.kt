package com.thijsboehme.aopdemo.aspect

import com.thijsboehme.aopdemo.Account
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(2)
class MyDemoLoggingAspect {
    @Before("com.thijsboehme.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterSetter()")
    fun beforeAddAccountAdvice(joinPoint: JoinPoint) {
        println("\n==========>>> Executing @Before advice on method")

        // Display the method signature
        val methodSignature = joinPoint.signature as MethodSignature
        println("Method: $methodSignature")

        // Display the method arguments
        // Get the arguments
        val methodArguments = joinPoint.args

        // Loop through the arguments
        for (argument in methodArguments) {
            println("Argument: $argument")
            if (argument is Account) {
                // Downcast and print Account specific stuff
                println("Account name: ${argument.name}")
                println("Account email: ${argument.email}")
            }
        }
    }
}
