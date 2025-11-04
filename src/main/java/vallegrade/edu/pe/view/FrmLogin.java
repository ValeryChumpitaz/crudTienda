package vallegrade.edu.pe.view;


import vallegrade.edu.pe.controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class FrmLogin extends JFrame {

    public JTextField txtUsuario;
    public JPasswordField txtContrasena;
    public JButton btnLogin;

    public FrmLogin() {
        setTitle("Inicio de Sesión");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel lblTitulo = new JLabel("LOGIN - APP DESKTOP", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel panelUsuario = new JPanel(new FlowLayout());
        panelUsuario.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField(15);
        panelUsuario.add(txtUsuario);

        JPanel panelPass = new JPanel(new FlowLayout());
        panelPass.add(new JLabel("Contraseña:"));
        txtContrasena = new JPasswordField(15);
        panelPass.add(txtContrasena);

        btnLogin = new JButton("Iniciar Sesión");

        add(lblTitulo);
        add(panelUsuario);
        add(panelPass);
        add(btnLogin);

        new     LoginController(this);
    }
}
