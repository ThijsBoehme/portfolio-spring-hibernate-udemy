package com.thijsboehme.springdemo.mvc

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/student")
class StudentController {
    @RequestMapping("/showForm")
    fun showForm(model: Model): String {
        // Create new Student object
        val student = Student()

        // Add Student object to the model
        model.addAttribute("student", student)

        return "student-form"
    }

    @RequestMapping("/processForm")
    fun processForm(@ModelAttribute("student") student: Student): String {
        // Log the input data
        println("student: ${student.firstName} ${student.lastName}")
        return "student-confirmation"
    }
}
