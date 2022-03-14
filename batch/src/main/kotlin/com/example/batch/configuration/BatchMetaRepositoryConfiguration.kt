package com.example.batch.configuration

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.batch.BatchDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class BatchMetaRepositoryConfiguration {

    @Bean
    @BatchDataSource
    @ConfigurationProperties(prefix = "spring.datasource.batch-meta")
    fun batchMetaDataSource(): DataSource {
        return DataSourceBuilder.create()
            .type(HikariDataSource::class.java)
            .build()
    }
}
