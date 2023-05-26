package com.mycompany.jdbcej1.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAO {
    
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;

    public void crearConexion() {
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "root") ;                  
        } catch (Exception e){
            e.getMessage();
        }
    }
    
    public void crearDesconexion(){
        try{
            if(conexion != null)
                conexion.close();
            if(sentencia != null)
                sentencia.close();
            if(resultado != null)
                resultado.close();
        }catch (SQLException e){
            e.getMessage();
        }
    }
    
    
}
