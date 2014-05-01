/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import model.Editorial;
import model.Libro;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author diegovelilla
 */
public class AppModelBiblio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // clase de prueba
    Session session = HibernateUtil.getSessionFactory().openSession();
    
     session.beginTransaction();
     
     Editorial editorial = new Editorial();
     editorial.setCodEditorial("1");
     editorial.setNombreEditorial("Santillana");
     session.save(editorial);
    
    Libro libro = new Libro();
    libro.setCodLibro("1");
    libro.setNombreLibro("Ingenieria Software II");
    libro.setAnhoPublicacion("1991");
    libro.setCantidad(20);
    libro.setAutor("Juan Perez");
    libro.setCodEditorial("1");
    session.save(libro);  
     
     session.getTransaction().commit();
     
    
    }
    
    
    
}
