package com.example.studentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication {
    public static void main(String[] args) {
    	  System.setProperty("spring.profiles.active", "dev");
        SpringApplication.run(StudentManagementApplication.class, args);
    }
}
