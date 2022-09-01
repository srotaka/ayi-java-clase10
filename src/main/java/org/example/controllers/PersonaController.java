package org.example.controllers;

import org.example.entities.Persona;
import org.example.services.IPersonaService;
import org.example.services.impl.PersonaServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class PersonaController {
    private IPersonaService iPersonaService = new PersonaServiceImpl();

    public List<Persona>listarPersonas(){
        List<Persona> personas = new ArrayList<>();
        personas = iPersonaService.getAllPersonas();
        return personas;
    }

}
