package com.marianadwarka.tienda.service;

import com.marianadwarka.tienda.dto.MayorVentaDTO;
import com.marianadwarka.tienda.dto.ProductosPorVentaDTO;
import com.marianadwarka.tienda.model.Venta;
import java.time.LocalDate;
import java.util.List;



public interface IVentaService {
    
    
    public void saveVenta(Venta venta);
    
     
    public List<Venta> getVentas();
    
     
    public Venta findVenta(Long codigo_venta);
    
     
    public void deleteVenta(Long codigo_venta);
    
     
    public void editVenta(Long codigo_venta, Venta venta);
    

    // 5.- Obtener la lista de productos de una determinada venta
    public ProductosPorVentaDTO productosPorVenta(Long codigo_venta);
    
    
    // 6.- Obtener la sumatoria del monto y también cantidad total de ventas en
    // un determinado día
    public String ventaMontoDia(LocalDate fecha);

    
    // 7.- Obtener el codigo_venta, el total, la cantidad de productos,
    // el nombre del cliente y el apellito del cliente de la venta con el
    // monto más alto de todas
    public MayorVentaDTO getMayorVenta();

     
}

