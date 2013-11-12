/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.TipoProduto;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Thaisa
 */
public class TipoProdutoDAO extends DAOGenerico<TipoProduto>{
    
    public TipoProdutoDAO(){
        super(TipoProduto.class);
    }
    
    
    
    
    public List<TipoProduto> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from TipoProduto s Where s.ativo = 1";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
    
    }
    
     public List<TipoProduto> Buscar(TipoProduto obj) {
        // Corpo da consulta
         EntityTransaction transacao = manager.getTransaction();
         try{
                
               String consulta = "";
             if (obj.getId() != null) {
                 consulta = "Select s from TipoProduto s Where s.ativo = 1 and s.id like '%" + obj.getId() + "%'";
                 
             }else if(obj.getNome() != null){
                 consulta = "Select s from TipoProduto s Where s.ativo = 1 and s.nome like '%" + obj.getNome() + "%'";
             }
               transacao.begin();
               // Cria a consulta no JPA
               Query query = manager.createQuery(consulta);

               
               transacao.commit();
               return query.getResultList();
         }catch(Exception ex){
           
             ex.printStackTrace();
             transacao.rollback();
             
             return null;
         }
    }

    @Override
    public boolean Apagar(TipoProduto obj) {
      EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Update TipoProduto s set s.ativo = 0 WHERE s.id ="+obj.getId();
            
             Query query = manager.createQuery(consulta);
             query.executeUpdate();
             
             transacao.commit();
             return true;
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return false;
        }
    }
    
}
