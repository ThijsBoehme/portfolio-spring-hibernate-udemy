package com.thijsboehme.springboot.cruddemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrudDemoApplication

fun main(args: Array<String>) {
    runApplication<CrudDemoApplication>(*args)
}
