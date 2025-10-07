package vallegrade.edu.pe.view;

import vallegrade.edu.pe.controller.ProductoController;
import vallegrade.edu.pe.model.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FrmProducto extends JFrame {

    public JTable tabla;
    public JButton btnAgregar, btnActualizar, btnEliminar, btnLimpiar;
    public JTextField txtId, txtNombre, txtPrecio, txtStock, txtBuscar;
    private DefaultTableModel modelo;

    public FrmProducto() {
        setTitle("Gestión de Productos");
        setSize(750, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ======= PANEL DE FORMULARIO =======
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));

        txtId = new JTextField();
        txtId.setEditable(false);
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtStock = new JTextField();
        txtBuscar = new JTextField();

        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(txtId);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Precio:"));
        panelFormulario.add(txtPrecio);
        panelFormulario.add(new JLabel("Stock:"));
        panelFormulario.add(txtStock);

        // ======= PANEL DE BOTONES =======
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        // ======= PANEL DE TABLA =======
        modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Stock"}, 0);
        tabla = new JTable(modelo);

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        panelTabla.add(new JScrollPane(tabla), BorderLayout.CENTER);

        // ======= PANEL DE BUSCAR =======
        JPanel panelBuscar = new JPanel(new BorderLayout(5, 5));
        panelBuscar.add(new JLabel("Buscar:"), BorderLayout.WEST);
        panelBuscar.add(txtBuscar, BorderLayout.CENTER);

        // ======= AGREGAR A LA VISTA =======
        add(panelFormulario, BorderLayout.NORTH);
        add(panelTabla, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        add(panelBuscar, BorderLayout.PAGE_START);

        // ======= Iniciar controlador =======
        new ProductoController(this);
    }

    // === Mostrar lista ===
    public void mostrarProductos(List<Producto> lista) {
        modelo.setRowCount(0);
        for (Producto p : lista) {
            modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getPrecio(), p.getStock()});
        }
    }

    // === Obtener datos del formulario ===
    public Producto obtenerDatosFormulario() {
        Producto p = new Producto();
        if (!txtId.getText().isEmpty()) {
            p.setId(Integer.parseInt(txtId.getText()));
        }
        p.setNombre(txtNombre.getText());
        p.setPrecio(Double.parseDouble(txtPrecio.getText()));
        p.setStock(Integer.parseInt(txtStock.getText()));
        return p;
    }

    public int obtenerIdSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            return Integer.parseInt(tabla.getValueAt(fila, 0).toString());
        }
        return 0;
    }

    public void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }

    public String getTextoBusqueda() {
        return txtBuscar.getText();
    }
}
