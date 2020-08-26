package com.thijsboehme.springboot.thymeleafdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ThymeleafDemoApplication

fun main(args: Array<String>) {
    runApplication<ThymeleafDemoApplication>(*args)
}
