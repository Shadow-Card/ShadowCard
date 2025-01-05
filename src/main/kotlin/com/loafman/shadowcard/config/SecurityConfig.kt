package com.loafman.shadowcard.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableMethodSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() } // 使用 lambda 配置 CSRF
            .authorizeHttpRequests {
                it.requestMatchers("/api/products").permitAll()
                    .anyRequest().authenticated()
            }
            .httpBasic { it.disable() }
        return http.build()
    }
}

