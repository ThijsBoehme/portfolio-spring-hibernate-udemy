package com.thijsboehme.springdemo.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class StudentRESTExceptionHandler {
    @ExceptionHandler
    fun handleException(exception: StudentNotFoundException): ResponseEntity<StudentErrorResponse> {
        // Create a StudentErrorResponse
        val error = StudentErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exception.message ?: "",
            System.currentTimeMillis()
        )

        // Return ResponseEntity
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleException(exception: Exception): ResponseEntity<StudentErrorResponse> {
        val error = StudentErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            exception.message ?: "",
            System.currentTimeMillis()
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}
