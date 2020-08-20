package com.thijsboehme.springdemo.entity

import javax.persistence.*

@Entity
@Table(name = "customer")
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(name = "first_name")
    var firstName: String?,

    @Column(name = "last_name")
    var lastName: String?,

    @Column(name = "email")
    var email: String?
) {
    // constructor(firstName: String?, lastName: String?, email: String?): this(0, firstName, lastName, email)

    override fun toString(): String {
        return "Customer(id=$id, firstName=$firstName, lastName=$lastName, email=$email)"
    }
}
