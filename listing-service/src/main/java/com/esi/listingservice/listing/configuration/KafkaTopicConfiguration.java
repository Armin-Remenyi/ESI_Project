package com.esi.listingservice.listing.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {


    @Bean
    public NewTopic ListingCreationTopic(){
        return TopicBuilder.name("ListingCreationTopic")
                .build();
    }

    @Bean
    public NewTopic ListingStatusChangingTopic(){
        return TopicBuilder.name("ListingStatusChangingTopic")
                .build();
    }

    
}
