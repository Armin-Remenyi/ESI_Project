package com.esi.candidacyservice.candidacies.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic CandidacyCreationTopic(){
    return TopicBuilder.name("candidacyCreationTopic")
    .build();
    }

    @Bean
    public NewTopic CandidacyStatusUpdateTopic(){
    return TopicBuilder.name("candidacyStatusUpdateTopic")
    .build();
    } 
}
