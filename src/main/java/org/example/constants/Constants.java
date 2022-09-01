package org.example.constants;

public class Constants {
    /**
     * SQL queries person entity constant.
     */
    public static final String SQL_SELECT_PERSON = "SELECT id, nombre, apellido, edad, direccion FROM personas";
    public static final String SQL_INSERT_PERSON = "INSERT INTO personas(nombre, apellido, edad, direccion) VALUES(?, ?, ?, ?)";
    public static final String SQL_UPDATE_PERSON = "UPDATE personas SET nombre = ?, apellido = ?, edad = ?, direccion = ? WHERE id = ?";
    public static final String SQL_DELETE_PERSON = "DELETE FROM personas WHERE id = ?";

    /**
     * Variables de conexion a la base de datos.     */

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/curso_ayi_db?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "root";


}
