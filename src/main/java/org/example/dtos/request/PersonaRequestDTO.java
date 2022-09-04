package org.example.dtos.request;

public class PersonaRequestDTO {
    protected String nombre;
    protected String apellido;
    protected Integer edad;
    protected String direccion;

    public PersonaRequestDTO() {
    }

    public PersonaRequestDTO(String nombre, String apellido, Integer edad, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return  "\n- DATOS PERSONA" +
                "\n\t- Nombre: " + nombre +
                "\n\t- Apellido: " + apellido +
                "\n\t- Edad: " + edad +
                "\n\t- Dirección: " + direccion;
    }


}
