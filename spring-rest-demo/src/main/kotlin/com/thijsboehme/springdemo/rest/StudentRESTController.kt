package com.thijsboehme.springdemo.rest

import com.thijsboehme.springdemo.entity.Student
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/api")
class StudentRESTController {
    private lateinit var studentList: List<Student>

    /**
     * Define @PostConstruct to load the student data ... only once!
     */
    @PostConstruct
    private fun loadData() {
        studentList = listOf(
            Student("Poornima", "Patel"),
            Student("Mario", "Rossi"),
            Student("Mary", "Smith")
        )
    }

    /**
     * Define endpoint for "/students": return a list of all students
     */
    @GetMapping("/students")
    fun showStudents(): List<Student> {
        return studentList
    }

    @GetMapping("/students/{studentID}")
    fun getStudent(@PathVariable studentID: Int): Student {
        return studentList[studentID]
    }
}
