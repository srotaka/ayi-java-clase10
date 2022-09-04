package org.example.services;

import org.example.dtos.request.ClienteRequestDTO;
import org.example.dtos.response.ClienteResponseDTO;

import java.util.List;

public interface IClienteService {

    void createCliente(ClienteRequestDTO cliente);
    void updateCliente(Integer id, ClienteRequestDTO cliente);
    List<ClienteResponseDTO> getAllClientes();
    void deleteCliente(Integer id);
}
