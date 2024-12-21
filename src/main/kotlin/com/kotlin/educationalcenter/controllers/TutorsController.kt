package com.kotlin.educationalcenter.controllers

import com.kotlin.educationalcenter.models.TutorRequestDTO
import com.kotlin.educationalcenter.models.TutorResponseDTO
import com.kotlin.educationalcenter.services.TutorsService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Tutors", description = "Tutors API")
@RestController
@RequestMapping("/api/v1/tutors")
class TutorsController(private val tutorsService: TutorsService) {

    @GetMapping
    @Operation(summary = "Get all the tutors",)
    fun getAllTutors(): ResponseEntity<List<TutorResponseDTO>> = ResponseEntity.ok(tutorsService.getAllTutors())

    @GetMapping("/{id}")
    @Operation(summary = "Find tutor by id")
    fun getTutorById(@PathVariable id: Long): ResponseEntity<TutorResponseDTO> = ResponseEntity.ok(tutorsService.getTutorById(id))

    @PostMapping
    @Operation(summary = "Create a new tutor")
    fun createTutor(@RequestBody tutorRequest: TutorRequestDTO): ResponseEntity<TutorResponseDTO> {
        val createdTutor = tutorsService.createTutor(tutorRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTutor)
    }
}