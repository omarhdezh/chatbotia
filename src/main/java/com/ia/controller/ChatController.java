package com.ia.controller;

import com.ia.service.ChatBotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ChatController {

    public ChatBotService chatBotService;

    public ChatController(ChatBotService chatBotService){
        this.chatBotService= chatBotService;

    }

    @GetMapping
    public ResponseEntity<Object> chat(@RequestParam String message){
        return ResponseEntity.ok(chatBotService.chat(message));
    }
}
