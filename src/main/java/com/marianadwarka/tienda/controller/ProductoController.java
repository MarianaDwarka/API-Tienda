package com.marianadwarka.tienda.controller;

import com.marianadwarka.tienda.model.Producto;
import com.marianadwarka.tienda.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductoController {
    @Autowired
    IProductoService prodService;
    
    // 1.- Realizar un CRUD completo de productos

    //Creación
    @PostMapping("/productos/crear")
    public String createProducto(@RequestBody Producto producto){
        prodService.saveProduct(producto);
        return "Producto creado correctamente.";
    }
    
    //Lista completa de productos
    @GetMapping("/productos")
    public List<Producto> getProductos (){
        return prodService.getProducts();
    }

    //Traer un producto en particular
    @GetMapping("/productos/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto){
        return prodService.findProduct(codigo_producto);
    }

    //Eliminación
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto (@PathVariable Long codigo_producto){
        prodService.deleteProduct(codigo_producto);
        return "El producto fue eliminado";
    }
    
    //Edición de producto por parámetro
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto,
            @RequestParam(required = false, name = "codigo_producto") Long idNueva,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "marca") String nuevaMarca,
            @RequestParam(required = false, name = "costo") Double nuevoCosto,
            @RequestParam(required = false, name = "cantidad_disponible") Double nuevaCantidadDisponible)
            {
                
        prodService.editProduct(codigo_producto, idNueva, nuevoNombre, nuevaMarca,
                nuevoCosto, nuevaCantidadDisponible);
        Producto prod = prodService.findProduct(idNueva);
        return prod;
    }

    
    // 4.- Obtener todos los productos cuya cantidad_disponible sea menor a 5
    @GetMapping("/productos/falta_stock")
    public List<Producto> FaltaStock(){
        return prodService.FaltaStock();
    }

}
