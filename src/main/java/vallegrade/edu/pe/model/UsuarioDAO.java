package vallegrade.edu.pe.model;

import vallegrade.edu.pe.database.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public Usuario validarLogin(String user, String pass) {
        Usuario u = null;
        String sql = "SELECT * FROM usuario WHERE usuario=? AND contrasena=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("usuario"),
                        rs.getString("contrasena")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
        }
        return u;
    }
    // Validación básica sin base de datos
    public boolean validar(String usuario, String contrasena) {
        return usuario.equals("admin") && contrasena.equals("1234");
    }
}
