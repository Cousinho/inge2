/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import model.Editorial;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author diegovelilla
 */
public class EditorialDao implements InterfaceEditorial {

    @Override
    public Editorial getEditorial(String codEditorial) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Editorial) session.load(Editorial.class, codEditorial);
               
    }

    @Override
    public void guardar(Editorial editorial) throws Exception{
        try {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       session.save(editorial);
       session.getTransaction().commit();
          } catch (Exception e){
            throw new Exception("Error no se pudo guardar la editorial " + e.getMessage()); 
          }
        }
    
    @Override
    public void eliminar (Editorial editorial) throws Exception {
       
      try {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       session.delete(editorial);
       session.getTransaction().commit();
          } catch (Exception e){
            throw new Exception("Error no se pudo eliminar la editorial " + e.getMessage()); 
          }
      }
     
 
    @Override
    public void actualizar(Editorial editorial) throws Exception {
        
      try {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       session.update(editorial);
       session.getTransaction().commit();
          } catch (Exception e){
            throw new Exception("Error no se pudo actualizar la editorial " + e.getMessage()); 
          } 
    }

    @Override
    public List<Editorial> list() {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List lista = session.createQuery("from Editorial").list();        
        return lista;
        
    }
    
}
