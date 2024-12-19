package com.kotlin.educationalcenter.controllers

import com.kotlin.educationalcenter.models.TutorDTO
import com.kotlin.educationalcenter.services.TutorsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/tutors")
class TutorsController(private val tutorsService: TutorsService) {

    @GetMapping
    fun getAllTutors(): ResponseEntity<List<TutorDTO>> = ResponseEntity.ok(tutorsService.getAllTutors())


}