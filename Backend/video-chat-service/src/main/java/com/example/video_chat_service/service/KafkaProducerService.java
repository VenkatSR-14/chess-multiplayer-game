package com.example.video_chat_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String VIDEO_CALL_TOPIC = "video-calls";
    private static final String CHAT_TOPIC = "chat-messages";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendVideoCallEvent(String message){
        kafkaTemplate.send(VIDEO_CALL_TOPIC, message);
    }

    public void sendChatMessage(String message){
        kafkaTemplate.send(CHAT_TOPIC, message);
    }
}
