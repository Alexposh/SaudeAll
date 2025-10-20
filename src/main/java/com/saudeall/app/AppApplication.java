package com.saudeall.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import com.saudeall.app.services.PatientService;

@EnableAsync
@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
@ConfigurationPropertiesScan
public class AppApplication {

    public static void main(String[] args) {
        System.out.println("Starting the application...");
        ApplicationContext context = SpringApplication.run(AppApplication.class, args);

        System.out.println("Application started!");
    }

}
