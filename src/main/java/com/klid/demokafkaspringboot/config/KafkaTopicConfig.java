package com.klid.demokafkaspringboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author Ivan Kaptue
 */
@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("kafka.springboot.topic")
                .partitions(5)
                .replicas(1)
                .build();
    }

}
