package com.example.parseproject.controller;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.web.bind.annotation.*;
import parser.ParserFactory;

import java.io.IOException;


@RestController
@CrossOrigin("*")
public class ParserController {

    @GetMapping("/api/hello")
    public String getHelloText() throws CsvValidationException, IOException {
        ParserFactory parserFactory = new ParserFactory();

        String result = parserFactory.getParserByFileName("file3.csv").execute();
        return "[" + result + "]";
    }
}
