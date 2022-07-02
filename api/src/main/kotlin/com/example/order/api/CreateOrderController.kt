package com.example.order.api

import com.example.order.CreateOrder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateOrderController(
    private val createOrder: CreateOrder,
) {

    @PostMapping("/order")
    fun createOrderByOrderNumber(
        @RequestBody createOrderRequest: CreateOrderRequest,
    ): String {
        return createOrder(createOrderRequest.orderNumber)
    }
}

data class CreateOrderRequest(
    val orderNumber: String,
)
