package com.saudeall.app;
import java.time.LocalDate;

import com.saudeall.app.model.Doctor;
import com.saudeall.app.services.DbConnectionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		LocalDate dateNow = LocalDate.of(2000,1,1);
		Doctor johnDorian = new Doctor(1,"John Dorian", "random image", dateNow);
//		DbConnectionService dbService = new DbConnectionService();
//		dbService.connect();
		System.out.println("it worked");
	}


}
