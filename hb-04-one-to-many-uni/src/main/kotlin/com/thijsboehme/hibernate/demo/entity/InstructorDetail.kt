package com.thijsboehme.hibernate.demo.entity

import javax.persistence.*

@Entity
@Table(name = "instructor_detail")
class InstructorDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int,

    @Column(name = "youtube_channel")
    var youtubeChannel: String?,

    @Column(name = "hobby")
    var hobby: String?,

    @OneToOne(mappedBy = "instructorDetail",
        cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH])
    var instructor: Instructor?
) {
    constructor(youtubeChannel: String?, hobby: String?): this(0, youtubeChannel, hobby, null)

    override fun toString(): String {
        return "InstructorDetail(id=$id, youtubeChannel='$youtubeChannel', hobby='$hobby')"
    }
}
