package com.marianadwarka.tienda.controller;

import com.marianadwarka.tienda.dto.MayorVentaDTO;
import com.marianadwarka.tienda.dto.ProductosPorVentaDTO;
import com.marianadwarka.tienda.model.Venta;
import com.marianadwarka.tienda.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    

    @Autowired
    IVentaService ventService;

    
    // 3.- Realizar un CRUD completo de ventas

    //Creación
    @PostMapping("/ventas/crear")
    public String createVenta (@RequestBody Venta venta){
        ventService.saveVenta(venta);
        return "Venta creada correctamente.";
    }
    
    //Lista completa de ventas realizadas
    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        return ventService.getVentas();
    }

    //Traer una venta en particular
    @GetMapping("/ventas/{codigo_venta}")
    public Venta getVenta (@PathVariable Long codigo_venta){
        return ventService.findVenta(codigo_venta);
    }

    //Eliminación
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta (@PathVariable Long codigo_venta){
        ventService.deleteVenta(codigo_venta);
        return "La venta fue eliminada";
    }
    
    //Edición
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVenta (@PathVariable Long codigo_venta,@RequestBody Venta venta){
        ventService.editVenta(codigo_venta,venta);
        return this.getVenta (codigo_venta);
    }
    
    // 5.- Obtener la lista de productos de una determinada venta
    @GetMapping ("/ventas/productos/{codigo_venta}")
    public ProductosPorVentaDTO productosPorVenta (@PathVariable Long codigo_venta) {
        return ventService.productosPorVenta(codigo_venta);
    }
    
    // 6.- Obtener la sumatoria del monto y también cantidad total de ventas en
    // un determinado día
    @GetMapping("/ventas/total/{fecha_venta}")
    @ResponseBody
    public String ventaMontoDia(@PathVariable String fecha_venta){
        LocalDate fecha = LocalDate.parse(fecha_venta);
        return ventService.ventaMontoDia(fecha);
    }
    
    // 7.- Obtener el codigo_venta, el total, la cantidad de productos,
    // el nombre del cliente y el apellito del cliente de la venta con el
    // monto más alto de todas
    @GetMapping ("/ventas/mayor_venta")
    public MayorVentaDTO getMayorVenta(){
        return ventService.getMayorVenta();
    }
}
