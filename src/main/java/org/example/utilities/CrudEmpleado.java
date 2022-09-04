package org.example.utilities;

import org.example.controllers.EmpleadoController;
import org.example.dtos.request.EmpleadoRequestDTO;
import org.example.dtos.response.EmpleadoResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class CrudEmpleado {

    public void crud(){
        EmpleadoController empleadoController = new EmpleadoController();
        DatosRandom random = new DatosRandom();
        EmpleadoRequestDTO empleado1 = new EmpleadoRequestDTO();
        List<EmpleadoResponseDTO> listaEmpleados = new ArrayList<>();

        empleado1.setNombre(random.nombreRandom());
        empleado1.setApellido(random.apellidoRandom());
        empleado1.setEdad(random.edadRandom());
        empleado1.setDireccion(random.direccionRandom());
        empleado1.setCiudad(random.ciudadRandom());
        empleado1.setPuesto(random.puestoRandom());
        empleado1.setSueldo(random.sueldoRandom());

        System.out.println("---- Crear Empleado ----");
        empleadoController.createEmpleado(empleado1);

        // ACTUALIZAR PERSONA POR ID
        System.out.println("---- Actualizar Empleado por ID----");
        empleado1.setSueldo(random.sueldoRandom());
        empleado1.setPuesto(random.puestoRandom());
        empleadoController.updateEmpleado(1, empleado1);

        //ELIMINAR EMPLEADO POR ID
        System.out.println("---- Eliminar Empleado por ID ----");
       // empleadoController.deleteEmpleado(2);

        // LISTAR EMPLEADOS
        System.out.println("---- Listado de Empleados ----");
        listaEmpleados = empleadoController.listarEmpleados();
        for (EmpleadoResponseDTO empleado : listaEmpleados) {
            System.out.println(empleado);
        }



    }
}
