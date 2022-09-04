package org.example.utilities;

import org.example.controllers.PersonaController;
import org.example.dtos.request.PersonaRequestDTO;
import org.example.dtos.response.PersonaResponseDTO;
import java.util.ArrayList;
import java.util.List;

public class CrudPersona {

    public void crud(){
        PersonaController personaController = new PersonaController();
        DatosRandom datosRandom = new DatosRandom();
        PersonaRequestDTO persona1 = new PersonaRequestDTO();
        PersonaRequestDTO personaModificada = new PersonaRequestDTO();
        Integer wasCreated = 0;
        persona1.setNombre(datosRandom.nombreRandom());
        persona1.setApellido(datosRandom.apellidoRandom());
        persona1.setEdad(datosRandom.edadRandom());
        persona1.setDireccion(datosRandom.direccionRandom());


        System.out.println("---- Crear Persona ----");
        wasCreated = personaController.createPersona(persona1);

        // LISTAR PERSONAS
        List<PersonaResponseDTO> personas = new ArrayList<>();
        personas = personaController.listarPersonas();

        System.out.println("---- Listado de Personas ----");
        personas.forEach(persona -> {
            System.out.println(persona);
        });

        System.out.println("-------------------------------");

        // ACTUALIZAR PERSONA POR ID
        System.out.println("---- Actualizar Persona ----");
        personaModificada.setNombre(datosRandom.nombreRandom());
        personaModificada.setApellido(datosRandom.apellidoRandom());
        personaModificada.setEdad(datosRandom.edadRandom());
        personaModificada.setDireccion(datosRandom.direccionRandom());
        wasCreated = personaController.updatePersona(3, personaModificada);


        // ELIMINAR PERSONA POR ID
        System.out.println("---- Eliminar Persona ----");
       // personaController.deletePersona(16);

        // LISTAR PERSONAS
        personas = personaController.listarPersonas();

        System.out.println("---- Listado de Personas ----");
        personas.forEach(persona -> {
            System.out.println(persona);
        });
    }
}
