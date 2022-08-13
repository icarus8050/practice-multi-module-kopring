package com.example.order.configuration

import com.example.order.api.GetHello
import com.example.order.component.GetHelloImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {

    @Bean
    fun getHello(): GetHello {
        return GetHelloImpl()
    }
}
