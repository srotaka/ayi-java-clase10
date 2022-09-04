package org.example.services;

import org.example.dtos.request.EmpleadoRequestDTO;
import org.example.dtos.response.EmpleadoResponseDTO;
import java.util.List;

public interface IEmpleadoService {

    void createEmpleado(EmpleadoRequestDTO empleado);
    void updateEmpleado(Integer id, EmpleadoRequestDTO empleado);
    List<EmpleadoResponseDTO> getAllEmpleados();
    void deleteEmpleado(Integer id);
}
