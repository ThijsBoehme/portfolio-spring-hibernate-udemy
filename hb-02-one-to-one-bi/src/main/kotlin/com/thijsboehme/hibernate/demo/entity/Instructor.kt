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
    var instructorDetail: InstructorDetail?
) {
    constructor(firstName: String?, lastName: String?, email: String?): this(0, firstName, lastName, email, null)

    override fun toString(): String {
        return "Instructor(id=$id, firstName='$firstName', lastName='$lastName', email='$email', instructorDetail=$instructorDetail)"
    }
}
