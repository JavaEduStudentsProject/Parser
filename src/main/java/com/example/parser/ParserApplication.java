package com.example.parser;

import com.example.parser.kafka.MessageListener;
import com.example.parser.parser.ParserCSV;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableScheduling
@Configuration
@Slf4j
public class ParserApplication {

    public static void main(String[] args) throws CsvValidationException, IOException {
        SpringApplication.run(ParserApplication.class, args);
        log.warn("Parser run! " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss")));

        String csv = new ParserCSV("/Users/elizavetakabak/repos/Parser/src/main/resources/file.csv").execute();
        System.out.println(csv);
    }
    @Bean
    public MessageListener messageListener() {
        return new MessageListener();
    }
}
