package com.papasbrother.servicio;

import com.papasbrother.modelo.ChatResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ChatbotServiceTest {
    private ChatbotService chatbotService;

    @BeforeEach
    public void setup() {
        chatbotService = new ChatbotService();
        chatbotService.init();
    }

    @Test
    public void testRespuestasConfiguradas() {
        List<ChatResponse> responses = chatbotService.getResponseConfigurations();
        assertNotNull(responses);
        assertFalse(responses.isEmpty());
        assertTrue(responses.stream().anyMatch(r -> r.getContext().equals("greetings")));
    }

    @Test
    public void testContextoInicial() {
        assertNull(chatbotService.getLastContext());
    }
}
