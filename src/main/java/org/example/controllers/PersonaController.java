package org.example.controllers;

import org.example.dtos.request.PersonaRequestDTO;
import org.example.dtos.response.PersonaResponseDTO;
import org.example.services.IPersonaService;
import org.example.services.impl.PersonaServiceImpl;
import java.util.List;

public class PersonaController {
    private IPersonaService iPersonaService = new PersonaServiceImpl();

    public Integer createPersona(PersonaRequestDTO persona){
        return iPersonaService.createPersona(persona);
    }

    public Integer updatePersona(Integer id, PersonaRequestDTO persona){
        return iPersonaService.updatePersona(id, persona);
    }
    public List<PersonaResponseDTO>listarPersonas(){
        return iPersonaService.getAllPersonas();
    }

    public  void deletePersona(Integer id){
        iPersonaService.deletePersona(id);
    }


}
