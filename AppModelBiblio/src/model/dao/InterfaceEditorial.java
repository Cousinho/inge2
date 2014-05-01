/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;
import model.Editorial;
import java.util.List;
/**
 *
 * @author diegovelilla
 */
public interface InterfaceEditorial {
    
    public Editorial getEditorial(String codEditorial);
    public void guardar(Editorial editorial) throws Exception;
    public void eliminar (Editorial editorial) throws Exception;
    public void actualizar (Editorial editorial) throws Exception;
    public List <Editorial> list();

}
