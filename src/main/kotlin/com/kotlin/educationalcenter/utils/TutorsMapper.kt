package com.kotlin.educationalcenter.utils

import com.kotlin.educationalcenter.entities.TutorEntity
import com.kotlin.educationalcenter.models.TutorDTO
import org.springframework.stereotype.Component

@Component
class TutorsMapper {

    fun toDTO(entity: TutorEntity) =
        TutorDTO(
            id = entity.id,
            firstName = entity.firstName,
            lastName = entity.lastName,
            subject = entity.subject,
            paymentPerHour = entity.paymentPerHour
        )

    fun toEntity(dto: TutorDTO): TutorEntity =
        TutorEntity(
            id = dto.id,
            firstName = dto.firstName,
            lastName = dto.lastName,
            subject = dto.subject,
            paymentPerHour = dto.paymentPerHour
        )

    fun toDTOList(entities: List<TutorEntity>): List<TutorDTO> =
        entities.map(::toDTO)
}