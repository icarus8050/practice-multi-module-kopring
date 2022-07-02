package com.example.order.jparepository

import com.example.order.domain.Order
import com.example.order.domain.OrderRepository
import org.springframework.data.jpa.repository.JpaRepository

interface OrderJpaRepository :
    OrderRepository,
    JpaRepository<Order, Long>
