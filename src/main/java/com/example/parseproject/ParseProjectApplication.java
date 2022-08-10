package com.example.parseproject;

import model.Root;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import parser.GsonParser;
import parser.JsonSimpleParser;
import parser.ParserFactory;

@SpringBootApplication
public class ParseProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParseProjectApplication.class, args);
        JsonSimpleParser parser = new JsonSimpleParser();
        Root root = parser.parse();
        System.out.println("(Simple)    Root "+root.toString());// раскомментировать при запуске симпл

        GsonParser gsonParser = new GsonParser();
        Root newRoot = gsonParser.parse();
        System.out.println("(Gson)    Root "+newRoot.toString());

        ParserFactory parserFactory = new ParserFactory();
        System.out.println(parserFactory.getParserByFileName("file2.json").execute());
    }

}
