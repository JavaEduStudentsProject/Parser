//package kafka;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//
//import javax.validation.constraints.NotNull;
//import javax.websocket.SendResult;
//
//@Component
//public class Producer {
//
//    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void sendMessage(String msg) {
//        String topicName = "rest-spring-boot-integration";
//        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, msg);
//        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//            @Override
//            public void onFailure(@NotNull Throwable throwable) {
//                logger.error("Failed to send message", throwable);
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, String> result) {
//            logger.info("Sent message successfully");
//            }
//        });
//    }
//}
