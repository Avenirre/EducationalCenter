package com.kotlin.educationalcenter.repositories

import com.kotlin.educationalcenter.entities.TutorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TutorsRepository : JpaRepository<TutorEntity, Long> {

    fun existsByFirstNameAndLastName(firstName: String, lastName: String): Boolean
}