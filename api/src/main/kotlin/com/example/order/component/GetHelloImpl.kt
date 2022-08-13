package com.example.order.component

import com.example.order.api.GetHello

class GetHelloImpl : GetHello {
    override fun invoke(value: String): String {
        return value
    }
}