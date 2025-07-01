package com.papasbrother.controlador;

import com.papasbrother.modelo.Notificacion;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    private final List<Notificacion> notificaciones = new ArrayList<>();

    @GetMapping
    public List<Notificacion> listar() {
        return notificaciones;
    }

    @PostMapping
    public Notificacion crear(@RequestBody Notificacion notificacion) {
        notificacion.setId((long) (notificaciones.size() + 1));
        notificacion.setFechaEnvio(LocalDateTime.now());
        notificaciones.add(notificacion);
        return notificacion;
    }

    @PutMapping("/{id}/leido")
    public Notificacion marcarLeido(@PathVariable Long id) {
        for (Notificacion n : notificaciones) {
            if (n.getId().equals(id)) {
                n.setLeido(true);
                return n;
            }
        }
        return null;
    }
}
