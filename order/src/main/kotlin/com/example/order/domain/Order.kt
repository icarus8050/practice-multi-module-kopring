package com.example.order.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "simple_order")
@Entity
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var orderNumber: String,
) {
    companion object {
        fun createBy(orderNumber: String): Order {
            return Order(
                id = null,
                orderNumber = orderNumber,
            )
        }
    }
}
