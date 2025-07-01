package com.papasbrother.servicio;

import com.papasbrother.modelo.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PDFGeneratorServiceTest {
    @Mock
    private TemplateEngine templateEngine;

    @InjectMocks
    private PDFGeneratorService pdfGeneratorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerarBoleta() throws IOException {
        Pedido pedido = mock(Pedido.class);
        when(pedido.getUsuario()).thenReturn("usuario");
        when(pedido.getItems()).thenReturn(List.of());
        when(pedido.getTotal()).thenReturn(100.0);
        when(pedido.getFecha()).thenReturn(LocalDateTime.now());
        when(pedido.getNumero()).thenReturn("123");
        when(templateEngine.process(eq("boleta"), any(Context.class))).thenReturn("<html></html>");

        byte[] pdf = pdfGeneratorService.generarBoleta(pedido);
        assertNotNull(pdf);
        assertTrue(pdf.length > 0);
    }
}
