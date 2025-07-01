package com.papasbrother.util;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class FechaUtilTest {
    @Test
    public void testFormatearFecha() {
        LocalDateTime fecha = LocalDateTime.of(2025, 7, 1, 14, 30);
        String resultado = FechaUtil.formatearFecha(fecha);
        assertEquals("01/07/2025 14:30", resultado);
    }
}