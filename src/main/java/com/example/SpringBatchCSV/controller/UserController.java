package com.example.SpringBatchCSV.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/load")
public class UserController {

    private JobLauncher jobLauncher;

    private Job job;

    public UserController(JobLauncher jobLauncher, @Qualifier("jobCSVToH2")Job job){
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @GetMapping
    public BatchStatus load() throws JobParametersInvalidException,
            JobExecutionAlreadyRunningException,
            JobRestartException,
            JobInstanceAlreadyCompleteException {

        JobExecution jobExecution = jobLauncher.run(job, new JobParametersBuilder()
                .addString("time", LocalDateTime.now().toString())
                .toJobParameters());

        return jobExecution.getStatus();
    }
}
