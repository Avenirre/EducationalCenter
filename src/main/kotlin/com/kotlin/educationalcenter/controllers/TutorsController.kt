package com.kotlin.educationalcenter.controllers

import com.kotlin.educationalcenter.models.TutorRequestDTO
import com.kotlin.educationalcenter.models.TutorResponseDTO
import com.kotlin.educationalcenter.services.TutorsService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Tutors", description = "Tutors API")
@RestController
@RequestMapping("/api/v1/tutors")
class TutorsController(private val tutorsService: TutorsService) {

    @GetMapping
    @Operation(
        summary = "Get all the tutors",
        description = "Returns the list of all the tutors in the system"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "List of tutors got successfully")
    ])
    fun getAllTutors(): ResponseEntity<List<TutorResponseDTO>> = ResponseEntity.ok(tutorsService.getAllTutors())

    @PostMapping
    @Operation(
        summary = "Create a new tutor",
        description = "Creates a new tutor in the system"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "The tutor is created successfully"),
        ApiResponse(responseCode = "400", description = "Incorrect response data")
    ])
    fun createTutor(@RequestBody tutorRequest: TutorRequestDTO): ResponseEntity<TutorResponseDTO> {
        val createdTutor = tutorsService.createTutor(tutorRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTutor)
    }


}