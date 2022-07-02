package com.example.order.config

import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource")
    fun datasource(): DataSource {
        return DataSourceBuilder.create()
            .type(HikariDataSource::class.java)
            .build()
    }
}
