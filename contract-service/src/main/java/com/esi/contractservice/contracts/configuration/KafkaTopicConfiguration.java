package com.esi.contractservice.contracts.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {
 
    @Bean
    public NewTopic ContractCreationTopic(){
    return TopicBuilder.name("ContractCreationTopic")
    .build();
    }

    @Bean
    public NewTopic ContractStatusUpdateTopic(){
    return TopicBuilder.name("ContractStatusUpdateTopic")
    .build();
    } 

    @Bean
    public NewTopic ContractSignUpdateTopic(){
    return TopicBuilder.name("ContractSignUpdateTopic")
    .build();
    }
}
