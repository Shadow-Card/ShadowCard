package com.loafman.shadowcard.util

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtUtil {

    private val secretKey: SecretKey = Keys.hmacShaKeyFor(ByteArray(32).apply { Random().nextBytes(this) })

    fun generateToken(username: String): String {
        return Jwts.builder()
            .claim("sub", username)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 小时有效期
            .signWith(secretKey)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser().verifyWith(secretKey).build().parse(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun extractUsername(token: String): String {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parse(token)
            .payload.toString()
    }
}
