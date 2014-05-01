/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import model.Libro;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author diegovelilla
 */
public class LibroDao implements InterfaceLibro {

    @Override
    public Libro getLibro(String codLibro) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Libro) session.load(Libro.class, codLibro);
               
    }

    @Override
    public void guardar(Libro libro) throws Exception{
        try {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       session.save(libro);
       session.getTransaction().commit();
          } catch (Exception e){
            throw new Exception("Error no se pudo guardar el libro " + e.getMessage()); 
          }
        }
    
    @Override
    public void eliminar (Libro libro) throws Exception {
       
      try {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       session.delete(libro);
       session.getTransaction().commit();
          } catch (Exception e){
            throw new Exception("Error no se pudo eliminar el libro " + e.getMessage()); 
          }
      }
     
     @Override
    public void actualizar(Libro libro) throws Exception {
        
      try {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       session.update(libro);
       session.getTransaction().commit();
          } catch (Exception e){
            throw new Exception("Error no se pudo actualizar el libro " + e.getMessage()); 
          } 
    }

    @Override
    public List<Libro> list() {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List lista = session.createQuery("from Libro").list();        
        return lista;
        
    }
    
}
