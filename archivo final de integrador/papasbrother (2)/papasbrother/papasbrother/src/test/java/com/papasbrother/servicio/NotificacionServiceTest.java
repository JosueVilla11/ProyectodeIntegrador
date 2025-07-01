package com.papasbrother.servicio;

import com.papasbrother.modelo.Notificacion;
import com.papasbrother.repositorio.NotificacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NotificacionServiceTest {
    @Mock
    private NotificacionRepository notificacionRepository;

    @InjectMocks
    private NotificacionService notificacionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        Notificacion n1 = new Notificacion();
        Notificacion n2 = new Notificacion();
        when(notificacionRepository.findAll()).thenReturn(Arrays.asList(n1, n2));
        List<Notificacion> result = notificacionService.getAll();
        assertEquals(2, result.size());
        verify(notificacionRepository, times(1)).findAll();
    }

    @Test
    public void testSave() {
        Notificacion n = new Notificacion();
        when(notificacionRepository.save(n)).thenReturn(n);
        Notificacion result = notificacionService.save(n);
        assertEquals(n, result);
        verify(notificacionRepository, times(1)).save(n);
    }

    @Test
    public void testGetById() {
        Notificacion n = new Notificacion();
        when(notificacionRepository.findById(1L)).thenReturn(n);
        Notificacion result = notificacionService.getById(1L);
        assertEquals(n, result);
        verify(notificacionRepository, times(1)).findById(1L);
    }

    @Test
    public void testDelete() {
        doNothing().when(notificacionRepository).deleteById(1L);
        notificacionService.delete(1L);
        verify(notificacionRepository, times(1)).deleteById(1L);
    }
}
