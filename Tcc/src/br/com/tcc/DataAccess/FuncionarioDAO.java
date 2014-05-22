/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Funcionario;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Thaisa
 */
public class FuncionarioDAO extends DAOGenerico<Funcionario> {
    
    public FuncionarioDAO(){
        super(Funcionario.class );
    }
    
    
    
    
    
    public List<Funcionario> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Funcionario s where s.ativo = 1";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
    
    }
    
     public List<Funcionario> Buscar(Funcionario obj) {
        // Corpo da consulta
         EntityTransaction transacao = manager.getTransaction();
         try{
                
               String consulta = "";
            if (obj.getId() != null) {
                 consulta = "Select s from Funcionario s Where s.ativo = 1 and s.id like '%" + obj.getId() + "%'";
                 
             }else if(obj.getNome() != null){
                 consulta = "Select s from Funcionario s Where s.ativo = 1 and s.nome like '%" + obj.getNome() + "%'";
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
     
     
     
    public boolean VefificarExiste(Funcionario obj) {
        // Corpo da consulta
        ///faillll
        /*
        EntityTransaction transacao = manager.getTransaction();
        try {

            String consulta = "";
          //  if (obj.getId() != null) {
                consulta = "Select s from Funcionario s Where s.ativo = 1 and s.cpf like '%" + obj.getCpf() + "%' "
                        + "or s.rg like '%" + obj.getRg() + "%'";

            //} else {
                //return true;//se novo objeto
            //}
            transacao.begin();
            // Cria a consulta no JPA
            Query query = manager.createQuery(consulta);
            transacao.commit();
            
            
            Funcionario tmp = (Funcionario) query.getResultList().get(0);
            
            if (tmp.getId() == obj.getId()) {
                return true;
            } else {
                if (query.getResultList().isEmpty()) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            transacao.rollback();

            return false;
        }
                */
        return true;
    }

    @Override
    public boolean Apagar(Funcionario obj) {
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Update Funcionario s set s.ativo = 0 WHERE s.id ="+obj.getId();
            
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
