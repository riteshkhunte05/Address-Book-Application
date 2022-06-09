package com.bridgelabz.addressBookApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookAppApplication {

	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Application");
		ApplicationContext context = SpringApplication.run(AddressBookAppApplication.class, args);
		log.info("Addressbook App Started in {} Environment",
				context.getEnvironment().getProperty("environment"));
		log.info("Employee Payroll DB User is {}",
				context.getEnvironment().getProperty("spring.datasource.username"));
		log.info("Addressbook App started");
	}

}
