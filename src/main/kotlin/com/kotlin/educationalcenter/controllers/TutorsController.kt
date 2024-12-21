package com.kotlin.educationalcenter.controllers

import com.kotlin.educationalcenter.models.TutorDTO
import com.kotlin.educationalcenter.services.TutorsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tutors")
class TutorsController(private val tutorsService: TutorsService) {

    @GetMapping
    fun getAllTutors(): ResponseEntity<List<TutorDTO>> = ResponseEntity.ok(tutorsService.getAllTutors())

    @PostMapping
    fun createTutor(@RequestBody tutorDTO: TutorDTO): ResponseEntity<TutorDTO> {
        val createdTutor = tutorsService.createTutor(tutorDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTutor)
    }


}