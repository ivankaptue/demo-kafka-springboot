package com.klid.demokafkaspringboot;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Ivan Kaptue
 */
@Component
public class KafkaConsumer {

    @KafkaListener(
            topics = "kafka.springboot.topic",
            groupId = "kafka.springboot.group")
    void listen(String data) {
        System.out.println("Listener received : " + data + " :)");
    }

}
