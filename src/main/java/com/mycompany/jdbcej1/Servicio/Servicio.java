package com.mycompany.jdbcej1.Servicio;

import com.mycompany.jdbcej1.DAO.FabricanteDAO;
import com.mycompany.jdbcej1.DAO.ProductoDAO;
import java.util.Scanner;


public class Servicio {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    int opcion;
    FabricanteDAO fDAO = new FabricanteDAO();
    ProductoDAO pDAO = new ProductoDAO();

    public void Menu() {
        do {
            System.out.println("============= MENÚ ====================");
            System.out.println("Ingrese la consulta que desea ejecutar");
            System.out.println("1. Lista el nombre de todos los productos que hay en la tabla producto ");
            System.out.println("2. Lista los nombres y los precios de todos los productos de la tabla producto ");
            System.out.println("3. Listar aquellos productos que su precio esté entre 120 y 202 ");
            System.out.println("4. Buscar y listar todos los Portátiles de la tabla producto ");
            System.out.println("5. Listar el nombre y el precio del producto más barato ");
            System.out.println("6. Ingresar un producto a la base de datos ");
            System.out.println("7. Ingresar un fabricante a la base de datos ");
            System.out.println("8. Editar un producto con datos a elección ");
            System.out.println("9. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    pDAO.listarProd();
                    break;
                case 2:
                    pDAO.listarNombreyPrecio();
                    break;
                case 3:
                    pDAO.listarNombreRango();
                    break;
                case 4:
                    pDAO.listarPortatil();
                    break;
                case 5:
                    pDAO.listarBarato();
                    break;
                case 6:
                    pDAO.crearProducto();
                    break;
                case 7:
                    fDAO.crearFabricante();
                    break;
                case 8:
                    pDAO.editarProd();
                    break;
                case 9:
                    System.out.println("Ha salido con éxito");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 9);
    }
}
