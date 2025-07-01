package com.papasbrother.modelo;

import java.time.LocalDateTime;

public class Notificacion {
    private Long id;
    private String mensaje;
    private String destinatario;
    private LocalDateTime fechaEnvio;
    private boolean leido;

    public Notificacion() {}

    public Notificacion(Long id, String mensaje, String destinatario, LocalDateTime fechaEnvio, boolean leido) {
        this.id = id;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
        this.fechaEnvio = fechaEnvio;
        this.leido = leido;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public boolean isLeido() { return leido; }
    public void setLeido(boolean leido) { this.leido = leido; }
}
