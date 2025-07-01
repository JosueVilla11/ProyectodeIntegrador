package com.papasbrother.modelo;

import java.time.LocalDateTime;
import java.util.List;

import com.papasbrother.dto.ItemCarrito;

public class Pedido {
    private String numero;
    private String usuario;
    private LocalDateTime fecha;
    private List<ItemCarrito> items;
    private double total;

    // Getter y Setter para 'numero'
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Getter y Setter para 'usuario'
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Getter y Setter para 'fecha'
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    // Getter y Setter para 'items'
    public List<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }

    // Getter y Setter para 'total'
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
