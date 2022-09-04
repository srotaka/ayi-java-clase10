package org.example.constants;

public class Constants {
    /**
     * SQL queries PERSONA entity constant.
     */
    public static final String SQL_SELECT_PERSON = "SELECT id, nombre, apellido, edad, direccion FROM personas";
    public static final String SQL_SELECT_PERSON_BY_ID = "SELECT id FROM personas WHERE id = ?";
    public static final String SQL_INSERT_PERSON = "INSERT INTO personas(nombre, apellido, edad, direccion) VALUES(?, ?, ?, ?)";
    public static final String SQL_UPDATE_PERSON = "UPDATE personas SET nombre = ?, apellido = ?, edad = ?, direccion = ? WHERE id = ?";
    public static final String SQL_DELETE_PERSON = "DELETE FROM personas WHERE id = ?";


    /**
     * SQL queries EMPLEADO entity constant.
     */

    public static final String SQL_SELECT_EMPLEADO = "SELECT id, nombre, apellido, edad, direccion, ciudad, sueldo, puesto FROM empleados";
    public static final String SQL_INSERT_EMPLEADO = "INSERT INTO empleados(nombre, apellido, edad, direccion, ciudad, sueldo, puesto) VALUES(?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_SELECT_EMPLEADO_BY_ID = "SELECT id FROM empleados WHERE id = ?";
    public static final String SQL_UPDATE_EMPLEADO = "UPDATE empleados SET sueldo = ?, puesto = ? WHERE id = ?";
    public static final String SQL_DELETE_EMPLEADO = "DELETE FROM empleados WHERE id = ?";

    /**
     * SQL queries CLIENTE entity constant.
     */

    public static final String SQL_SELECT_CLIENTE = "SELECT id, nombre, apellido, edad, direccion, ciudad, email, vip FROM clientes";
    public static final String SQL_INSERT_CLIENTE = "INSERT INTO clientes(nombre, apellido, edad, direccion, ciudad, email, vip) VALUES(?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_SELECT_CLIENTE_BY_ID = "SELECT id FROM clientes WHERE id = ?";
    public static final String SQL_UPDATE_CLIENTE = "UPDATE clientes SET direccion = ?, ciudad = ? WHERE id = ?";
    public static final String SQL_DELETE_CLIENTE = "DELETE FROM clientes WHERE id = ?";

    /**
     * Variables de conexion a la base de datos.
     */

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/curso_ayi_db?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "root";


}
