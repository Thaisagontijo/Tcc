/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Compra;
import br.com.tcc.DomainModel.Venda;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Ana Luiza
 */
public class VendaDAO extends DAOGenerico<Venda>{
    public VendaDAO(){
        super(Venda.class);
    }

    @Override
    public boolean Apagar(Venda obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     public List<Venda> ListarTodos(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Venda s";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
        
   }
     
      public List<Venda> ListarVendasAPrazo(){
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            String consulta = "Select s from Venda s where s.status = 0";
            
             Query query = manager.createQuery(consulta);
             
             transacao.commit();
             return query.getResultList();
        
            
        }catch(Exception ex){
           ex.printStackTrace();
           transacao.rollback();
            return null;
        }
      }
     
      public List<Compra> Buscar(Compra obj) {
        // Corpo da consulta
          EntityTransaction transacao = manager.getTransaction();
         try {
/*
             String consulta = "";
             
             if (obj.getId() != null) {
                 consulta = "Select s from Compra s Where s.id like '%" + obj.getId() + "%'";
                 
             }else if(obj.getProduto().getNome() != null){
                 consulta = "Select s from Compra s Where s.produto like '%" + obj.getProduto() + "%'";
             
             }else if(obj.getProduto().getId() != null){
                 consulta = "Select s from Compra s Where s.produto like '%" + obj.getProduto().getId() + "%'";
             }
             //else if(obj.getDataCompra()!= null){
             //consulta = "Select s from Compra s Where s.datacompra like '%" + obj.getDataCompra()+ "%'";
             //}

             
             transacao.begin();
           
             Query query = query = manager.createQuery(consulta);
             // Executa a consulta
             transacao.commit();
             return query.getResultList();
        */  // Corpo da consulta
        String consulta = "select f from Compra f ";

        // A parte where da consulta
        String filtro = " ";


        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Nome
            if (obj.getProduto().getId() != null ) {
                filtro += "f.produto = '"+obj.getProduto().getId()+"'";
              
            }
            //Id
            //if (obj.getId() != null && obj.getId() > 0) {
                
//                filtro += " AND f.id like '%"+obj.getId()+"%'";
                
  //          }
            //Cpf
    //        if (obj.getCpf() != null && obj.getCpf().length() > 0) {
                
      //          filtro += " AND f.cpf like '%"+obj.getCpf()+"%'";
                
        //    }

            // Se houver filtros, coloca o "where" na consulta
            if (filtro.length() > 0) {
                
                consulta += "WHERE" + filtro;
            }
        }

        // Cria a consulta no JPA
        Query query = manager.createQuery(consulta);

        // Executa a consulta
        return query.getResultList();
         } catch (Exception ex) {

             ex.printStackTrace();
             transacao.rollback();
             return null;
         }
    }

   
}
