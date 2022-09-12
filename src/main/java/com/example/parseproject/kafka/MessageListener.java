package com.example.parseproject.kafka;

import com.example.parseproject.parser.ParserFactory;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.File;
import java.io.IOException;

public class MessageListener {

    MessageProducer messageProducer;
    @Autowired
    public MessageListener() {
        this.messageProducer = messageProducer;
    }

    //принимаем файл от оркестратора с фронта
    @KafkaListener(topics = "topicFrontToParser", containerFactory = "kafkaListenerFileContainerFactory")
    public void listener(File fileName) throws CsvValidationException, IOException {
        System.out.println("Recieved message (filename): " + fileName.getName());
        ParserFactory parserFactory = new ParserFactory();
        String result = parserFactory.getParserByFileName(fileName.getName()).execute();
        messageProducer.sendMessage("[" + result + "]", "parser");

    }
}
