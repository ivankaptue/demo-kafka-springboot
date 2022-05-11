package com.klid.demokafkaspringboot;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.time.Instant;

@SpringBootApplication
public class DemoKafkaSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoKafkaSpringbootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            var topic = "kafka.springboot.topic";
            for (int i = 0; i < 100; i++) {
                var messageText = "hello kafka :) " + i;
//                var record = new ProducerRecord<String, String>(topic, messageText);
                var timestampKey = KafkaHeaders.TIMESTAMP;

                System.out.println("timestamp key : " + timestampKey);

                var message = MessageBuilder.withPayload(messageText)
                        .setHeader(KafkaHeaders.TOPIC, topic)
                        .setHeader(timestampKey, 123456L)
                        .setHeader(KafkaHeaders.CORRELATION_ID, String.valueOf(i)).build();
               var result =  kafkaTemplate.send(message).get();
                System.out.println("Sent result : " + result);
            }
        };
    }

}
