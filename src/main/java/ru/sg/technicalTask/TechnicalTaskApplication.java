package ru.sg.technicalTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TechnicalTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalTaskApplication.class, args);
	}

}
