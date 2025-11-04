package vallegrade.edu.pe.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_tienda";
    private static final String USUARIO =  "root";
    private static final String CLAVE = "valery2025";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection conectar() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conn;
    }
}
