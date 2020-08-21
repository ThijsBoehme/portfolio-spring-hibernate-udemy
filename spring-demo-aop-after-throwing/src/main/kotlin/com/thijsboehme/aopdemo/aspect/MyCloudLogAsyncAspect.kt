package com.thijsboehme.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(1)
class MyCloudLogAsyncAspect {
    @Before("com.thijsboehme.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterSetter()")
    fun logToCloudAsync() {
        println("\n==========>>> Logging to Cloud in async fashion")
    }
}
