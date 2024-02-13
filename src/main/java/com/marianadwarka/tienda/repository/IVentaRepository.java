package com.marianadwarka.tienda.repository;

import com.marianadwarka.tienda.model.Venta;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {

    public List<Venta> findAllByFecha(LocalDate fecha);

    public Object findFirstByOrderByTotalDesc();
   
}
