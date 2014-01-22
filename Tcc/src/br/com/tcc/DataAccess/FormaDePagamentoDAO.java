/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.FormaDePagamento;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Thaisa
 */
public class FormaDePagamentoDAO extends DAOGenerico<FormaDePagamento> {

    public FormaDePagamentoDAO(){
        super(FormaDePagamento.class);
    }
    
    
    
    
    public List<FormaDePagamento> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from FormaDePagamento s where s.ativo= 1";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
    
    }
    
     public List<FormaDePagamento> Buscar(FormaDePagamento obj) {
        // Corpo da consulta
          EntityTransaction transacao = manager.getTransaction();
         try {

             String consulta = "";
             
             if (obj.getId() != null) {
                 consulta = "Select s from FormaDePagamento s Where s.ativo = 1 and s.id like '%" + obj.getId() + "%'";
                 
             }else if(obj.getNome() != null){
                 consulta = "Select s from FormaDePagamento s Where s.ativo = 1 and s.nome like '%" + obj.getNome() + "%'";
             }

             
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
    public boolean Apagar(FormaDePagamento obj) {
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Update FormaDePagamento s set s.ativo = 0 WHERE s.id ="+obj.getId();
            
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
