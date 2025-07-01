package com.papasbrother.servicio;


import com.papasbrother.modelo.Producto;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoServiceTest {

    @Test
    void testGuardarYListarProducto() {
        ProductoService service = new ProductoService();
        Producto producto = new Producto(1L, "Hamburguesa", "Clásica", 12.5, "hamburguesa.jpg");
        service.saveProducto(producto);

        List<Producto> productos = service.getAllProductos();
        assertFalse(productos.isEmpty());
        assertEquals("Hamburguesa", productos.get(0).getNombre());
    }

    @Test
    void testEliminarProducto() {
        ProductoService service = new ProductoService();
        Producto producto = new Producto(2L, "Papas", "Fritas", 7.0, "papas.jpg");
        service.saveProducto(producto);
        service.deleteProducto(2L);
        assertTrue(service.getAllProductos().isEmpty());
    }
}