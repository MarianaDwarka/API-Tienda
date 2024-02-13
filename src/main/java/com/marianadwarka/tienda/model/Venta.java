package com.marianadwarka.tienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_venta;
    private LocalDate fecha; 
    private Double total;
    
    //cada venta posee una lista de productos
    //y cada producto puede estar en muchas ventas
    @ManyToMany
    @JoinTable(
                name = "venta_producto",
                joinColumns = @JoinColumn(name="codigo_venta", nullable = false),
                inverseJoinColumns = @JoinColumn(name="codigo_producto", nullable = false)
    )
    private List<Producto> listaProductos;
    
    //cada venta posee solo un cliente
    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente unCliente;

    public Venta() {
    }
    
    public Venta(Long codigo_venta, LocalDate fecha , Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha = fecha;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
}