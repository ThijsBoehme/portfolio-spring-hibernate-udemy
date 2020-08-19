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
    var instructor: Instructor?,

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    )
    @JoinColumn(name = "course_id")
    var reviews: MutableList<Review>
) {
    constructor(title: String?): this(0, title, null, ArrayList())

    fun add(review: Review) {
//        if (reviews == null) {
//            reviews = ArrayList()
//        }

        reviews/*!!*/.add(review)
        // review.course = this
    }

    override fun toString(): String {
        return "Course(id=$id, title=$title)"
    }
}
