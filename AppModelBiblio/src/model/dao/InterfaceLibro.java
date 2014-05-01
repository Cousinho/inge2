/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;
import model.Libro;
import java.util.List;
/**
 *
 * @author diegovelilla
 */
public interface InterfaceLibro {
    
    public Libro getLibro(String codLibro);
    public void guardar(Libro libro) throws Exception;
    public void eliminar (Libro libro) throws Exception;
    public void actualizar (Libro libro) throws Exception;
    public List <Libro> list();
    
    
}
