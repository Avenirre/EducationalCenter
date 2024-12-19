package com.kotlin.educationalcenter.entities

import jakarta.persistence.*

@Entity
@Table(name = "tutors")
data class TutorEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "first_name", nullable = false)
    val firstName: String,

    @Column(name = "last_name", nullable = false)
    val lastName: String,

    @Column(name = "subject", nullable = false)
    var subject: String,

    @Column(name = "payment_per_hour", nullable = false)
    var paymentPerHour: Float

)