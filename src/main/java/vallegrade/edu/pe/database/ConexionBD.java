package vallegrade.edu.pe.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_tienda";
    private static final String USER =  "root";
    private static final String PASS = "Valery2025";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Conexion exitosa a la BD");
        } catch (Exception e){
            System.out.println("Error en la conexion: " + e.getMessage());
    }
        return conn;
}
}