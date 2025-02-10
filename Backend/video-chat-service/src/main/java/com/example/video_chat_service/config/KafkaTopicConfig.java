package com.example.video_chat_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic videoCallTopic(){
        return new NewTopic("video-calls", 1, (short) 1);
    }

    @Bean
    public NewTopic chatMessagesTopic(){
        return new NewTopic("chat-messages", 1, (short) 1);
    }
}
