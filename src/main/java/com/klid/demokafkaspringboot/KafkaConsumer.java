package com.klid.demokafkaspringboot;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Ivan Kaptue
 */
@Component
public class KafkaConsumer {

    @KafkaListener(
            topics = "kafka.springboot.topic",
            groupId = "kafka.springboot.group")
    void listen(
            @Payload String data,
            @Header(KafkaHeaders.OFFSET) String offset,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp
            ) {
        System.out.println("Listener received : " + data + " :)");
        System.out.println("From offset : " + offset + " :)");
        System.out.println("With timestamp : " + timestamp + " :)");
    }

}
