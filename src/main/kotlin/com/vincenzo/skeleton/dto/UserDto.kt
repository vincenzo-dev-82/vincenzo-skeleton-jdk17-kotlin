package com.vincenzo.skeleton.dto

import com.vincenzo.skeleton.domain.entity.User
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class UserCreateRequest(
    @field:NotBlank(message = "이름은 필수입니다")
    @field:Size(min = 2, max = 100, message = "이름은 2~100자 사이여야 합니다")
    val name: String,
    
    @field:NotBlank(message = "이메일은 필수입니다")
    @field:Email(message = "올바른 이메일 형식이 아닙니다")
    val email: String
)

data class UserUpdateRequest(
    @field:NotBlank(message = "이름은 필수입니다")
    @field:Size(min = 2, max = 100, message = "이름은 2~100자 사이여야 합니다")
    val name: String
)

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun from(user: User): UserResponse {
            return UserResponse(
                id = user.id,
                name = user.name,
                email = user.email,
                createdAt = user.createdAt,
                updatedAt = user.updatedAt
            )
        }
    }
}