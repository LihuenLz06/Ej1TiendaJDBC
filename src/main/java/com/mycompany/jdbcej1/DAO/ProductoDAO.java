package com.mycompany.jdbcej1.DAO;

import com.mycompany.jdbcej1.Entidades.Producto;
import java.util.Scanner;


public class ProductoDAO extends DAO {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void listarProd() {
        try {
            crearConexion();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM producto");
            while (resultado.next()) {
                System.out.println(" | " + resultado.getInt("codigo") + " | " + resultado.getString("nombre") + " | " + resultado.getDouble("precio") + " | " + resultado.getInt("codigo_fabricante"));
            }
        } catch (Exception e) {
        } finally {
            crearDesconexion();
        }
    }

    public void listarNombreyPrecio() {
        try {
            crearConexion();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SELECT nombre,precio FROM producto");
            System.out.println("Nombres y precios");
            while (resultado.next()) {
                System.out.println(" | " + resultado.getString("nombre") + " | " + resultado.getDouble("precio"));
            }
        } catch (Exception e) {
        } finally {
            crearDesconexion();
        }
    }

    public void listarNombreRango() {
        try {
            crearConexion();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SELECT nombre,precio FROM producto WHERE precio BETWEEN 120 AND 202");
            System.out.println("Productos entre 120 y 202");
            while (resultado.next()) {
                System.out.println(" | " + resultado.getString("nombre") + " | " + resultado.getDouble("precio"));
            }
        } catch (Exception e) {
        } finally {
            crearDesconexion();
        }
    }

    public void listarPortatil() {
        try {
            crearConexion();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SELECT nombre FROM producto WHERE nombre LIKE 'portatil%'");
            System.out.println("Portátiles");
            while (resultado.next()) {
                System.out.println(" | " + resultado.getString("nombre"));
            }
        } catch (Exception e) {
        } finally {
            crearDesconexion();
        }
    }

    public void listarBarato() {
        try {
            crearConexion();
            sentencia = conexion.createStatement();
            System.out.println("Producto más barato");
            resultado = sentencia.executeQuery("SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1");
            while (resultado.next()) {
                System.out.println(" | " + resultado.getString("nombre") + " | " + resultado.getDouble("precio"));
            }
        } catch (Exception e) {
        } finally {
            crearDesconexion();
        }
    }

    public void listarBarato2() {
        try {
            crearConexion();
            sentencia = conexion.createStatement();
            System.out.println("Producto más barato");
            resultado = sentencia.executeQuery("SELECT nombre, precio FROM producto WHERE precio = (SELECT MIN(precio) FROM producto)");
            while (resultado.next()) {
                System.out.println(" | " + resultado.getString("nombre") + " | " + resultado.getDouble("precio"));
            }
        } catch (Exception e) {
        } finally {
            crearDesconexion();
        }
    }

    public void crearProducto() {
        try {
            Producto prod = new Producto();
            System.out.println("Ingrese el código del producto");
            prod.setCodigo(sc.nextInt());
            System.out.println("Ingrese el nombre del producto");
            prod.setNombre(sc.next());
            System.out.println("Ingrese el precio del producto");
            prod.setPrecio(sc.nextDouble());
            System.out.println("Ingrese el código del fabricante");
            prod.setCodigo_fabricante(sc.nextInt());
            crearConexion();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT INTO producto (codigo,nombre,precio,codigo_fabricante) VALUES (" + prod.getCodigo() + ",'" + prod.getNombre() + "'," + prod.getPrecio() + "," + prod.getCodigo_fabricante() + ")");
        } catch (Exception e) {
        } finally {
            crearDesconexion();
        }
    }

    public void editarProd() {
        try {
            
            System.out.println("Edición de producto: Selecciona un codigo a editar de la siguiente lista");
            listarProd();
            int opcion = sc.nextInt();
            System.out.println("Ingrese los nuevos datos de producto");
            Producto prod = new Producto();
            prod.setCodigo(opcion);
            System.out.println("Ingrese el nombre del producto");
            prod.setNombre(sc.next());
            System.out.println("Ingrese el precio del producto");
            prod.setPrecio(sc.nextDouble());
            System.out.println("Ingrese el código del fabricante");
            prod.setCodigo_fabricante(sc.nextInt());
            sentencia = conexion.createStatement();
             crearConexion();
            sentencia.executeUpdate("UPDATE producto SET nombre='" + prod.getNombre() + "',precio=" + prod.getPrecio() + ",codigo_fabricante="
                    + prod.getCodigo_fabricante() + " WHERE codigo =" + prod.getCodigo());

        } catch (Exception e) {
        } finally {
            crearDesconexion();
        }
    }
}


