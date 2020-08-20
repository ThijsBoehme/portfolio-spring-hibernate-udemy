package com.thijsboehme.hibernate.demo.entity

import javax.persistence.*

@Entity
@Table(name = "instructor")
class Instructor(
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

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "instructor_detail_id")
    var instructorDetail: InstructorDetail?,

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "instructor",
        cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH]
    )
    var courses: MutableList<Course>?
) {
    constructor(firstName: String?, lastName: String?, email: String?): this(0, firstName, lastName, email, null, null)

    fun add(course: Course) {
        if (courses == null) {
            courses = ArrayList()
        }

        courses!!.add(course)
        course.instructor = this
    }

    override fun toString(): String {
        return "Instructor(id=$id, firstName='$firstName', lastName='$lastName', email='$email', instructorDetail=$instructorDetail)"
    }
}
