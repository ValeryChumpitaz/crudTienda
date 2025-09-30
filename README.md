
# 🛒 CRUD Tienda – Java Swing + MySQL

![Java](https://img.shields.io/badge/Java-17-red?logo=openjdk)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?logo=mysql)
![Swing](https://img.shields.io/badge/Swing-UI-green)
![MVC](https://img.shields.io/badge/Pattern-MVC-orange)

Este proyecto implementa un sistema de **gestión para tienda** con **CRUD (Crear, Leer, Actualizar, Eliminar)** de entidades como **Productos, Clientes y Ventas**, aplicando el patrón de diseño **MVC** para mantener la separación de responsabilidades.  

## ✨ Características
- Conexión a **MySQL** usando JDBC.  
- CRUD completo para entidades de la tienda.  
- Interfaz gráfica desarrollada en **Java Swing**.  
- Uso de **DAO + Service** para el acceso y la lógica de negocio.  
- Arquitectura organizada en paquetes:  
  - `modelo` → entidades y DAO  
  - `servicio` → lógica de negocio  
  - `vista` → interfaces Swing  
  - `controlador` → control de flujos  
  - `util` → conexión a la BD  

## 🛠️ Tecnologías
- **Java 17**  
- **MySQL 8.0**  
- **Swing (Java Desktop UI)**  
- **JDBC**  

## 📂 Estructura del Proyecto
```plaintext
src/
 └── tienda/
      ├── modelo/
      │    ├── Producto.java
      │    ├── ProductoDAO.java
      │    └── ...
      ├── servicio/
      │    └── ProductoService.java
      ├── vista/
      │    └── FrmProducto.java
      ├── controlador/
      │    └── ProductoController.java
      └── util/
           └── ConexionBD.java
````

## 🗄️ Script SQL

Ejemplo de tabla `producto` en MySQL:

```sql
CREATE DATABASE tienda_db;
USE tienda_db;

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

INSERT INTO producto (nombre, precio, stock) 
VALUES 
('Laptop', 2500.00, 10),
('Mouse', 50.00, 100),
('Teclado', 120.00, 50);
```

## 🚀 Ejecución

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/tuusuario/CRUD-Tienda.git
   cd CRUD-Tienda
   ```
2. Importar el proyecto en **IntelliJ IDEA / Eclipse / NetBeans**.
3. Configurar la conexión a MySQL en `util/ConexionBD.java`.
4. Ejecutar la clase principal de la vista (`FrmProducto` o similar).

## 📌 Objetivo del Proyecto

Este proyecto está orientado a la práctica y enseñanza de:

* Manejo de **Java Swing** para interfaces gráficas.
* Conexión y manipulación de datos con **MySQL**.
* Aplicación del patrón **MVC** en aplicaciones de escritorio.

## 👩‍💻 Autor

Proyecto desarrollado por **[ValeryChumpitaz](https://github.com/ValeryChumpitaz)** 💻

```

---

👉 Te queda 100% **listo para copiar/pegar en tu README.md**.  
¿Quieres que además te prepare unos **badges extra** (ejemplo: “status: en desarrollo”, “license MIT”, etc.) para darle un toque más profesional?
```
