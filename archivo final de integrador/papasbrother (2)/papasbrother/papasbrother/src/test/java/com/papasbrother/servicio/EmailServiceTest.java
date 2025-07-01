package com.papasbrother.servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class EmailServiceTest {
    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEnviarCorreo() {
        doNothing().when(mailSender).send(any(SimpleMailMessage.class));
        emailService.enviarCorreo("test@email.com", "Asunto", "Mensaje");
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    public void testEnviarCorreoMultiple() {
        doNothing().when(mailSender).send(any(SimpleMailMessage.class));
        emailService.enviarCorreoMultiple(Arrays.asList("a@email.com", "b@email.com"), "Asunto", "Mensaje");
        verify(mailSender, times(2)).send(any(SimpleMailMessage.class));
    }
}
