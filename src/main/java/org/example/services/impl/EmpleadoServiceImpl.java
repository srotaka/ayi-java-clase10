package org.example.services.impl;

import org.example.configuration.ConexionDB;
import org.example.constants.Constants;
import org.example.dtos.request.EmpleadoRequestDTO;
import org.example.dtos.response.EmpleadoResponseDTO;
import org.example.entities.Empleado;
import org.example.mappers.EmpleadoMapper;
import org.example.services.IEmpleadoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoServiceImpl implements IEmpleadoService {

    EmpleadoMapper mapper = new EmpleadoMapper();
    private ConexionDB conexionDB = new ConexionDB();
    private ConexionDB conexionDBAux = new ConexionDB();
    Connection conn = null;
    Connection connAux = null;
    PreparedStatement stmt = null;
    PreparedStatement stmtAux = null;
    ResultSet rs = null;
    ResultSet rsAux = null;

    @Override
    public void createEmpleado(EmpleadoRequestDTO empleadoRequest) {
        int indInsert = 0;
        conexionDB = new ConexionDB();
        conn = null;
        stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_INSERT_EMPLEADO);

            stmt.setString(1, empleadoRequest.getNombre());
            stmt.setString(2, empleadoRequest.getApellido());
            stmt.setInt(3, empleadoRequest.getEdad());
            stmt.setString(4, empleadoRequest.getDireccion());
            stmt.setString(5, empleadoRequest.getCiudad());
            stmt.setDouble(6, empleadoRequest.getSueldo());
            stmt.setString(7, empleadoRequest.getPuesto());

            indInsert = stmt.executeUpdate();

            if(indInsert == 0){
                System.out.println("No se ha podido insertar");
                throw new RuntimeException();
            } else {
                System.out.println("Se ha insertado a " + empleadoRequest.getNombre() + " " + empleadoRequest.getApellido());
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
        //return indInsert;
    }

    @Override
    public void updateEmpleado(Integer id, EmpleadoRequestDTO empleadoRequestDTO) {
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
            stmt = conn.prepareStatement(Constants.SQL_UPDATE_EMPLEADO);

            stmt.setDouble(1, empleadoRequestDTO.getSueldo());
            stmt.setString(2, empleadoRequestDTO.getPuesto());
            stmt.setInt(3, id);

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

    }

    @Override
    public List<EmpleadoResponseDTO> getAllEmpleados() {
        List<EmpleadoResponseDTO> listaEmpleados = new ArrayList<>();

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_SELECT_EMPLEADO);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Integer edad = rs.getInt("edad");
                String direccion = rs.getString("direccion");
                String ciudad = rs.getString("ciudad");
                Double sueldo = rs.getDouble("sueldo");
                String puesto = rs.getString("puesto");

                Empleado empleado = new Empleado(id, nombre, apellido, edad, direccion, sueldo, puesto, ciudad);

                listaEmpleados.add(mapper.entityToDto(empleado));
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
        return listaEmpleados;
    }

    @Override
    public void deleteEmpleado(Integer id) {
        conexionDB = new ConexionDB();
        stmt = null;
        int indInsert = 0, validacion = 0;

        try {
            validacion = validarID(id);

            if (validacion == 0) {
                throw  new RuntimeException("No existe el ID " + id);
            }
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_DELETE_EMPLEADO);
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

    /*  VALIDACIONES */
    public Integer validarID(Integer id){
        conexionDBAux = new ConexionDB();
        int result = 0;
        try {
            connAux = conexionDBAux.getConnection();
            stmtAux = connAux.prepareStatement(Constants.SQL_SELECT_EMPLEADO_BY_ID);
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
