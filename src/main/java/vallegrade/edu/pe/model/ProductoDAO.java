package vallegrade.edu.pe.model;

import vallegrade.edu.pe.database.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private static final String SQL_SELECT = "SELECT id, nombre, precio, stock FROM producto";
    private static final String SQL_SELECT_BY_ID = "SELECT id, nombre, precio, stock FROM producto WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO producto (nombre, precio, stock) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE producto SET nombre = ?, precio = ?, stock = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE id = ?";

   
}
