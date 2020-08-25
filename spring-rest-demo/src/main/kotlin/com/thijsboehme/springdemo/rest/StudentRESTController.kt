package com.thijsboehme.springdemo.rest

import com.thijsboehme.springdemo.entity.Student
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class StudentRESTController {
    /**
     * Define endpoint for "/students": return a list of all students
     */
    @GetMapping("/students")
    fun showStudents(): List<Student> {
        return listOf(
            Student("Poornima", "Patel"),
            Student("Mario", "Rossi"),
            Student("Mary", "Smith")
        )
    }
}
