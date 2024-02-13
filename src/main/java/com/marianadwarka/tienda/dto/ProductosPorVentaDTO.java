package com.marianadwarka.tienda.dto;

import com.marianadwarka.tienda.model.Producto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductosPorVentaDTO {
    
    private Long codigo_venta;
    private List<Producto> listaProductos;

    public ProductosPorVentaDTO() {
    }

    public ProductosPorVentaDTO(Long codigo_venta, List<Producto> listaProductos) {
        this.codigo_venta = codigo_venta;
        this.listaProductos = listaProductos;
    }
    
}
