package com.example.video_chat_service.controller;


import com.example.video_chat_service.dto.CallRequest;
import com.example.video_chat_service.dto.CallResponse;
import com.example.video_chat_service.model.CallLog;
import com.example.video_chat_service.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/calls")
public class VideoCallController {
    @Autowired
    private CallService callService;

    @PostMapping("/start")
    public CompletableFuture<CallResponse> startCall(@RequestBody CallRequest request) {
        return callService.startCall(request).thenApply(callLog ->
                new CallResponse(callLog.getId(), callLog.getCaller(), callLog.getReceiver(), callLog.getStartTime(), null)
        );
    }

    @PostMapping("/end/{callId}")
    public CompletableFuture<CallResponse> endCall(@PathVariable Long callId) {
        return callService.endCall(callId).thenApply(callLog ->
                new CallResponse(callLog.getId(), callLog.getCaller(), callLog.getReceiver(), callLog.getStartTime(), callLog.getEndTime())
        );
    }
}
