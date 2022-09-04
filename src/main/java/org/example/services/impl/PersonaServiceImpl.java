package org.example.services.impl;

import org.example.configuration.ConexionDB;
import org.example.constants.Constants;
import org.example.dtos.request.PersonaRequestDTO;
import org.example.dtos.response.PersonaResponseDTO;
import org.example.entities.Persona;
import org.example.mappers.PersonaMapper;
import org.example.services.IPersonaService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaServiceImpl implements IPersonaService {

    PersonaMapper personaMapper = new PersonaMapper();
    private ConexionDB conexionDB = new ConexionDB();
    private ConexionDB conexionDBAux = new ConexionDB();
    Connection conn = null;
    Connection connAux = null;
    PreparedStatement stmt = null;
    PreparedStatement stmtAux = null;
    ResultSet rs = null;
    ResultSet rsAux = null;


    @Override
    public Integer createPersona(PersonaRequestDTO personaRequest){
        int indInsert = 0;
        conexionDB = new ConexionDB();
        conn = null;
        stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_INSERT_PERSON);

            stmt.setString(1, personaRequest.getNombre());
            stmt.setString(2, personaRequest.getApellido());
            stmt.setInt(3, personaRequest.getEdad());
            stmt.setString(4, personaRequest.getDireccion());

            indInsert = stmt.executeUpdate();

            if(indInsert == 0){
                System.out.println("No se ha podido insertar");
                throw new RuntimeException();
            } else {
                System.out.println("Se ha insertado a " + personaRequest.getNombre() + " " + personaRequest.getApellido());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException ex){
            System.out.println("No se ha podido insertar los datos en la Base de Datos");
        } finally {
            try {
                conexionDB.close(stmt);
                conexionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }


        return indInsert;
    }

    @Override
    public Integer updatePersona(Integer id, PersonaRequestDTO personaRequest) {

        conexionDB = new ConexionDB();
        conn = null;
        stmt = null;

        Integer indInsert = 0, validacion = 0;

        try {
            validacion = validarID(id);

            if(validacion == 0){
                throw new RuntimeException("No existe el ID " + id);
            }
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_UPDATE_PERSON);

            stmt.setString(1, personaRequest.getNombre());
            stmt.setString(2, personaRequest.getApellido());
            stmt.setInt(3, personaRequest.getEdad());
            stmt.setString(4, personaRequest.getDireccion());
            stmt.setInt(5, id);

            indInsert = stmt.executeUpdate();

            if(indInsert == 0){
                System.out.println("No se ha podido modificar los datos.");
                throw new RuntimeException();
            } else {
                System.out.println("ID " + id + " modificado exitosamente.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException ex){
            System.out.println("No se ha podido modificiar los datos.");
        } finally {
            try {
                if(stmt != null) {
                    conexionDB.close(stmt);
                    conexionDB.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return indInsert;
    }

    @Override
    public void deletePersona(Integer id) {
        conexionDB = new ConexionDB();
        stmt = null;
        int indInsert = 0, validacion = 0;

        try {
            validacion = validarID(id);

            if (validacion == 0) {
                throw  new RuntimeException("No existe el ID " + id);
            }
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_DELETE_PERSON);
            stmt.setInt(1, id);

            indInsert = stmt.executeUpdate();

            if (indInsert == 0) {
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    conexionDB.close(stmt);
                    conexionDB.close(conn);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("ID " + id + " borrado exitosamente.");
    }

    @Override
    public List<PersonaResponseDTO> getAllPersonas() {

        Persona persona = null;
        List<PersonaResponseDTO> personas = new ArrayList<>();

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

                personas.add(personaMapper.entityToDto(persona));
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

    public Integer validarID(Integer id){

        conexionDBAux = new ConexionDB();
        int result = 0;

        try {
            connAux = conexionDBAux.getConnection();
            stmtAux = connAux.prepareStatement(Constants.SQL_SELECT_PERSON_BY_ID);
            stmtAux.setInt(1, id);
            rsAux = stmtAux.executeQuery();

            if(!rsAux.next()){
                throw new RuntimeException("No se ha encontrado el ID " + id);
            } else {
                System.out.println("ID " + id + " encontrado en Base de Datos.");
                result = 1;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexionDBAux.close(rsAux);
                conexionDBAux.close(stmtAux);
                conexionDBAux.close(connAux);
            } catch (SQLException ex) {
                throw new RuntimeException("Error al cerrar la conexión con la BD.");
            }
        }
        return result;
    }


}
