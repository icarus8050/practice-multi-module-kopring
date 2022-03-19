package com.example.batch.hello

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.*

@Component
class JobParameterTest(
    val jobLauncher: JobLauncher,
    val job: Job,
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val jobParameters = JobParametersBuilder()
            .addString("name", "user1")
            .addLong("seq", 2L)
            .addDate("date", Date())
            .addDouble("age", 16.5)
            .toJobParameters()

        jobLauncher.run(job, jobParameters)
    }
}