package org.example.controllers;

import org.example.dtos.request.EmpleadoRequestDTO;
import org.example.dtos.response.EmpleadoResponseDTO;
import org.example.services.IEmpleadoService;
import org.example.services.impl.EmpleadoServiceImpl;

import java.util.List;

public class EmpleadoController {

    private IEmpleadoService empleadoService = new EmpleadoServiceImpl();

    public void createEmpleado(EmpleadoRequestDTO empleadoRequestDTO){
        empleadoService.createEmpleado(empleadoRequestDTO);
    }
    public void updateEmpleado(Integer id, EmpleadoRequestDTO empleadoRequestDTO){
        empleadoService.updateEmpleado(id, empleadoRequestDTO);
    }
    public List<EmpleadoResponseDTO>listarEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    public void deleteEmpleado(Integer id){
        empleadoService.deleteEmpleado(id);
    }
}
