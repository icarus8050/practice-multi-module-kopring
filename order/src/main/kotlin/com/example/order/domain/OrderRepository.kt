package com.example.order.domain

interface OrderRepository {
    fun findById(id: Long): Order?
    fun save(order: Order): Order
}
