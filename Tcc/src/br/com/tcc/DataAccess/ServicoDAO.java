/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Servico;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Thaisa
 */
public class ServicoDAO extends DAOGenerico<Servico>{
    public ServicoDAO(){
        super(Servico.class);
   
    }
    
    
    public List<Servico> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Servico s where s.ativo = 1";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
    
    }
    
     public List<Servico> Buscar(Servico obj) {
        // Corpo da consulta
         EntityTransaction transacao = manager.getTransaction();
         try{
                
               String consulta = "";

              if (obj.getId() != null) {
                 consulta = "Select s from Servico s Where s.ativo = 1 and s.id like '%" + obj.getId() + "%'";
                 
             }else if(obj.getNome() != null){
                 consulta = "Select s from Servico s Where s.ativo = 1 and s.nome like '%" + obj.getNome() + "%'";
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
    public boolean Apagar(Servico obj) {
     EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Update Servico s set s.ativo = 0 WHERE s.id ="+obj.getId();
            
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
