package com.example.parseproject;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
@Configuration
public class ParseProjectApplication {

    public static void main(String[] args) throws CsvValidationException, IOException {
        SpringApplication.run(ParseProjectApplication.class, args);
    }
}
