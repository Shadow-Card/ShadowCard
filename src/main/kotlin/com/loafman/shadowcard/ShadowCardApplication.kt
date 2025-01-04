package com.loafman.shadowcard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ShadowCardApplication

fun main(args: Array<String>) {
    runApplication<ShadowCardApplication>(*args)
}

@RestController
@RequestMapping("/api")
class ApiController {

    @GetMapping("/hello")
    fun sayHello(): String {
        return "Hello, World!"
    }
}