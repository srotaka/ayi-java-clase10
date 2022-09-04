package org.example;

import org.example.utilities.CrudCliente;
import org.example.utilities.CrudEmpleado;
import org.example.utilities.CrudPersona;


public class Main {
    public static void main(String[] args) {
        CrudPersona crudPersona = new CrudPersona();
        CrudEmpleado crudEmpleado = new CrudEmpleado();
        CrudCliente crudCliente = new CrudCliente();

        crudPersona.crud();
        crudEmpleado.crud();
        crudCliente.crud();

    }


}