package kr.jclab.spring.vuestompoperator;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;

import java.util.HashMap;
import java.util.Map;

public class VueStompOperatorMessagingTemplate {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public VueStompOperatorMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void convertAndSendToUser(StompHeaderAccessor headerAccessor, String destination, VueStompResponseEntity responseEntity) {
        Map<String, Object> headers = new HashMap<>(headerAccessor.getMessageHeaders());
        Map<String, String> appendHeaders = responseEntity.getHeaders();
        headers.put("x-status", responseEntity.getStatus());
        if(appendHeaders != null) {
            headers.putAll(appendHeaders);
        }
        this.simpMessagingTemplate.convertAndSendToUser(headerAccessor.getSessionId(), destination, responseEntity.getBody(), headers);
    }
}
