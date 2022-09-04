package org.example.dtos.request;

public class ClienteRequestDTO extends PersonaRequestDTO{

    private String email;
    private String ciudad;
    private String vip;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nombre, String apellido, Integer edad, String direccion, String email, String ciudad, String vip) {
        super(nombre, apellido, edad, direccion);
        this.email = email;
        this.ciudad = ciudad;
        this.vip = vip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "\n\t- Nombre: " + nombre +
                "\n\t- Apellido: " + apellido +
                "\n\t- Edad: " + edad + " años" +
                "\n\t- Dirección: " + direccion +
                "\n\t- Ciudad: " + ciudad +
                "\n\t- Email: " + email +
                "\n\t- VIP: " + vip;
    }
}
