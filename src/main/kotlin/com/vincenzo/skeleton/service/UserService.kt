package com.vincenzo.skeleton.service

import com.vincenzo.skeleton.domain.entity.User
import com.vincenzo.skeleton.domain.repository.UserRepository
import com.vincenzo.skeleton.dto.UserCreateRequest
import com.vincenzo.skeleton.dto.UserResponse
import com.vincenzo.skeleton.dto.UserUpdateRequest
import com.vincenzo.skeleton.exception.BusinessException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository
) {
    
    fun findAll(pageable: Pageable): Page<UserResponse> {
        return userRepository.findAll(pageable)
            .map { UserResponse.from(it) }
    }
    
    fun findById(id: Long): UserResponse {
        val user = userRepository.findById(id)
            .orElseThrow { BusinessException("사용자를 찾을 수 없습니다. ID: $id") }
        return UserResponse.from(user)
    }
    
    @Transactional
    fun create(request: UserCreateRequest): UserResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw BusinessException("이미 존재하는 이메일입니다: ${request.email}")
        }
        
        val user = User(
            name = request.name,
            email = request.email
        )
        
        val savedUser = userRepository.save(user)
        return UserResponse.from(savedUser)
    }
    
    @Transactional
    fun update(id: Long, request: UserUpdateRequest): UserResponse {
        val user = userRepository.findById(id)
            .orElseThrow { BusinessException("사용자를 찾을 수 없습니다. ID: $id") }
        
        user.name = request.name
        
        return UserResponse.from(user)
    }
    
    @Transactional
    fun delete(id: Long) {
        if (!userRepository.existsById(id)) {
            throw BusinessException("사용자를 찾을 수 없습니다. ID: $id")
        }
        userRepository.deleteById(id)
    }
}