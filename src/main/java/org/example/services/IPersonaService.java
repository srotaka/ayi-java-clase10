package org.example.services;

import org.example.dtos.request.PersonaRequestDTO;
import org.example.dtos.response.PersonaResponseDTO;
import java.util.List;

public interface IPersonaService {

    Integer createPersona(PersonaRequestDTO persona);
    Integer updatePersona(Integer id, PersonaRequestDTO persona);
    List<PersonaResponseDTO> getAllPersonas();
    void deletePersona(Integer id);

}
