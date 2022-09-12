package com.example.parseproject.kafka;

import com.example.parseproject.parser.ParserFactory;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.File;
import java.io.IOException;

@Slf4j
public class MessageListener {

    MessageProducer messageProducer;

    public MessageListener(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    //принимаем файл от оркестратора с фронта
//    @KafkaListener(topics = "topicFrontToParser", containerFactory = "kafkaListenerFileContainerFactory")
//    public void listener(File fileName) throws CsvValidationException, IOException {
//        ParserFactory parserFactory = new ParserFactory();
//        log.info("Listener parser: File {} received, topicFrontToParser ", fileName.getName());
//        String result = parserFactory.getParserByFileName(fileName.getName()).execute();
//        messageProducer.sendMessage("[" + result + "]", "parser");
//
//    }
}
