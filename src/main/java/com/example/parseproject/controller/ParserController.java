package com.example.parseproject.controller;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import parser.ParserFactory;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class ParserController {

    @GetMapping("/api/hello")
    public String getHelloText() throws CsvValidationException, IOException {
        ParserFactory parser= new ParserFactory();
        return "[" + parser.getParserByFileName("file3.csv").execute() + "]";
    }
}
