package com.loafman.shadowcard.controller

import com.loafman.shadowcard.util.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val jwtUtil: JwtUtil
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        // 假设认证逻辑简单，只检查用户名是否为 "user" 和密码是否为 "password"
        return if (request.username == "user" && request.password == "password") {
            val token = jwtUtil.generateToken(request.username)
            ResponseEntity.ok(mapOf("token" to token))
        } else {
            ResponseEntity.status(401).body("Invalid username or password")
        }
    }
}

data class LoginRequest(
    val username: String,
    val password: String
)
