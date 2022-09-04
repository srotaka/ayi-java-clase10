package org.example.services.impl;

import org.example.configuration.ConexionDB;
import org.example.constants.Constants;
import org.example.dtos.request.ClienteRequestDTO;
import org.example.dtos.response.ClienteResponseDTO;
import org.example.entities.Cliente;
import org.example.mappers.ClienteMapper;
import org.example.services.IClienteService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteServiceImpl implements IClienteService {
    ClienteMapper mapper = new ClienteMapper();
    private ConexionDB conexionDB = new ConexionDB();
    private ConexionDB conexionDBAux = new ConexionDB();
    Connection conn = null;
    Connection connAux = null;
    PreparedStatement stmt = null;
    PreparedStatement stmtAux = null;
    ResultSet rs = null;
    ResultSet rsAux = null;

    @Override
    public void createCliente(ClienteRequestDTO clienteRequestDTO) {
        int indInsert = 0;
        conexionDB = new ConexionDB();
        conn = null;
        stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_INSERT_CLIENTE);

            stmt.setString(1, clienteRequestDTO.getNombre());
            stmt.setString(2, clienteRequestDTO.getApellido());
            stmt.setInt(3, clienteRequestDTO.getEdad());
            stmt.setString(4, clienteRequestDTO.getDireccion());
            stmt.setString(5, clienteRequestDTO.getCiudad());
            stmt.setString(6, clienteRequestDTO.getEmail());
            stmt.setString(7, clienteRequestDTO.getVip());

            indInsert = stmt.executeUpdate();

            if(indInsert == 0){
                System.out.println("No se ha podido insertar");
                throw new RuntimeException();
            } else {
                System.out.println("Se ha insertado a " + clienteRequestDTO.getNombre() + " " + clienteRequestDTO.getApellido());
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

    }

    @Override
    public void updateCliente(Integer id, ClienteRequestDTO clienteRequestDTO) {
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
            stmt = conn.prepareStatement(Constants.SQL_UPDATE_CLIENTE);

            stmt.setString(1, clienteRequestDTO.getDireccion());
            stmt.setString(2, clienteRequestDTO.getCiudad());
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
    public List<ClienteResponseDTO> getAllClientes() {

        List<ClienteResponseDTO> listaCliente = new ArrayList<>();
        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_SELECT_CLIENTE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Integer edad = rs.getInt("edad");
                String direccion = rs.getString("direccion");
                String ciudad = rs.getString("ciudad");
                String email = rs.getString("email");
                String vip = rs.getString("vip");


                Cliente cliente =  new Cliente(id, nombre, apellido, edad, direccion, email, ciudad, vip);

                listaCliente.add(mapper.entityToDto(cliente));
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
        return listaCliente;
    }

    @Override
    public void deleteCliente(Integer id) {
        conexionDB = new ConexionDB();
        stmt = null;
        int indInsert = 0, validacion = 0;

        try {
            validacion = validarID(id);

            if (validacion == 0) {
                throw  new RuntimeException("No existe el ID " + id);
            }
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_DELETE_CLIENTE);
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
            stmtAux = connAux.prepareStatement(Constants.SQL_SELECT_CLIENTE_BY_ID);
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
