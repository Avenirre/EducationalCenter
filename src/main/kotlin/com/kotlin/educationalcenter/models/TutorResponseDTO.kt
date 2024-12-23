package com.kotlin.educationalcenter.models

data class TutorResponseDTO(

    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    var subject: String,
    var paymentPerHour: Float
)