package vallegrade.edu.pe.controller;


import vallegrade.edu.pe.model.Producto;
import vallegrade.edu.pe.service.ProductoService;
import vallegrade.edu.pe.view.FrmProducto;

import javax.swing.*;
import java.util.List;

public class ProductoController {

    private final FrmProducto vista;
    private final ProductoService service;

    public ProductoController(FrmProducto vista) {
        this.vista = vista;
        this.service = new ProductoService();

        // Cargar lista inicial
        cargarProductos();

        // Asignar eventos a los botones
        this.vista.btnAgregar.addActionListener(e -> agregarProducto());
        this.vista.btnActualizar.addActionListener(e -> actualizarProducto());
        this.vista.btnEliminar.addActionListener(e -> eliminarProducto());
        this.vista.btnLimpiar.addActionListener(e -> limpiarFormulario());
    }

    // === Cargar todos los productos ===
    private void cargarProductos() {
        List<Producto> lista = service.obtenerProductos();
        vista.mostrarProductos(lista);
    }

    // === Agregar un producto ===
    private void agregarProducto() {
        try {
            String nombre = vista.txtNombre.getText().trim();
            double precio = Double.parseDouble(vista.txtPrecio.getText().trim());
            int stock = Integer.parseInt(vista.txtStock.getText().trim());

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debe ingresar un nombre.");
                return;
            }

            Producto nuevo = new Producto(0, nombre, precio, stock);

            if (service.agregarProducto(nuevo)) {
                JOptionPane.showMessageDialog(vista, "Producto agregado exitosamente.");
                limpiarFormulario();
                cargarProductos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al agregar el producto.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Verifique los datos numéricos (precio, stock).");
        }
    }

    // === Actualizar producto seleccionado ===
    private void actualizarProducto() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un producto de la tabla.");
            return;
        }

        try {
            int id = (int) vista.tabla.getValueAt(fila, 0);
            String nombre = vista.txtNombre.getText().trim();
            double precio = Double.parseDouble(vista.txtPrecio.getText().trim());
            int stock = Integer.parseInt(vista.txtStock.getText().trim());

            Producto modificado = new Producto(id, nombre, precio, stock);

            if (service.actualizarProducto(modificado)) {
                JOptionPane.showMessageDialog(vista, "Producto actualizado correctamente.");
                limpiarFormulario();
                cargarProductos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar el producto.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Verifique los datos numéricos (precio, stock).");
        }
    }

    // === Eliminar producto ===
    private void eliminarProducto() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un producto a eliminar.");
            return;
        }

        int id = (int) vista.tabla.getValueAt(fila, 0);

        int confirm = JOptionPane.showConfirmDialog(vista, "¿Desea eliminar este producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (service.eliminarProducto(id)) {
                JOptionPane.showMessageDialog(vista, "Producto eliminado exitosamente.");
                limpiarFormulario();
                cargarProductos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al eliminar el producto.");
            }
        }
    }

    // === Limpiar los campos del formulario ===
    private void limpiarFormulario() {
        vista.txtId.setText("");
        vista.txtNombre.setText("");
        vista.txtPrecio.setText("");
        vista.txtStock.setText("");
    }
}
