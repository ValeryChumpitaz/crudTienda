package vallegrade.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class FrmConstruccion extends JFrame {

    public FrmConstruccion() {
        setTitle("Módulo en construcción");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel lblMensaje = new JLabel("🚧 Módulo en Construcción 🚧", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Arial", Font.BOLD, 20));

        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.addActionListener(e -> {
            dispose();
            new FrmMenu().setVisible(true);
        });

        add(lblMensaje, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);
    }
}
