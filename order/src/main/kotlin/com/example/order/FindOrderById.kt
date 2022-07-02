package com.example.order

import com.example.order.domain.OrderRepository

fun interface FindOrderById {
    operator fun invoke(id: Long): OrderDto?

    class Default(
        private val orderRepository: OrderRepository,
    ) : FindOrderById {
        override operator fun invoke(id: Long): OrderDto? {
            return orderRepository.findById(id)?.let {
                OrderDto(
                    id = it.id!!,
                    orderNumber = it.orderNumber
                )
            }
        }
    }
}