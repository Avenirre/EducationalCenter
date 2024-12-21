package com.kotlin.educationalcenter.models

data class TutorRequestDTO(
    val firstName: String,
    val lastName: String,
    val subject: String,
    val paymentPerHour: Float
)