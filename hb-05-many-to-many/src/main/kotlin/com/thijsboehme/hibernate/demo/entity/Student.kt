package com.thijsboehme.hibernate.demo.entity

import javax.persistence.*

@Entity
@Table(name = "student")
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int,

    @Column(name = "first_name")
    var firstName: String?,

    @Column(name = "last_name")
    var lastName: String?,

    @Column(name = "email")
    var email: String?,

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH]
    )
    @JoinTable(
        name = "course_student",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [JoinColumn(name = "course_id")]
    )
    var courses: MutableList<Course>
) {
    constructor(firstName: String?, lastName: String?, email: String?): this(0, firstName, lastName, email, ArrayList())

//    fun add(course: Course) {
//        courses.add(course)
//    }

    override fun toString(): String {
        return "Student(id=$id, firstName=$firstName, lastName=$lastName, email=$email)"
    }
}
