package com.marianadwarka.tienda.service;

import com.marianadwarka.tienda.dto.MayorVentaDTO;
import com.marianadwarka.tienda.dto.ProductosPorVentaDTO;
import com.marianadwarka.tienda.model.Venta;
import com.marianadwarka.tienda.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VentaService implements IVentaService{
    
    @Autowired
    IVentaRepository ventRepo;
    
    @Override
    public void saveVenta(Venta venta) {
         ventRepo.save(venta);
    }
    
    @Override
    public List<Venta> getVentas() {
        return ventRepo.findAll();
    }
    
    @Override
    public Venta findVenta(Long codigo_venta) {
        return ventRepo.findById(codigo_venta).orElse(null);
    }
    
    @Override
    public void deleteVenta(Long codigo_venta) {
        ventRepo.deleteById(codigo_venta);
    }
    
    @Override
    public void editVenta(Long codigo_venta, Venta venta) {
        venta.setCodigo_venta(codigo_venta);
        this.saveVenta(venta);
    }

    // 5.- Obtener la lista de productos de una determinada venta
    @Override
    public ProductosPorVentaDTO productosPorVenta(Long codigo_venta) {
        ProductosPorVentaDTO venProDTO = new ProductosPorVentaDTO();
        Venta venta = this.findVenta(codigo_venta);
        
        venProDTO.setCodigo_venta(venta.getCodigo_venta());
        venProDTO.setListaProductos(venta.getListaProductos());
        
        return venProDTO;
    }
    
    // 6.- Obtener la sumatoria del monto y también cantidad total de ventas en
    // un determinado día
    @Override
    public String ventaMontoDia(LocalDate fecha_venta) {
        List<Venta> listaVentas = this.getVentas();
        double monto = 0;
        int cantidad = 0;

        for (Venta venta : listaVentas) {
            if (venta.getFecha().equals(fecha_venta)) {
                monto = monto + venta.getTotal();
                cantidad++;
            }
        }
        return "La cantidad de ventas del dia " + fecha_venta + " es de: " + cantidad + ", con un monto total de: " + monto;
    }

    
    // 7.- Obtener el codigo_venta, el total, la cantidad de productos,
    // el nombre del cliente y el apellito del cliente de la venta con el
    // monto más alto de todas
    @Override
    public MayorVentaDTO getMayorVenta() {
        List<Venta> listaVentas = this.getVentas();
        MayorVentaDTO mayorDTO = new MayorVentaDTO();
        Double total = 0.0;
        Double temp = 0.0;
        Double contador = 0.0;
        for(Venta mayorVen : listaVentas){
            temp = mayorVen.getTotal();
            if(temp > total){
                total = temp;
                Double roundTotal = Math.round(total*100.0)/100.0;
                mayorDTO.setTotal(roundTotal);
                mayorDTO.setCodigo_venta(mayorVen.getCodigo_venta());
                mayorDTO.setNombre_cliente(mayorVen.getUnCliente().getNombre());
                mayorDTO.setApellido_cliente(mayorVen.getUnCliente().getApellido());
                mayorDTO.setListaProductos(mayorVen.getListaProductos());
                
                for(int i=0; i < mayorDTO.getListaProductos().size(); i++){
                    contador = contador + 1;
                    mayorDTO.setCantidad_productos(contador);
                }
            }
        }
           return mayorDTO;
    }
    
    

    




}