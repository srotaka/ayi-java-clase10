package org.example.utilities;

import org.example.controllers.ClienteController;
import org.example.dtos.request.ClienteRequestDTO;
import org.example.dtos.response.ClienteResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class CrudCliente {

    public void crud(){
        ClienteController clienteController = new ClienteController();
        DatosRandom random = new DatosRandom();
        ClienteRequestDTO cliente1 = new ClienteRequestDTO();
        List<ClienteResponseDTO> listaClientes = new ArrayList<>();

        cliente1.setNombre(random.nombreRandom());
        cliente1.setApellido(random.apellidoRandom());
        cliente1.setEdad(random.edadRandom());
        cliente1.setDireccion(random.direccionRandom());
        cliente1.setCiudad(random.ciudadRandom());
        cliente1.setEmail(cliente1.getNombre().toLowerCase() + "@" + cliente1.getApellido().toLowerCase() + ".com");
        cliente1.setVip(random.vipRandom());

        System.out.println("---- Crear Cliente ----");
        clienteController.createCliente(cliente1);

        // ACTUALIZAR CLIENTE POR ID
        System.out.println("---- Actualizar Cliente por ID----");
        cliente1.setDireccion(random.direccionRandom());
        cliente1.setCiudad(random.ciudadRandom());
        clienteController.updateCliente(1, cliente1);

          // LISTAR CLIENTES
        System.out.println("---- Listado de Clientes ----");
        listaClientes = clienteController.listarClientes();
        for (ClienteResponseDTO cliente : listaClientes) {
            System.out.println(cliente);
        }

        //ELIMINAR CLIENTE POR ID
        System.out.println("---- Eliminar Cliente por ID ----");
       // clienteController.deleteCliente(5);


    }
}
