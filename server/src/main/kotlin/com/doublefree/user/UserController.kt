package com.doublefree.user

import com.doublefree.api.UserApi
import com.doublefree.api.model.UserDto
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) : UserApi {

    @PreAuthorize("isAuthenticated()")
    override fun getCurrentUser(): ResponseEntity<UserDto> = ResponseEntity.ok(userService.currentUser())

    @PreAuthorize("hasAuthority(T(com.doublefree.api.model.Authority).DELETE_USER)")
    override fun deleteUser(id: Long): ResponseEntity<Unit> {
        userService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PreAuthorize("hasAuthority(T(com.doublefree.api.model.Authority).VIEW_USER)")
    override fun getUsers(): ResponseEntity<List<UserDto>> = ResponseEntity.ok(userService.getUsers())
}
