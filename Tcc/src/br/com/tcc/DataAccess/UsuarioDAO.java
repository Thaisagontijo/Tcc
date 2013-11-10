/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Usuario;
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
        Usuario tmp  = new Usuario();
        
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Usuario s WHERE s.nome like '"+ u.getNome()+"' AND s.senha like '"+u.getSenha()+"'";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             tmp =(Usuario) query.getSingleResult();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
        
        
        
        
        
        if(tmp == null){
            return null;
        }else{
            return tmp;
        }
    
    
    
    }
}
