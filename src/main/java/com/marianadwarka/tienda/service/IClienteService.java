package com.marianadwarka.tienda.service;

import com.marianadwarka.tienda.model.Cliente;
import java.util.List;


public interface IClienteService {
    

    public void saveClient(Cliente prod);
    

    public List<Cliente> getClients();
    

    public Cliente findClient(Long id_cliente);
    

    public void deleteClient(Long id_cliente);
    

    public void editClient(Long id_cliente, Long idNueva,
            String nuevoNombre, String nuevoApellido, String nuevoDni);     
    
    
    
}
