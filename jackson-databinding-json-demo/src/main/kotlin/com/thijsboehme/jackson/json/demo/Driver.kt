package com.thijsboehme.jackson.json.demo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File

fun main() {
    // Create object mapper
    val mapper = ObjectMapper().registerKotlinModule()

    // Read JSON file and map/convert to Java POJO:
    // data/sample-lite.json
    // val student = mapper.readValue<Student>(File("data/sample-lite.json"))
    val student = mapper.readValue<Student>(File("data/sample-full.json"))

    // Print first and last name
    println("First name: ${student.firstName}")
    println("Last name: ${student.lastName}")

    // Print out address: street and city
    val address = student.address
    println("Street: ${address.street}")
    println("City: ${address.city}")

    // Print languages
    student.languages.forEach { println(it) }
}
