package com.esi.handoverservice.handovers.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic HandoverCreationTopic(){
    return TopicBuilder.name("handoverCreationTopic")
    .build();
    }

    @Bean
    public NewTopic HandoverStatusUpdateTopic(){
    return TopicBuilder.name("handoverStatusUpdateTopic")
    .build();
    } 

    @Bean
    public NewTopic HandoverSignUpdateTopic(){
    return TopicBuilder.name("handoverSignUpdateTopic")
    .build();
    }   
}
