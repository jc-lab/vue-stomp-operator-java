package kr.jclab.spring.vuestompoperator;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class VueStompOperatorBackendConfiguration {
    @Bean
    public VueStompOperatorMessagingTemplate vueStompOperatorMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        return new VueStompOperatorMessagingTemplate(simpMessagingTemplate);
    }
}
