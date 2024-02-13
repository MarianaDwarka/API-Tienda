package com.marianadwarka.tienda.service;

import com.marianadwarka.tienda.model.Producto;
import java.util.List;


public interface IProductoService {
    
    
    public void saveProduct(Producto prod);
    
     
    public List<Producto> getProducts();
    
     
    public Producto findProduct(Long codigo_producto);
    
     
    public void deleteProduct(Long codigo_producto);
    
    
    public void editProduct(Long codigo_producto, Long idNueva,
            String nombre, String marca, Double costo, Double cantidad_disponible);
    
     
    public List<Producto> FaltaStock();
}
