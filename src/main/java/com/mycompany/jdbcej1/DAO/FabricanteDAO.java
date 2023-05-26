package com.mycompany.jdbcej1.DAO;

import com.mycompany.jdbcej1.Entidades.Fabricante;
import java.util.Scanner;

public class FabricanteDAO extends DAO {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void listaFabricante() {
         try {
            crearConexion();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM fabricante");
            while(resultado.next()){
                System.out.println(" | " + resultado.getInt("codigo") + " | " + resultado.getString("nombre"));
            }      
        } catch (Exception e) {
        } finally{
            crearDesconexion();
        }
    }
    
    public void crearFabricante(){
        try {
        Fabricante fabricante = new Fabricante();
        System.out.println("Ingrese el nombre del fabricante");
        fabricante.setNombre(sc.next());
        System.out.println("Ingrese el coódigo del fabricante");
        fabricante.setCodigo(sc.nextInt());
        crearConexion();
        sentencia = conexion.createStatement();
        sentencia.executeUpdate("INSERT INTO fabricante (codigo,nombre) VALUES ("+fabricante.getCodigo() + ",'"+fabricante.getNombre() + "')");
        } catch (Exception e) {
        }
        finally{
            crearDesconexion();
        }
    }
}
            
        
    

