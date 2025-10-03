package vallegrade.edu.pe.controller;

import vallegrade.edu.pe.model.Producto;
import vallegrade.edu.pe.service.ProductoService;
import vallegrade.edu.pe.view.FrmProducto;

import javax.swing.*;
import java.util.List;

public class ProductoController {
    private ProductoService service;
    private FrmProducto vista;

    public ProductoController(FrmProducto vista) {
        this.vista = vista;
        this.service = new ProductoService();
        cargarProductos();

        this.vista.btnAgregar.addActionListener(e -> agregarProducto());
        this.vista.btnModificar.addActionListener(e -> modificarProducto());
        this.vista.btnActualizar.addActionListener(e -> cargarProductos());
    }

    private void cargarProductos() {
        List<Producto> lista = service.obtenerProductos();
        vista.mostrarProductos(lista);
    }

    private void agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Stock:"));

        Producto nuevo = new Producto(0, nombre, precio, stock);
        if (service.agregarProducto(nuevo)) {
            JOptionPane.showMessageDialog(vista, "Producto agregado");
            cargarProductos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar");
        }
    }

    private void modificarProducto() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un producto");
            return;
        }

        int id = (int) vista.tabla.getValueAt(fila, 0);
        String nombre = JOptionPane.showInputDialog("Nuevo nombre:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Nuevo stock:"));

        Producto modificado = new Producto(id, nombre, precio, stock);
        if (service.actualizarProducto(modificado)) {
            JOptionPane.showMessageDialog(vista, "Producto actualizado");
            cargarProductos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al actualizar");
        }
    }
}
