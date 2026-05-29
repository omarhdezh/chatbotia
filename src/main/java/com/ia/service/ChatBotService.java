package com.ia.service;

import com.ia.dto.ChatBotResponseDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatBotService {

    private final ChatClient chatClient;
    private OpenAiChatModel chatModel;


    public ChatBotService(ChatClient.Builder chatClientBuilder, OpenAiChatModel chatModel) {
        this.chatClient = chatClientBuilder.build();
        this.chatModel=chatModel;
    }
    public ChatBotResponseDTO chat(String message){

        return ChatClient.create(this.chatModel).prompt()
                .user(u -> u.text(message))
                .call()
                .entity(ChatBotResponseDTO.class);
    }
}
