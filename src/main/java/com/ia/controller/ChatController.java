package com.ia.controller;

import com.ia.dto.ChatRequestDTO;
import com.ia.dto.ChatResponseDTO;
import com.ia.service.ChatClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ChatController {

    private ChatClientService chatClientService;
    public ChatController(ChatClientService chatClientService) {
        this.chatClientService = chatClientService;
    }

    @PostMapping("/chat")
    public ResponseEntity<Object> chat(@RequestBody ChatRequestDTO request) {
        String response = chatClientService.ask(request.message());
        return ResponseEntity.ok(new ChatResponseDTO(response));
    }
}
