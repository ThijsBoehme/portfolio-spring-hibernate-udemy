package com.thijsboehme.hibernate.demo.entity

import javax.persistence.*

@Entity
@Table(name = "review")
class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int,

    @Column(name = "comment")
    var comment: String?//,

//    @ManyToOne(cascade = [CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH])
//    @JoinColumn(name = "course_id")
//    var course: Course?
) {
    constructor(comment: String?): this(0, comment/*, null*/)

    override fun toString(): String {
        return "Review(id=$id, comment=$comment)"
    }
}
