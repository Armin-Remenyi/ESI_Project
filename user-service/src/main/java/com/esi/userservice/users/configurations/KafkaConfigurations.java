package com.esi.userservice.users.configurations;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfigurations {
    @Bean
    public NewTopic userDataTopicCreation(){
        return TopicBuilder.name("UserDataTopic")
                .build();
    }
}
