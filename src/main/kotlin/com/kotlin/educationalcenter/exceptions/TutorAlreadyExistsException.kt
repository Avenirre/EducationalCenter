package com.kotlin.educationalcenter.exceptions

class TutorAlreadyExistsException(firstName: String, lastName: String) :
    RuntimeException("Tutor with name $firstName $lastName already exists")