package vallegrade.edu.pe.controller;



import vallegrade.edu.pe.service.UsuarioService;
import vallegrade.edu.pe.view.FrmLogin;
import vallegrade.edu.pe.view.FrmMenu;

import javax.swing.*;

public class LoginController {

    private final FrmLogin vista;
    private final UsuarioService service;

    public LoginController(FrmLogin vista) {
        this.vista = vista;
        this.service = new UsuarioService();

        this.vista.btnLogin.addActionListener(e -> validarLogin());
    }

    private void validarLogin() {
        String usuario = vista.txtUsuario.getText().trim();
        String contrasena = new String(vista.txtContrasena.getPassword());

        if (service.validarUsuario(usuario, contrasena)) {
            JOptionPane.showMessageDialog(vista, "Bienvenido " + usuario + "!");
            vista.dispose();
            new FrmMenu().setVisible(true); // ✅ Ir al menú principal
        } else {
            JOptionPane.showMessageDialog(vista, "Credenciales incorrectas.");
        }
    }
}
