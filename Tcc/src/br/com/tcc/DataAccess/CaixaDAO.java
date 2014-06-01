/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Caixa;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Thaisa
 */
public class CaixaDAO extends DAOGenerico<Caixa>{
    public CaixaDAO(){
        super(Caixa.class);
    }

    @Override
    public boolean Apagar(Caixa obj) {
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Update Caixa s set s.ativo = 0 WHERE s.id ="+obj.getId();
            
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
    
     public List<Caixa> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
           
            transacao.begin();
           //  manager.flush();
            String consulta = "Select s from Caixa s";
            
                        
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
    
    }
     
     public List<Caixa> ListarCaixasEntreDatas(Date inicio, Date fim){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Caixa s where s.dataAbertura between :inicio and :fim";
            
            
             Query query = manager.createQuery(consulta);
             
             query.setParameter("inicio", inicio);       
             query.setParameter("fim", fim);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
      }
}
