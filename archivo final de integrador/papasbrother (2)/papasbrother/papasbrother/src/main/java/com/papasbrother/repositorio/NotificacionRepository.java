package com.papasbrother.repositorio;

import com.papasbrother.modelo.Notificacion;
import java.util.List;

public interface NotificacionRepository {
    List<Notificacion> findAll();
    Notificacion save(Notificacion notificacion);
    Notificacion findById(Long id);
    void deleteById(Long id);
}
