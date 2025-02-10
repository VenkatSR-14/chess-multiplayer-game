package com.example.video_chat_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class VideoChatServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoChatServiceApplication.class, args);
	}

}
