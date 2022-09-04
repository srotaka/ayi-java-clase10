package org.example.mappers;

import org.example.dtos.response.EmpleadoResponseDTO;
import org.example.entities.Empleado;
import org.modelmapper.ModelMapper;

public class EmpleadoMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public EmpleadoResponseDTO entityToDto(Empleado dataInput){
        return modelMapper.map(dataInput, EmpleadoResponseDTO.class);
    }
}
