package com.kotlin.educationalcenter.services

import com.kotlin.educationalcenter.models.TutorRequestDTO
import com.kotlin.educationalcenter.models.TutorResponseDTO
import com.kotlin.educationalcenter.repositories.TutorsRepository
import com.kotlin.educationalcenter.utils.TutorsMapper
import org.springframework.stereotype.Service

@Service
class TutorsService(private val tutorsRepository: TutorsRepository,
                    private val tutorsMapper: TutorsMapper
) {

    fun getAllTutors(): List<TutorResponseDTO> = tutorsMapper.toResponseDTOList(tutorsRepository.findAll())

    fun createTutor(tutorRequest: TutorRequestDTO): TutorResponseDTO {
        val tutorEntity = tutorsMapper.toEntity(tutorRequest)
        val savedTutor = tutorsRepository.save(tutorEntity)
        return tutorsMapper.toResponseDTO(savedTutor)
    }
}