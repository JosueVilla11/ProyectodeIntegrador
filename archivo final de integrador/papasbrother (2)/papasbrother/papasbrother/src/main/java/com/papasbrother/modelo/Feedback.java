package com.papasbrother.modelo;

import java.time.LocalDateTime;

/**
 * Entidad para almacenar feedback de usuarios.
 */
public class Feedback {
    private Long id;
    private String usuario;
    private String mensaje;
    private int calificacion;
    private LocalDateTime fecha;

    public Feedback() {}

    public Feedback(Long id, String usuario, String mensaje, int calificacion, LocalDateTime fecha) {
        this.id = id;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}