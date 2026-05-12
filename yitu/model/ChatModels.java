package com.yitu.vms.model;

import lombok.Data;
import java.util.List;

/**
 * AI 智能助手对话模块
 */
public class ChatModels {

    @Data
    public static class ChatRequest {
        private String message;
        private List<ChatMessage> history;
        private Boolean stream;
    }

    @Data
    public static class ChatMessage {
        private String role; // user, assistant
        private String content;
    }

    @Data
    public static class ChatResponse {
        private String content;
        private String finish_reason;
    }
}
