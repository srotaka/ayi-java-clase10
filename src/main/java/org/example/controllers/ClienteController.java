package org.example.controllers;

import org.example.dtos.request.ClienteRequestDTO;
import org.example.dtos.response.ClienteResponseDTO;
import org.example.services.IClienteService;
import org.example.services.impl.ClienteServiceImpl;

import java.util.List;

public class ClienteController {

    private IClienteService clienteService = new ClienteServiceImpl();
    public void createCliente(ClienteRequestDTO clienteRequestDTO){
        clienteService.createCliente(clienteRequestDTO);
    }
    public  void updateCliente(Integer id, ClienteRequestDTO clienteRequestDTO){
        clienteService.updateCliente(id, clienteRequestDTO);
    }
    public List<ClienteResponseDTO> listarClientes(){
        return clienteService.getAllClientes();
    }
    public void deleteCliente(Integer id){
        clienteService.deleteCliente(id);
    }
}
