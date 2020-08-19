package com.thijsboehme.hibernate.demo.entity

import javax.persistence.*

@Entity
@Table(name = "course")
class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int,

    @Column(name = "title")
    var title: String?,

    @ManyToOne(cascade = [CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH])
    @JoinColumn(name = "instructor_id")
    var instructor: Instructor?
) {
    constructor(title: String?): this(0, title, null)

    override fun toString(): String {
        return "Course(id=$id, title=$title)"
    }
}
