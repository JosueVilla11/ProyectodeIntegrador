package com.papasbrother.servicio;

import com.papasbrother.modelo.Notificacion;
import com.papasbrother.repositorio.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> getAll() {
        return notificacionRepository.findAll();
    }

    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notificacion getById(Long id) {
        return notificacionRepository.findById(id);
    }

    public void delete(Long id) {
        notificacionRepository.deleteById(id);
    }
}
