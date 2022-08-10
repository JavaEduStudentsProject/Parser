package com.example.parseproject;

import model.Root;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.util.BsonUtils;
import parser.GsonParser;
import parser.JsonSimpleParser;
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
//        JsonSimpleParser parser = new JsonSimpleParser();
//        Root root = parser.parse();
//        System.out.println("(Simple)    Root "+root.toString());// раскомментировать при запуске симпл

        GsonParser gsonParser = new GsonParser();
        Root newRoot = gsonParser.parse();
        System.out.println("(Gson)    Root "+newRoot.toString());

		SpringApplication.run(ParseProjectApplication.class, args);
		ParserFactory parserFactory = new ParserFactory();
		System.out.println(parserFactory.getParserByFileName("/Users/elizavetakabak/repos/ServiceDemoProject/src/main/resources/templates/file2.json").execute());
    }

}
