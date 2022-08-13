package com.example.order.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val getHello: GetHello,
){

    @GetMapping("/hello")
    fun hello(): String {
        return getHello("Hello World~!")
    }
}
