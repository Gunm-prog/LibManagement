package com.gunmProg.LibManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.gunmProg.libManagement"})
public class LibManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibManagementApplication.class, args);
	}

}
