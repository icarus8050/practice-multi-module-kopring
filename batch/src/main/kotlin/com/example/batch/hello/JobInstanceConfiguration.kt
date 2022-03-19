package com.example.batch.hello

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JobInstanceConfiguration(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
) {

    @Bean
    fun job(): Job {
        return jobBuilderFactory.get("job")
            .start(step1())
            .next(step2())
            .build()
    }

    @Bean
    fun step1(): Step {
        return stepBuilderFactory["step1"]
            .tasklet { contribution, chunkContext ->
                val jobParameters = contribution.stepExecution.jobParameters
                println(
                    """
                        ${jobParameters.getString("name")}
                        ${jobParameters.getLong("seq")}
                        ${jobParameters.getDate("date")}
                        ${jobParameters.getDouble("age")}
                    """.trimIndent()
                )

                return@tasklet RepeatStatus.FINISHED
            }.build()
    }

    @Bean
    fun step2(): Step {
        return stepBuilderFactory["step2"]
            .tasklet { contribution, chunkContext ->
                return@tasklet RepeatStatus.FINISHED
            }.build()
    }
}