/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Agendamento;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Thaisa
 */
public class AgendamentoDAO extends DAOGenerico<Agendamento>{
    public AgendamentoDAO(){
        super(Agendamento.class);
    }
    
      public List<Agendamento> Buscar(Agendamento obj) {
        // Corpo da consulta
        EntityTransaction transacao = manager.getTransaction();
        try {

            String consulta = "";
            if(obj == null){
                consulta = "Select s from Agendamento s where s.realizado = 0 and s.ativo = 1 order by s.dataHora asc"; 
            }else if (obj.isRealizado()){
                consulta = "Select s from Agendamento s where s.realizado = 1 and s.ativo = 1 order by s.dataHora asc"; 
            }

            // A parte where da consulta
        

            

            transacao.begin();
            // Cria a consulta no JPA
            Query query = manager.createQuery(consulta);

            // Aplica os parâmetros da consulta
            
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
    public boolean Apagar(Agendamento obj) {
       EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Update Agendamento s set s.ativo = 0 WHERE s.id ="+obj.getId();
            
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

    
