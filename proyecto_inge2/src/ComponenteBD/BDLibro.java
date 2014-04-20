
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
        } else {/*
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
 */*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteBD;

/**
 *
 * @author Grupo1
 */

import Base_Datos.Conexion_BD;
import Componentes.Editorial;
import Componentes.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public abstract class BDLibro {
    
    //método que recibe objeto categoria y lo inserta en la base de datos
    public static boolean insertar(Libro libro) throws SQLException{
        boolean insertar=true;
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_insertar = null;
        sentencia_insertar = conexion.prepareStatement("insert into libro (cod_libro, nombre_libro, autor, anho_publicacion, cantidad, cod_editorial) VALUES (?,?,?,?,?,?)");
        sentencia_insertar.setString(1, libro.getCod_libro());
        sentencia_insertar.setString(2, libro.getNombre_libro());
        sentencia_insertar.setString(3, libro.getAutor());
        sentencia_insertar.setString(4, libro.getAnho_publicacion());
        sentencia_insertar.setInt(5, libro.getCantidad());
        sentencia_insertar.setString(6, libro.getCod_editorial().getCod_Editorial());
        
        try {
            sentencia_insertar.executeUpdate();
        } catch (SQLException ex) {
            insertar=false;
        }
        conexion.close();
        sentencia_insertar.close();
        return insertar;
    }
    
    //metodo que recibe le identificador del libro a ser eliminado
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
     
    //método que recibe objeto libro y actualiza datos en base de datos
     public static boolean actualizar(Libro libro) throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_actualizar = null;

        sentencia_actualizar = conexion.prepareStatement("update libro set nombre_libro=?, autor=?, anho_publicacion=?, cantidad=?, cod_editorial=? where cod_libro=" + libro.getCod_libro());
        sentencia_actualizar.setString(1, libro.getNombre_libro());
        sentencia_actualizar.setString(2, libro.getAutor());
        sentencia_actualizar.setString(3, libro.getAnho_publicacion());
        sentencia_actualizar.setInt(4, libro.getCantidad());
        sentencia_actualizar.setString(5, libro.getCod_editorial().getCod_Editorial());
        
        int rowsUpdated = sentencia_actualizar.executeUpdate();
        conexion.close();
        sentencia_actualizar.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    //método que busca libros por identificador
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
            libro.setAutor(resultado.getString("autor"));
            libro.setAnho_publicacion(resultado.getString("anho_publicacion"));
            libro.setCantidad(resultado.getInt("cantidad"));
            libro.setCod_editorial(BDEditorial.buscarId(resultado.getString("cod_editorial")));
        }
        conexion.close();
        sentencia_buscar.close();
        return libro;
    }
    
    //método que busca libros por nombre
    public static Libro buscarNom(String nombre) throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_buscar = null;
        Libro libro = null;
        sentencia_buscar = conexion.prepareStatement("select * from libro where nombre_libro=?");
        sentencia_buscar.setString(1, nombre);
        ResultSet resultado = sentencia_buscar.executeQuery();
        if (resultado.next()) {
            libro = new Libro() {
            };
            libro.setCod_libro(resultado.getString("cod_libro"));
            libro.setNombre_libro(nombre);
            libro.setAutor(resultado.getString("autor"));
            libro.setAnho_publicacion(resultado.getString("anho_publicacion"));
            libro.setCantidad(resultado.getInt("cantidad"));
            libro.setCod_editorial(BDEditorial.buscarId(resultado.getString("cod_editorial")));
        }
        conexion.close();
        sentencia_buscar.close();
        return libro;
    }
    
    public static Libro buscarAutor(String autor) throws SQLException {
        Connection conexion = Conexion_BD.getConnection();
        PreparedStatement sentencia_buscar = null;
        Libro libro = null;
        sentencia_buscar = conexion.prepareStatement("select * from libro where autor=?");
        sentencia_buscar.setString(1, autor);
        ResultSet resultado = sentencia_buscar.executeQuery();
        if (resultado.next()) {
            libro = new Libro() {
            };
            libro.setCod_libro(resultado.getString("cod_libro"));
            libro.setNombre_libro(resultado.getString("nombre"));
            libro.setAutor(autor);
            libro.setAnho_publicacion(resultado.getString("anho_publicacion"));
            libro.setCantidad(resultado.getInt("cantidad"));
            libro.setCod_editorial(BDEditorial.buscarId(resultado.getString("cod_editorial")));
        }
        conexion.close();
        sentencia_buscar.close();
        return libro;
    }
   
    
    //método que devuelve una lista de todos los libros 
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
            libro.setAutor(resultado.getString("autor"));
            libro.setAnho_publicacion(resultado.getString("anho_publicacion"));
            libro.setCantidad(resultado.getInt("cantidad"));
            libro.setCod_editorial(BDEditorial.buscarId(resultado.getString("cod_editorial")));
            lista.add(libro);
        }
        conexion.close();
        sentencia_mostrar.close();
        return lista;
    }
}
