package com.example.parseproject.controller;

import com.example.parseproject.kafka.MessageProducer;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;
import com.example.parseproject.parser.ParserFactory;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@CrossOrigin("*")
public class ParserController {
    MessageProducer messageProducer;
    @Autowired
    public ParserController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @KafkaListener(topics = "topicFrontToParser", containerFactory = "kafkaListenerFileContainerFactory")
    public void listener(File fileName) throws CsvValidationException, IOException {
        log.info("Listener parser: File {} received, topicFrontToParser ", fileName.getName());
        ParserFactory parserFactory = new ParserFactory();
        String result = parserFactory.getParserByFileName(String.valueOf(fileName)).execute();
        messageProducer.sendMessage("[" + result + "]", "parser");
        log.info("Producer parser: String to orchestrator, parser");

    }
//    MessageProducer messageProducer;
//    @Autowired
//    public ParserController(MessageProducer messageProducer) {
//        this.messageProducer = messageProducer;
//    }

//    @GetMapping("/api/hello")
//    public String getHelloText() throws CsvValidationException, IOException {
//        ParserFactory parserFactory = new ParserFactory();
//        String result = parserFactory.getParserByFileName("file3.csv").execute();
//        messageProducer.sendMessage("[" + result + "]", "parser");
//        return "[" + result + "]";
//    }
}
