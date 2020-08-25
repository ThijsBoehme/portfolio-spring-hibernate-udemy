package com.thijsboehme.springdemo.entity

import javax.persistence.*

@Entity
@Table(name = "customer")
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int,

    @Column(name = "first_name")
    var firstName: String?,

    @Column(name = "last_name")
    var lastName: String?,

    @Column(name = "email")
    var email: String?
) {
    override fun toString(): String {
        return "Customer(id=$id, firstName=$firstName, lastName=$lastName, email=$email)"
    }
}
