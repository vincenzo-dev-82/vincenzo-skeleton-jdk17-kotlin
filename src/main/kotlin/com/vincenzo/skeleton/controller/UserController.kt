package com.vincenzo.skeleton.controller

import com.vincenzo.skeleton.dto.UserCreateRequest
import com.vincenzo.skeleton.dto.UserResponse
import com.vincenzo.skeleton.dto.UserUpdateRequest
import com.vincenzo.skeleton.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Tag(name = "User", description = "사용자 관리 API")
@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {
    
    @Operation(summary = "사용자 목록 조회", description = "페이징된 사용자 목록을 조회합니다")
    @GetMapping
    fun getUsers(
        @PageableDefault(size = 20) pageable: Pageable
    ): Page<UserResponse> {
        return userService.findAll(pageable)
    }
    
    @Operation(summary = "사용자 상세 조회", description = "ID로 사용자를 조회합니다")
    @GetMapping("/{id}")
    fun getUser(
        @Parameter(description = "사용자 ID") @PathVariable id: Long
    ): UserResponse {
        return userService.findById(id)
    }
    
    @Operation(summary = "사용자 생성", description = "새로운 사용자를 생성합니다")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(
        @Valid @RequestBody request: UserCreateRequest
    ): UserResponse {
        return userService.create(request)
    }
    
    @Operation(summary = "사용자 수정", description = "기존 사용자 정보를 수정합니다")
    @PutMapping("/{id}")
    fun updateUser(
        @Parameter(description = "사용자 ID") @PathVariable id: Long,
        @Valid @RequestBody request: UserUpdateRequest
    ): UserResponse {
        return userService.update(id, request)
    }
    
    @Operation(summary = "사용자 삭제", description = "사용자를 삭제합니다")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(
        @Parameter(description = "사용자 ID") @PathVariable id: Long
    ) {
        userService.delete(id)
    }
}