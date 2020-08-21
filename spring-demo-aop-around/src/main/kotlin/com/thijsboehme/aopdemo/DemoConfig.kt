package com.thijsboehme.aopdemo

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.thijsboehme.aopdemo")
class DemoConfig {
}
