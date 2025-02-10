package com.example.video_chat_service.service;

import com.example.video_chat_service.dto.CallRequest;
import com.example.video_chat_service.model.CallLog;
import com.example.video_chat_service.model.CallStatus;
import com.example.video_chat_service.repository.CallLogRepository;
import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Service
public class CallService {

    @Autowired
    private CallLogRepository callLogRepository;

    @Async
    public CompletableFuture<CallLog> startCall(CallRequest request) {
        CallLog callLog = new CallLog();
        callLog.setCaller(request.getCaller());
        callLog.setReceiver(request.getReceiver());
        callLog.setStartTime(LocalDateTime.now());
        callLog.setStatus(CallStatus.ONGOING);

        CallLog savedCall = callLogRepository.save(callLog);
        return CompletableFuture.completedFuture(savedCall);
    }

    @Async
    public CompletableFuture<CallLog> endCall(Long callID){
        return CompletableFuture.supplyAsync(() -> {
            CallLog callLog = callLogRepository.findById(callID).orElse(null);
            if (callLog != null){
                callLog.setEndTime(LocalDateTime.now());
                callLog.setStatus(CallStatus.COMPLETED);
                return callLogRepository.save(callLog);
            }
            return null;
        });

    }
}
