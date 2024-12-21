package com.kotlin.educationalcenter.services

import com.kotlin.educationalcenter.models.TutorRequestDTO
import com.kotlin.educationalcenter.models.TutorResponseDTO
import com.kotlin.educationalcenter.repositories.TutorsRepository
import com.kotlin.educationalcenter.utils.TutorsMapper
import org.springframework.stereotype.Service
import com.kotlin.educationalcenter.exceptions.TutorNotFoundException

@Service
class TutorsService(private val tutorsRepository: TutorsRepository,
                    private val tutorsMapper: TutorsMapper
) {

    fun getAllTutors(): List<TutorResponseDTO> = tutorsMapper.toResponseDTOList(tutorsRepository.findAll())

    fun getTutorById(id: Long): TutorResponseDTO =
        tutorsRepository.findById(id)
            .map(tutorsMapper::toResponseDTO)
            .orElseThrow { TutorNotFoundException(id) }

    fun createTutor(tutorRequest: TutorRequestDTO): TutorResponseDTO {
        val tutorEntity = tutorsMapper.toEntity(tutorRequest)
        val savedTutor = tutorsRepository.save(tutorEntity)
        return tutorsMapper.toResponseDTO(savedTutor)
    }
}