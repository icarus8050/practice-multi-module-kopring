package com.example.order

import com.example.order.domain.Order
import com.example.order.domain.OrderRepository

fun interface CreateOrder {
    operator fun invoke(
        orderNumber: String,
    ): String

    class Default(
        private val orderRepository: OrderRepository,
    ) : CreateOrder {
        override operator fun invoke(orderNumber: String): String {
            val order = Order.createBy(orderNumber)
            orderRepository.save(order)
            return order.orderNumber
        }
    }
}
