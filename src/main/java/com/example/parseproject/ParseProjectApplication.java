package com.example.parseproject;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import parser.ParserFactory;

import java.io.IOException;

@SpringBootApplication
public class ParseProjectApplication {

    public static void main(String[] args) throws IOException, CsvValidationException {
        SpringApplication.run(ParseProjectApplication.class, args);

        ParserFactory parserFactory = new ParserFactory();
        System.out.println(parserFactory.getParserByFileName("file3.csv").execute());

    }
}
