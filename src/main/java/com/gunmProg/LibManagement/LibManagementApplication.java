package com.gunmProg.LibManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.gunmProg.LibManagement"})
public class LibManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibManagementApplication.class, args);
	}

}
