/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Cliente;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Thaisa
 */
public class ClienteDAO extends DAOGenerico<Cliente>{
    public ClienteDAO(){
        super(Cliente.class);
    }
    
    
    
    public List<Cliente> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Cliente s";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
    
    }
    
    
    public List<Cliente> Buscar(Cliente obj) {
        // Corpo da consulta
        EntityTransaction transacao = manager.getTransaction();
        try {

            String consulta = "Select s from Cliente s";

            // A parte where da consulta
            String filtro = "";

            // Guarda a lista de parâmetros da query
            HashMap<String, Object> parametros = new HashMap<String, Object>();

            // Verifica campo por campo os valores que serão filtrados
            if (obj.getId() != null) {
                filtro = " s.id =:id";
                parametros.put("id", obj.getId());
            }

            if (obj.getNome() != null) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro = " s.nome =:nome";
                parametros.put("nome", obj.getNome());
            }


            if (obj.getCpf() != null) {
                if(filtro.length() > 0){
                    filtro = filtro + " and";
                }
                filtro = " s.cpf =:cpf";
                parametros.put("cpf", obj.getCpf());
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

    @Override
    public boolean Apagar(Cliente obj) {
       EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Update Cliente s set s.ativo = 0 WHERE s.id ="+obj.getId();
            
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
