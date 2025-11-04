package vallegrade.edu.pe.view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class FrmMenu extends JFrame {

    public JButton btnProductos, btnClientes, btnSalir;
    private JLabel lblTitulo;

    public FrmMenu() {
        setTitle("✨ Menú Principal - Sistema de Gestión ✨");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Fondo con panel personalizado
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0,
                        new Color(58, 123, 213), getWidth(), getHeight(),
                        new Color(0, 210, 255));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelFondo.setLayout(new BorderLayout(20, 20));
        panelFondo.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        // ====== TÍTULO ======
        lblTitulo = new JLabel("Menú Principal", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
        lblTitulo.setForeground(Color.WHITE);
        panelFondo.add(lblTitulo, BorderLayout.NORTH);

        // ====== PANEL DE BOTONES ======
        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new GridLayout(3, 1, 25, 25));

        btnProductos = crearBoton("🛒  Gestión de Productos", new Color(255, 255, 255));
        btnClientes = crearBoton("👥  Módulo Clientes (En construcción)", new Color(255, 255, 255));
        btnSalir = crearBoton("🚪  Cerrar Sesión", new Color(255, 255, 255));

        panelBotones.add(btnProductos);
        panelBotones.add(btnClientes);
        panelBotones.add(btnSalir);

        panelFondo.add(panelBotones, BorderLayout.CENTER);

        add(panelFondo);

        // ====== ACCIONES ======
        btnProductos.addActionListener(e -> {
            dispose();
            new FrmProducto().setVisible(true);
        });

        btnClientes.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "🚧 Este módulo está en construcción 🚧",
                        "Información", JOptionPane.INFORMATION_MESSAGE)
        );

        btnSalir.addActionListener(e -> {
            dispose();
            new FrmLogin().setVisible(true);
        });
    }

    // ====== MÉTODO PARA CREAR BOTONES REDONDEADOS CON EFECTOS ======
    private JButton crearBoton(String texto, Color colorTexto) {
        JButton boton = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint grad = new GradientPaint(0, 0, new Color(255, 255, 255, 220),
                        getWidth(), getHeight(), new Color(255, 255, 255, 180));
                g2.setPaint(grad);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));

                g2.setColor(new Color(255, 255, 255, 100));
                g2.setStroke(new BasicStroke(2f));
                g2.draw(new RoundRectangle2D.Double(1, 1, getWidth() - 2, getHeight() - 2, 25, 25));
                g2.dispose();
                super.paintComponent(g);
            }
        };
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setForeground(new Color(50, 50, 50));
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        boton.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efecto hover
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setForeground(new Color(25, 118, 210));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setForeground(new Color(50, 50, 50));
            }
        });

        return boton;
    }

    // ====== MAIN PARA PRUEBA ======
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmMenu().setVisible(true));
    }
}
