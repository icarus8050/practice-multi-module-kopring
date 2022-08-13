package com.example.order.api

fun interface GetHello {
    operator fun invoke(value: String): String
}
