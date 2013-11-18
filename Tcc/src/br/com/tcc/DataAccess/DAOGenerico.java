/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Thaisa
 */
public abstract class DAOGenerico<T> {
    
    
    protected EntityManager manager;
    private EntityManagerFactory factory;
    private Class tipo;
    
    public DAOGenerico (Class t) {
        factory = Persistence.createEntityManagerFactory("TccPU");
        manager = factory.createEntityManager();
        tipo = t;
        
    }
    
  
    public boolean Salvar(T obj) {
         EntityTransaction transacao = manager.getTransaction();
        try{
            //salva o objeto
            transacao.begin();
            manager.merge(obj);
            transacao.commit();
        //    manager.flush();
            return true;
        }catch (Exception ex){
      //  System.out.println(ex.getMessage());
            ex.printStackTrace();
            
        return false;
        }
    }
    
          
    

    public T Abrir(Long id) {
         EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            T obj = (T) manager.find(tipo, id);
            transacao.commit();
            return obj;
            //abrir
        } catch (Exception ex) {
            transacao.rollback();
            ex.printStackTrace();
            return null;
        }
    }
    
    public abstract boolean Apagar(T obj);
/*
    public boolean Apagar(T obj) {
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            manager.remove(manager.merge(obj));
            transacao.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transacao.rollback();
            return false;
        }
    }
  */  

}