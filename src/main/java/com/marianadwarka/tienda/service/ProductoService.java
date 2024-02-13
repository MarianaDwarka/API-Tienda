package com.marianadwarka.tienda.service;

import com.marianadwarka.tienda.model.Producto;
import com.marianadwarka.tienda.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    IProductoRepository prodRepo;
    @Override
    public void saveProduct(Producto prod) {
         prodRepo.save(prod);
    }
    
    @Override
    public List<Producto> getProducts() {
        return prodRepo.findAll();
    }
    
    @Override
    public Producto findProduct(Long codigo_producto) {
        return prodRepo.findById(codigo_producto).orElse(null);
    }
    
    @Override
    public void deleteProduct(Long codigo_producto) {
        prodRepo.deleteById(codigo_producto);
    }
    
    @Override
    public void editProduct(Long codigo_producto, Long idNueva, String nombre,
            String marca, Double costo, Double cantidad_disponible) {
        
        //obtengo el producto buscando por su id
        Producto prod = this.findProduct(codigo_producto);
        
        //seteo los campos nuevos
        prod.setCodigo_producto(idNueva);
        prod.setNombre(nombre);
        prod.setMarca(marca);
        prod.setCosto(costo);
        prod.setCantidad_disponible(cantidad_disponible);
        
        //guardo los cambios efectuados
        this.saveProduct(prod);
        
    }

    @Override
    public List<Producto> FaltaStock() {
        List<Producto> listaProductos = this.getProducts();
        List<Producto> listaStockMenorA5 = new ArrayList<Producto>();
        
        for(Producto pro : listaProductos){
            if(pro.getCantidad_disponible() < 5){
                listaStockMenorA5.add(pro);
            }
        }
        return listaStockMenorA5;

    }
    



}