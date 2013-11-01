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

            String consulta = "Select s from Agendamento s";

            // A parte where da consulta
            String filtro = "";

            // Guarda a lista de parâmetros da query
            HashMap<String, Object> parametros = new HashMap<String, Object>();

            // Verifica campo por campo os valores que serão filtrados
            if (obj.getId() != null) {
                filtro = " s.id =:id";
                parametros.put("id", obj.getId());
            }
/*
            if (obj.getNome() != null) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro = " s.nome =:nome";
                parametros.put("nome", obj.getNome());
            }

  */          
            if (obj.isRealizado()) {
                if(filtro.length() > 0){
                    filtro = filtro + " and";
                }
                filtro = " s.realizado =:realizado";
                parametros.put("realizado", obj.isRealizado());
            }

            // Se houver filtros, coloca o "where" na consulta
            if (filtro.length() > 0) {
                consulta = consulta + " where " + filtro;
            }

            transacao.begin();
            // Cria a consulta no JPA
            Query query = manager.createQuery(consulta);

            // Aplica os parâmetros da consulta
            for (String par : parametros.keySet()) {
                query.setParameter(par, parametros.get(par));
            }

            // Executa a consulta
            transacao.commit();
            return query.getResultList();
        } catch (Exception ex) {

            ex.printStackTrace();
            transacao.rollback();

            return null;
        }
    }
}

    
