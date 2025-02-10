package com.example.video_chat_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CallRequest {
    private String caller;
    private String receiver;
}
