package xyz.sadiulhakim.service;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    private final OllamaChatModel chatModel;

    public AIService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String generateRequest(String promptText) {
        var prompt = new Prompt(promptText, OllamaOptions.create().withModel("llama3"));
        var response = chatModel.call(prompt);
        return response.getResult().getOutput().getContent();
    }
}
