package com.esi.contractservice.contracts.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic CandidacyTopicCreation(){
    return TopicBuilder.name("contractCreatedTopic")
    .build();
    }

    // @Bean
    // public NewTopic PaymentTopicCreation(){
    // return TopicBuilder.name("paymentTopic")
    // .build();
    // }

    
}
