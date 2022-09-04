package org.example.dtos.request;

public class EmpleadoRequestDTO extends PersonaRequestDTO{

    private Double sueldo;
    private String puesto;
    private String ciudad;

    public EmpleadoRequestDTO() {
    }

    public EmpleadoRequestDTO(String nombre, String apellido, Integer edad, String direccion, Double sueldo, String puesto, String ciudad) {
        super(nombre, apellido, edad, direccion);
        this.sueldo = sueldo;
        this.puesto = puesto;
        this.ciudad = ciudad;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    @Override
    public String toString() {
        return "Empleado: " +
                "\n\t- Nombre: " + nombre +
                "\n\t- Apellido: " + apellido +
                "\n\t- Edad: " + edad + " años" +
                "\n\t- Dirección: " + direccion +
                "\n\t- Ciudad: " + ciudad +
                "\n\t- Sueldo: USD " + sueldo +
                "\n\t- Puesto: " + puesto;
    }
}
