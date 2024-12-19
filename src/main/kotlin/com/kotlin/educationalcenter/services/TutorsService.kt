package com.kotlin.educationalcenter.services

import com.kotlin.educationalcenter.models.TutorDTO
import com.kotlin.educationalcenter.repositories.TutorsRepository
import com.kotlin.educationalcenter.utils.TutorsMapper
import org.springframework.stereotype.Service

@Service
class TutorsService(private val tutorsRepository: TutorsRepository,
                    private val tutorsMapper: TutorsMapper
) {

    fun getAllTutors(): List<TutorDTO> = tutorsMapper.toDTOList(tutorsRepository.findAll())
}