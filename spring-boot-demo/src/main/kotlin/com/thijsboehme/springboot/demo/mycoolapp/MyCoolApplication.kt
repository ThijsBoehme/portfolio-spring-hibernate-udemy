package com.thijsboehme.springboot.demo.mycoolapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyCoolApplication

fun main(args: Array<String>) {
    runApplication<MyCoolApplication>(*args)
}
