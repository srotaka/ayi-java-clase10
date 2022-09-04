package org.example.utilities.mappers;

import org.example.dtos.response.PersonaResponseDTO;
import org.example.entities.Persona;
import org.modelmapper.ModelMapper;

public class PersonaMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public PersonaResponseDTO entityToDto(Persona dataInput) {

        return modelMapper.map(dataInput, PersonaResponseDTO.class);

    }

}
