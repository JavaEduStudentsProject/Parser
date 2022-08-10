package com.example.parseproject;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import parser.Parser;
import parser.ParserCSV;
import parser.ParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ParseProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(ParseProjectApplication.class, args);
		ParserFactory parserFactory = new ParserFactory();
		System.out.println(parserFactory.getParserByFileName("/Users/elizavetakabak/repos/ServiceDemoProject/src/main/resources/templates/file2.json").execute());
	}
}
