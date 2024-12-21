package com.kotlin.educationalcenter.exceptions

class TutorNotFoundException(id: Long) : RuntimeException("Tutor with id $id not found")