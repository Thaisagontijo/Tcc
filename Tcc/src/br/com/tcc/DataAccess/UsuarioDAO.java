/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Usuario;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Thaisa
 */

public class UsuarioDAO extends DAOGenerico<Usuario>{
    public UsuarioDAO(){
        super(Usuario.class);
    }
    
    
    public Usuario Autenticar(Usuario u){
        Usuario tmp ;// = new Usuario();
        
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Usuario s WHERE s.nome like '"+ u.getNome()+"' AND s.senha like '"+u.getSenha()+"'"
                    + " AND s.ativo = 1";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             tmp =(Usuario) query.getSingleResult();
        
            
        }catch(Exception ex ){//coloacr 2 cath
           
            //ex.printStackTrace();
            
           //transacao.rollback();
           return null;
            
        }
        
        if(tmp == null){
            return null;
        }else{
            return tmp;
        }
    
    
    
    }

    @Override
    public boolean Apagar(Usuario obj) {
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Update Usuario s set s.ativo = 0 WHERE s.id ="+obj.getId();
            
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

       public List<Usuario> Buscar(Usuario obj) {
        // Corpo da consulta
         EntityTransaction transacao = manager.getTransaction();
         try{
                
               String consulta = "";
            if (obj.getId() != null) {
                 consulta = "Select s from Usuario s Where s.ativo = 1 and s.id like '%" + obj.getId() + "%'";
                 
             }else if(obj.getNome() != null){
                 consulta = "Select s from Usuario s Where s.ativo = 1 and s.nome like '%" + obj.getNome() + "%'";
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
    
    
    
      public List<Usuario> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Usuario s where s.ativo =1";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
    
    }
}
