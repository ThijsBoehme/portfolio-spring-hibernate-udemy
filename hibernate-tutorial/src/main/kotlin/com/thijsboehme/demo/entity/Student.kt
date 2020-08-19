package com.thijsboehme.demo.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "student")
class Student(
    @Id
    @Column(name = "id")
    var id: Int,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(name = "email")
    var email: String
) {
    constructor(firstName: String, lastName: String, email: String): this(0, firstName, lastName, email)

    override fun toString(): String {
        return "Student(id=$id, firstName='$firstName', lastName='$lastName', email='$email')"
    }
}
