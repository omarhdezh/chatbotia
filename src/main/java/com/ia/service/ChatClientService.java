package com.ia.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

import com.ia.dto.ChatRequestDTO;

@Service
public class ChatClientService {

    private OpenAiChatModel chatmodel;

    public ChatClientService(OpenAiChatModel chatmodel) {
        this.chatmodel = chatmodel;
    }

    public String ask(String message) {
        return chatmodel.call(message);
    }

}
