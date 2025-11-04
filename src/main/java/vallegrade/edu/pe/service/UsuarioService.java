package vallegrade.edu.pe.service;


import vallegrade.edu.pe.model.UsuarioDAO;

public class UsuarioService {
    private final UsuarioDAO dao;

    public UsuarioService() {
        dao = new UsuarioDAO();
    }

    public boolean validarUsuario(String usuario, String contrasena) {
        return dao.validar(usuario, contrasena);
    }
}
