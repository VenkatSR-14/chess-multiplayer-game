package com.example.video_chat_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CallResponse {
    private Long callId;
    private String caller;
    private String receiver;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}