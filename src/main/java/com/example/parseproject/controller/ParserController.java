package com.example.parseproject.controller;

import com.example.helloworldpro.model.Product;
import com.example.parseproject.kafka.MessageProducer;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.parseproject.parser.ParserFactory;

import java.io.IOException;


@RestController
@CrossOrigin("*")
public class ParserController {

    MessageProducer messageProducer;
    @Autowired
    public ParserController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @GetMapping("/api/hello")
    public String getHelloText() throws CsvValidationException, IOException {
        ParserFactory parserFactory = new ParserFactory();
        String result = parserFactory.getParserByFileName("/Users/elizavetakabak/repos/ServiceDemoProject/file3.csv").execute();
        messageProducer.sendMessage("[" + result + "]");
        return "[" + result + "]";
    }
}
