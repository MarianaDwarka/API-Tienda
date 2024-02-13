package com.marianadwarka.tienda.controller;

import com.marianadwarka.tienda.model.Cliente;
import com.marianadwarka.tienda.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    IClienteService clientService;
    
    // 2.- Realizar un CRUD completo de clientes

    //Creación
    @PostMapping("/clientes/crear")
    public String createClient(@RequestBody Cliente prod){
        clientService.saveClient(prod);
        return "Cliente creado correctamente.";
    }
    
    //Lista completa de clientes
    @GetMapping("/clientes")
    public List<Cliente> getClients(){
        return clientService.getClients();
    }

    //Traer un cliente en particular
    @GetMapping("/clientes/{id_cliente}")
    public Cliente getClient(@PathVariable Long id_cliente){
        return clientService.findClient(id_cliente);
    }

    //Eliminación
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteClient(@PathVariable Long id_cliente){
        clientService.deleteClient(id_cliente);
        return "El cliente fue eliminado";
    }

    //Edición
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCliente(@PathVariable Long id_cliente,
            @RequestParam(required = false, name = "id_cliente") Long idNueva,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "dni") String nuevoDni)
            {
                
        clientService.editClient(id_cliente, idNueva, nuevoNombre, nuevoApellido, nuevoDni);
        Cliente cli = clientService.findClient(idNueva);
        return cli;
    }
}