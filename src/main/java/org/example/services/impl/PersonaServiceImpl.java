package org.example.services.impl;

import org.example.configuration.ConexionDB;
import org.example.constants.Constants;
import org.example.entities.Persona;
import org.example.services.IPersonaService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaServiceImpl implements IPersonaService {


    private ConexionDB conexionDB = new ConexionDB();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public List<Persona> getAllPersonas() {

        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_SELECT_PERSON);
            rs = stmt.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Integer edad = rs.getInt("edad");
                String direccion = rs.getString("direccion");

                persona = new Persona(id, nombre, apellido, edad, direccion);
                personas.add(persona);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexionDB.close(rs);
                conexionDB.close(stmt);
                conexionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }

}
