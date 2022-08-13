package com.example.order.component

import com.example.order.api.GetHello

class GetHelloImpl : GetHello {
    override fun invoke(): String {
        return "Hello World!"
    }
}