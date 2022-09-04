package org.example.mappers;

import org.example.dtos.response.ClienteResponseDTO;
import org.example.entities.Cliente;
import org.modelmapper.ModelMapper;

public class ClienteMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public ClienteResponseDTO entityToDto(Cliente dataInput){
        return modelMapper.map(dataInput, ClienteResponseDTO.class);
    }
}
