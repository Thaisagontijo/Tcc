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
 * @author Modric
 */
public class ServicoDAO extends DAOGenerico<Servico>{
    public ServicoDAO(){
        super(Servico.class);
   
    }
    
    
    public List<Servico> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Servico s";
            
             Query query = manager.createQuery(consulta);
             
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
            return null;
        }
    
    }
    
}
