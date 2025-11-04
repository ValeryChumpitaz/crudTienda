package vallegrade.edu.pe.view;



import vallegrade.edu.pe.controller.ProductoController;
import vallegrade.edu.pe.model.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FrmProducto extends JFrame {

    public JTable tabla;
    public JButton btnAgregar, btnActualizar, btnEliminar, btnLimpiar, btnVolver;
    public JTextField txtId, txtNombre, txtPrecio, txtStock, txtBuscar;
    private DefaultTableModel modelo;

    public FrmProducto() {
        setTitle("Gestión de Productos");
        setSize(750, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));

        txtId = new JTextField(); txtId.setEditable(false);
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtStock = new JTextField();
        txtBuscar = new JTextField();

        panelFormulario.add(new JLabel("ID:")); panelFormulario.add(txtId);
        panelFormulario.add(new JLabel("Nombre:")); panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Precio:")); panelFormulario.add(txtPrecio);
        panelFormulario.add(new JLabel("Stock:")); panelFormulario.add(txtStock);

        // Panel botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");
        btnVolver = new JButton("Volver al Menú");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnVolver);

        modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Stock"}, 0);
        tabla = new JTable(modelo);
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        panelTabla.add(new JScrollPane(tabla), BorderLayout.CENTER);

        add(panelFormulario, BorderLayout.NORTH);
        add(panelTabla, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnVolver.addActionListener(e -> {
            dispose();
            new FrmMenu().setVisible(true);
        });

        new ProductoController(this);
    }

    public void mostrarProductos(List<Producto> lista) {
        modelo.setRowCount(0);
        for (Producto p : lista) {
            modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getPrecio(), p.getStock()});
        }
    }
}
