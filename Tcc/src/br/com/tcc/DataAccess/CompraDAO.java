/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Compra;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Home
 */
public class CompraDAO extends DAOGenerico<Compra>{
    
    public CompraDAO(){
        super(CompraDAO.class);
    }
    
     public List<Compra> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select c from Compra c where c.id > 0";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
    
    }
     
      public List<Compra> Buscar(Compra obj) {
        // Corpo da consulta
          EntityTransaction transacao = manager.getTransaction();
         try {

             String consulta = "";
             
             if (obj.getId() != null) {
                 consulta = "Select s from Compra s Where s.id like '%" + obj.getId() + "%'";
                 
             }
             //else if(obj.getDataCompra()!= null){
             //consulta = "Select s from Compra s Where s.datacompra like '%" + obj.getDataCompra()+ "%'";
             //}

             
             transacao.begin();
           
             Query query = query = manager.createQuery(consulta);
             // Executa a consulta
             transacao.commit();
             return query.getResultList();
         } catch (Exception ex) {

             ex.printStackTrace();
             transacao.rollback();
             return null;
         }
    }

    @Override
    public boolean Apagar(Compra obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
