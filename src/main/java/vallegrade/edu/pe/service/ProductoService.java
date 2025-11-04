package vallegrade.edu.pe.service;


import vallegrade.edu.pe.model.Producto;
import vallegrade.edu.pe.model.ProductoDAO;

import java.util.List;

public class ProductoService {

    private final ProductoDAO dao;

    public ProductoService() {
        dao = new ProductoDAO();
    }

    public List<Producto> obtenerProductos() {
        return dao.listar();
    }

    public boolean agregarProducto(Producto p) {
        return dao.insertar(p);
    }

    public boolean actualizarProducto(Producto p) {
        return dao.actualizar(p);
    }

    public boolean eliminarProducto(int id) {
        return dao.eliminar(id);
    }

    public List<Producto> buscarProducto(String texto) {
        return dao.buscar(texto);
    }
}
