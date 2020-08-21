package com.thijsboehme.springdemo.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import java.util.logging.Logger

@Aspect
@Component
class CRMLoggingAspect {
    // Setup logger
    private val logger = Logger.getLogger(javaClass.name)

    // Setup pointcut declarations
    @Pointcut("execution(* com.thijsboehme.springdemo.controller.*.*(..))")
    private fun forControllerPackage() {
    }

    @Pointcut("execution(* com.thijsboehme.springdemo.service.*.*(..))")
    private fun forServicePackage() {
    }

    @Pointcut("execution(* com.thijsboehme.springdemo.dao.*.*(..))")
    private fun forDAOPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private fun forAppFlow() {
    }

    // Add @Before advice
    @Before("forAppFlow()")
    fun before(joinPoint: JoinPoint) {
        // Display method we are calling
        val method = joinPoint.signature.toShortString()
        logger.info("====>> In @Before: calling method: $method")

        // Display the arguments for the method
        // Get the arguments
        val arguments = joinPoint.args

        // Loop through and display arguments
        arguments.forEach { logger.info("====>> Argument: $it") }
    }

    // Add @AfterReturning advice
    @AfterReturning(
        pointcut = "forAppFlow()",
        returning = "result"
    )
    fun afterReturning(joinPoint: JoinPoint, result: Any) {
        // Display method we are calling
        val method = joinPoint.signature.toShortString()
        logger.info("====>> In @AfterReturning: from method: $method")

        // Display data returned
        logger.info("====>> Result: $result")
    }
}
