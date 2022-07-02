package com.example.order.api

import com.example.order.FindOrderById
import com.example.order.OrderDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindOrderController(
    private val findOrderById: FindOrderById,
) {
    @GetMapping("/order/{id}")
    fun findOrder(@PathVariable id: Long): OrderDto? {
        return findOrderById(id)
    }
}
