/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Fornecedor;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Thaisa
 */
public class FornecedorDAO extends DAOGenerico<Fornecedor>{
    
    public FornecedorDAO(){
        super(Fornecedor.class);
    }
    
    
    public List<Fornecedor> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Fornecedor s where s.ativo = 1";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
    
    }
    
     public List<Fornecedor> Buscar(Fornecedor obj) {
        // Corpo da consulta
         EntityTransaction transacao = manager.getTransaction();
         try{
                
               String consulta = "";
             if (obj.getId() != null) {
                 consulta = "Select s from Fornecedor s Where s.ativo = 1 and s.id like '%" + obj.getId() + "%'";
                 
             }else if(obj.getNome() != null){
                 consulta = "Select s from Fornecedor s Where s.ativo = 1 and s.nome like '%" + obj.getNome() + "%'";
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
    public boolean Apagar(Fornecedor obj) {
       EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Update Fornecedor s set s.ativo = 0 WHERE s.id ="+obj.getId();
            
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
