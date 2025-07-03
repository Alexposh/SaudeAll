package com.saudeall.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import com.saudeall.app.services.PatientService;

@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan
public class AppApplication {

    public static void main(String[] args) {
        System.out.println("Starting the application...");
        ApplicationContext context = SpringApplication.run(AppApplication.class, args);

        // Retrieve PatientService bean
        PatientService patientService = context.getBean(PatientService.class);

        System.out.println("Getting All Patients...");
        System.out.println(patientService.getAll());

        System.out.println("Create new Patient...");
        patientService.add();

        System.out.println("Getting All Patients...");
        System.out.println(patientService.getAll());

        System.out.println("it worked");
    }

}
