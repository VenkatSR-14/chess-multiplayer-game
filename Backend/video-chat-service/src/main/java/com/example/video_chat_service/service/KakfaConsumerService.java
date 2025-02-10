package com.example.video_chat_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KakfaConsumerService {
    @KafkaListener(topics = "video-calls", groupId = "video-chat-group")
    public void consumeVideoCallEvent(String message) {
        System.out.println("Received Video Call Event: " + message);
    }

    @KafkaListener(topics = "chat-messages", groupId = "video-chat-group")
    public void consumeChatMessage(String message) {
        System.out.println("Received Chat Message: " + message);
    }
}