package com.esi.backgroundcheckservice.backgroundchecks.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic BackgroundCheckCompleted(){
    return TopicBuilder.name("BackgroundCheckCompleted")
    .build();
    }
    
}
