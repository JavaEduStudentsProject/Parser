//package com.example.parser.controller;
//
//import com.example.parser.kafka.MessageProducer;
//import com.opencsv.exceptions.CsvValidationException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.web.bind.annotation.*;
//import com.example.parser.parser.ParserFactory;
//
//import java.io.File;
//import java.io.IOException;
//
//@Slf4j
//@RestController
//@CrossOrigin("*")
//public class ParserController {
//    MessageProducer messageProducer;
//
//    public ParserController() {}
//
//    @Autowired
//    public ParserController(MessageProducer messageProducer) {
//        this.messageProducer = messageProducer;
//    }
//
//    @KafkaListener(topics = "parseFileParser", containerFactory = "kafkaListenerFileContainerFactory")
//    public void listener(File fileName) throws IOException, CsvValidationException {
//        log.info("Listener parser: File {} received, parseFileParser ", fileName.getName());
//        ParserFactory parserFactory = new ParserFactory();
//        String result = parserFactory.getParserByFileName(String.valueOf(fileName)).execute();
//        messageProducer.sendMessage(result , "sendParsedString");
//        log.info("Producer parser: String to orchestrator, parser");
//
//    }
//}
