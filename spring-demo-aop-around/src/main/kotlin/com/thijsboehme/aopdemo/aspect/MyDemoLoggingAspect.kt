package com.thijsboehme.aopdemo.aspect

import com.thijsboehme.aopdemo.Account
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
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
                println("Account level: ${argument.level}")
            }
        }
    }

    // Add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
        pointcut = "execution(* com.thijsboehme.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning = "result"
    )
    fun afterReturningFindAccountsAdvice(joinPoint: JoinPoint, result: List<Account>) {
        // Print out which method we are advising on
        val methodSignature = joinPoint.signature.toShortString()
        println()
        println("==========>>> Executing @AfterReturning on method: $methodSignature")

        // Print out the results of the method call
        println("==========>>> Result is: $result")

        // Let's post-process the data ... let's modify it!
        // Convert the account names to uppercase
        convertAccountNamesToUppercase(result)
    }

    @AfterThrowing(
        pointcut = "execution(* com.thijsboehme.aopdemo.dao.AccountDAO.findAccounts(..))",
        throwing = "exception"
    )
    fun afterThrowingFindAccountsAdvice(joinPoint: JoinPoint, exception: Throwable) {
        // Print out which method we are advising on
        val methodSignature = joinPoint.signature.toShortString()
        println()
        println("==========>>> Executing @AfterThrowing on method: $methodSignature")

        // Log the exception
        println()
        println("==========>>> The exception is: $exception")
    }

    @After("execution(* com.thijsboehme.aopdemo.dao.AccountDAO.findAccounts(..))")
    fun afterFinallyFindAccountsAdvice(joinPoint: JoinPoint) {
        // Print out which method we are advising on
        val methodSignature = joinPoint.signature.toShortString()
        println()
        println("==========>>> Executing @After (finally) on method: $methodSignature")
    }

    @Around("execution(* com.thijsboehme.aopdemo.service.*.getFortune(..))")
    fun aroundGetFortune(proceedingJoinPoint: ProceedingJoinPoint): Any? {
        // Print out which method we are advising on
        val methodSignature = proceedingJoinPoint.signature.toShortString()
        println()
        println("==========>>> Executing @Around on method: $methodSignature")

        // Get begin timestamp
        val begin = System.currentTimeMillis()

        // Execute the method
        val result = proceedingJoinPoint.proceed()

        // Get end timestamp
        val end = System.currentTimeMillis()

        // Compute duration and display it
        val duration = end - begin
        println()
        println("==========>>> Duration: ${duration / 1000.0} seconds")

        return result
    }

    private fun convertAccountNamesToUppercase(list: List<Account>) {
        list.forEach { it.name = it.name.toUpperCase() }
    }
}
