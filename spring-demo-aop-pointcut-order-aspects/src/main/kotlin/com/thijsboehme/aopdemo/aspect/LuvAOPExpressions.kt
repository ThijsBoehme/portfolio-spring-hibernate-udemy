package com.thijsboehme.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

@Aspect
class LuvAOPExpressions {
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
}
