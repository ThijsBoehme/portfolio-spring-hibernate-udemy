package com.thijsboehme.springdemo.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CustomerRESTExceptionHandler {
    @ExceptionHandler
    fun handleException(exception: CustomerNotFoundException): ResponseEntity<CustomerErrorResponse> {
        val response = CustomerErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exception.message ?: "Customer not found",
            System.currentTimeMillis()
        )

        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleException(exception: Exception): ResponseEntity<CustomerErrorResponse> {
        val response = CustomerErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            exception.message ?: "Customer not found",
            System.currentTimeMillis()
        )

        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }
}
