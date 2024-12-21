package com.kotlin.educationalcenter.utils

import com.kotlin.educationalcenter.entities.TutorEntity
import com.kotlin.educationalcenter.models.TutorRequestDTO
import com.kotlin.educationalcenter.models.TutorResponseDTO
import org.springframework.stereotype.Component

@Component
class TutorsMapper {

    fun toResponseDTO(entity: TutorEntity) =
        TutorResponseDTO(
            id = entity.id,
            firstName = entity.firstName,
            lastName = entity.lastName,
            subject = entity.subject,
            paymentPerHour = entity.paymentPerHour
        )

    fun toEntity(dto: TutorRequestDTO): TutorEntity =
        TutorEntity(
            firstName = dto.firstName,
            lastName = dto.lastName,
            subject = dto.subject,
            paymentPerHour = dto.paymentPerHour
        )

    fun toResponseDTOList(entities: List<TutorEntity>): List<TutorResponseDTO> =
        entities.map(::toResponseDTO)
}