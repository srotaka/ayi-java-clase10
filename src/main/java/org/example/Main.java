package org.example;

import org.example.controllers.PersonaController;
import org.example.entities.Persona;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonaController personaController = new PersonaController();

        List<Persona> personas = new ArrayList<>();

        personas = personaController.listarPersonas();

        System.out.println("---- Listado de Personas ----");
        personas.forEach(persona -> {
            System.out.println(persona);
        });

        System.out.println("\n---- Listado de Personas II ----");

        for (Persona persona : personas) {
            System.out.println(persona);
        }


    }
}