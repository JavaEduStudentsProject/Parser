package com.example.parser.kafka;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageListener {

    MessageProducer messageProducer;

    public MessageListener(){}

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
