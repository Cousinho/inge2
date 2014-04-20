/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteBD;

import Base_Datos.Conexion_BD;
import Componentes.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author diegovelilla
 */
public abstract class BDLibro {
    
    
    public static boolean insertar(Libro libro) throws SQLException{
        boolean insertar=true;
        
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_insetar = null;
        sentencia_insetar = conexion.prepareStatement("insert into libro (cod_libro, nombre_libro, autor, anho_publicacion, cantidad, cod_editorial) VALUES (?,?,?,?,?,?)");
        sentencia_insetar.setString(1, libro.getCod_libro());
        sentencia_insetar.setString(2, libro.getNombre_libro());
        sentencia_insetar.setString(3, libro.getAutor());
        sentencia_insetar.setString(4, libro.getAnho_publicacion());
        sentencia_insetar.setInt(5, libro.getCantidad());
        
        
        try {
            sentencia_insetar.executeUpdate();
        } catch (SQLException ex) {
            insertar=false;
        }
        conexion.close();
        sentencia_insetar.close();
        return insertar;
    }
    
    public static boolean eliminar(String cod_libro) throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_eliminar = null;
        sentencia_eliminar = conexion.prepareStatement("delete from libro where cod_libro=?");
        sentencia_eliminar.setString(1, cod_libro);
        int rowsUpdated = sentencia_eliminar.executeUpdate();
        conexion.close();
        sentencia_eliminar.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
     
    
     public static boolean actualizar(Libro libro) throws SQLException {
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
    public static Libro buscarId(String cod_libro) throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_buscar = null;
        Libro libro = null;
        sentencia_buscar = conexion.prepareStatement("select * from libro where cod_libro=?");
        sentencia_buscar.setString(1, cod_libro);
        ResultSet resultado = sentencia_buscar.executeQuery();
        if (resultado.next()) {
            libro = new Libro() {
            };
            libro.setCod_libro(cod_libro);
            libro.setNombre_libro(resultado.getString("nombre_libro"));
        }
        conexion.close();
        sentencia_buscar.close();
        return libro;
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

   
    
    public static ArrayList<Libro> Lista() throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_mostrar = null;
        ArrayList<Libro> lista = new ArrayList<Libro>();

        sentencia_mostrar = conexion.prepareStatement("select * from libro");
        ResultSet resultado = sentencia_mostrar.executeQuery();
        while (resultado.next()) {
            Libro libro = new Libro() {
            };
            libro.setCod_libro(resultado.getString("cod_libro"));
            libro.setNombre_libro(resultado.getString("nombre_libro"));
            lista.add(libro);
        }
        conexion.close();
        sentencia_mostrar.close();
        return lista;
    }
}

