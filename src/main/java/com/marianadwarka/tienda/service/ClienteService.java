package com.marianadwarka.tienda.service;

import com.marianadwarka.tienda.model.Cliente;
import com.marianadwarka.tienda.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    IClienteRepository clientRepo;
    
    @Override
    public void saveClient(Cliente client) {
         clientRepo.save(client);
    }
    
    @Override
    public List<Cliente> getClients() {
        return clientRepo.findAll();
    }
    
    @Override
    public Cliente findClient(Long id_cliente) {
        return clientRepo.findById(id_cliente).orElse(null);
    }
    
    @Override
    public void deleteClient(Long id_cliente) {
        clientRepo.deleteById(id_cliente);
    }
    
    @Override
    public void editClient(Long id_cliente, Long idNueva, String nuevoNombre, String nuevoApellido,
            String nuevoDni) {
        
        //obtengo el cliente buscado por su id
        Cliente cli = this.findClient(id_cliente);
        
        //seteo los campos nuevos
        cli.setId_cliente(idNueva);
        cli.setNombre (nuevoNombre);
        cli.setApellido(nuevoApellido);
        cli.setDni(nuevoDni);
        
        //guardo los cambios efectuados
        this.saveClient(cli);
    }
    
}
