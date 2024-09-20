package xyz.sadiulhakim.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.sadiulhakim.service.AIService;

@RestController
public class BaseController {
    private final AIService aiService;

    public BaseController(AIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping(value = "/chat", produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(@RequestParam String prompt) {
        return aiService.generateRequest(prompt);
    }
}
