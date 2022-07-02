package com.example.order.application

import com.example.order.CreateOrder
import com.example.order.FindOrderById
import com.example.order.domain.OrderRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration(
    private val orderRepository: OrderRepository,
) {
    @Bean
    fun createOrder(): CreateOrder {
        return CreateOrder.Default(orderRepository)
    }

    @Bean
    fun findOrderById(): FindOrderById {
        return FindOrderById.Default(orderRepository)
    }
}
