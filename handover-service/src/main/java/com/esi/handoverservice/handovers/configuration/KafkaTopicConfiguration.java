package com.esi.handoverservice.handovers.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic HandoverCreationTopic(){
    return TopicBuilder.name("HandoverCreationTopic")
    .build();
    }

    @Bean
    public NewTopic HandoverStatusUpdateTopic(){
    return TopicBuilder.name("HandoverStatusUpdateTopic")
    .build();
    } 

    @Bean
    public NewTopic HandoverSignUpdateTopic(){
    return TopicBuilder.name("HandoverSignUpdateTopic")
    .build();
    }   
}
