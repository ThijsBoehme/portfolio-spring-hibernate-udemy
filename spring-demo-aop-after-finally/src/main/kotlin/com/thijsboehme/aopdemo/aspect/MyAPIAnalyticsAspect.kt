package com.thijsboehme.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(3)
class MyAPIAnalyticsAspect {
    @Before("com.thijsboehme.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterSetter()")
    fun performAPIAnalytics() {
        println("\n==========>>> Performing API Analytics")
    }
}
