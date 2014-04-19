/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteBD;

/**
 *
 * @author Cousiño
 */

import Base_Datos.Conexion_BD;
import Componentes.Editorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public abstract class BDEditorial {
    
    //método que recibe objeto categoria y lo inserta en la base de datos
    public static boolean insertar(Editorial editorial) throws SQLException{
        boolean insertar=true;
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_insetar = null;
        sentencia_insetar = conexion.prepareStatement("insert into editorial (cod_editorial, nombre_editorial) VALUES (?,?)");
        sentencia_insetar.setString(1, editorial.getCod_Editorial());
        sentencia_insetar.setString(2, editorial.getNombre_Editorial());
        try {
            sentencia_insetar.executeUpdate();
        } catch (SQLException ex) {
            insertar=false;
        }
        conexion.close();
        sentencia_insetar.close();
        return insertar;
    }
    
    //metodo que recibe le identificador de la categoria a ser eliminado
    public static boolean eliminar(String cod_editorial) throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_eliminar = null;
        sentencia_eliminar = conexion.prepareStatement("delete from editorial where cod_editorial=?");
        sentencia_eliminar.setString(1, cod_editorial);
        int rowsUpdated = sentencia_eliminar.executeUpdate();
        conexion.close();
        sentencia_eliminar.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
     
    //método que recibe objeto categoria y actualiza datos en base de datos
     public static boolean actualizar(Editorial editorial) throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_actualizar = null;

        sentencia_actualizar = conexion.prepareStatement("update editorial set nombre_editorial=? where cod_editorial=" + editorial.getCod_Editorial());
        sentencia_actualizar.setString(1, editorial.getNombre_Editorial());
        int rowsUpdated = sentencia_actualizar.executeUpdate();
        conexion.close();
        sentencia_actualizar.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    //método que busca categoria por identificador
    public static Editorial buscarId(String cod_editorial) throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_buscar = null;
        Editorial editorial = null;
        sentencia_buscar = conexion.prepareStatement("select * from editorial where cod_editorial=?");
        sentencia_buscar.setString(1, cod_editorial);
        ResultSet resultado = sentencia_buscar.executeQuery();
        if (resultado.next()) {
            editorial = new Editorial() {
            };
            editorial.setCod_Editorial(cod_editorial);
            editorial.setNombre(resultado.getString("nombre_editorial"));
        }
        conexion.close();
        sentencia_buscar.close();
        return editorial;
    }
    
    //método que busca categoria por nombre
    public static Editorial buscarNom(String nombre) throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_buscar = null;
        Editorial editorial = null;
        sentencia_buscar = conexion.prepareStatement("select * from editorial where nombre_editorial=?");
        sentencia_buscar.setString(1, nombre);
        ResultSet resultado = sentencia_buscar.executeQuery();
        if (resultado.next()) {
            editorial = new Editorial() {
            };
            editorial.setCod_Editorial(resultado.getString("cod_editorial"));
            editorial.setNombre(nombre);
        }
        conexion.close();
        sentencia_buscar.close();
        return editorial;
    }

   
    
    //método que devuelve una lista de todas las categorias 
    public static ArrayList<Editorial> Lista() throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_mostrar = null;
        ArrayList<Editorial> lista = new ArrayList<Editorial>();

        sentencia_mostrar = conexion.prepareStatement("select * from editorial");
        ResultSet resultado = sentencia_mostrar.executeQuery();
        while (resultado.next()) {
            Editorial editorial = new Editorial() {
            };
            editorial.setCod_Editorial(resultado.getString("cod_editorial"));
            editorial.setNombre(resultado.getString("nombre_editorial"));
            lista.add(editorial);
        }
        conexion.close();
        sentencia_mostrar.close();
        return lista;
    }
}

