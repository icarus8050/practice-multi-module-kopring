package com.example.order.api

import com.fasterxml.jackson.databind.ObjectMapper
import io.mockk.every
import io.mockk.mockk
import io.restassured.config.ObjectMapperConfig
import io.restassured.module.mockmvc.RestAssuredMockMvc
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder
import org.springframework.web.filter.CharacterEncodingFilter

internal class HelloControllerTest {
    private var getHello: GetHello = mockk()
    private var helloController: HelloController = HelloController(
        getHello = getHello
    )

    @BeforeEach
    fun init() {
        val objectMapper = Jackson2ObjectMapperBuilder.json().build<ObjectMapper>()

        RestAssuredMockMvc.standaloneSetup(
            MockMvcBuilders.standaloneSetup(helloController)
                .addFilter<StandaloneMockMvcBuilder?>(CharacterEncodingFilter("UTF-8", true))
                .setMessageConverters(
                    StringHttpMessageConverter(),
                    MappingJackson2HttpMessageConverter(objectMapper)
                )
        )

        RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails()
        RestAssuredMockMvc.config = RestAssuredMockMvcConfig.config().objectMapperConfig(
            ObjectMapperConfig().jackson2ObjectMapperFactory { _, _ -> objectMapper }
        )
    }

    @Test
    fun helloTest() {
        every { getHello.invoke(any()) } returns "Hello World~!"

        RestAssuredMockMvc.given()
            .get("/hello")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString()
    }
}
