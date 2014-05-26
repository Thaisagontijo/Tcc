/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Caixa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

/**
 *
 * @author Anderson
 */
public class CaixaDAO2 {
 
    private final ConexaoBanco conexao;
    
    public CaixaDAO2(){
    
        conexao = new ConexaoBanco();
    }
    
    
    
    public Long Salvar(Caixa obj){
        try{
            
            PreparedStatement comando = conexao.getConexao().prepareStatement("INSERT INTO caixas(dataabertura,datafechamento,funcionario_id)"
                    + "VALUES(?,?,?) ");
            
            java.sql.Date dataAberturao = new java.sql.Date(obj.getDataAbertura().getTime());
            //comando.setDate(1,dataAberturao);
            Timestamp agora = new Timestamp(System.currentTimeMillis());  
            Timestamp agora1 = new Timestamp(System.currentTimeMillis());  
            
            agora1.setTime(dataAberturao.getTime());
            comando.setTimestamp(1, agora1);
                    
            
            if(obj.getDataFechamento() != null){
                java.sql.Date dataFechamento = new java.sql.Date(obj.getDataFechamento().getTime());
                agora.setTime(dataFechamento.getTime()); //teste
                comando.setTimestamp(2,agora);
            }else{
                comando.setDate(2,null);
            }
            
            comando.setLong(3, obj.getFuncionario().getId());
            
            comando.execute();
            return idUltimoCaixa();
            
           
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    }
    
    
    public void atualizarHoraFechamentoCaixa(Caixa obj){
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("UPDATE caixas SET datafechamento = ? WHERE id=?");
            
            java.sql.Date dataFechamento = new java.sql.Date(obj.getDataFechamento().getTime());
            //comando.setDate(1,dataAberturao);
            Timestamp agora = new Timestamp(System.currentTimeMillis());  
           
            
            agora.setTime(dataFechamento.getTime());
            comando.setTimestamp(1, agora);
            comando.setLong(2, obj.getId());
            
            comando.execute();
            
            //conexao.
//            comando.getConnection().commit();
            conexao.fechar();//verificar
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public Long idUltimoCaixa(){
        Long v = Long.parseLong("0");
        try{
             PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT MAX(ID) from caixas");
             ResultSet resultado = comando.executeQuery();
            
             if(resultado.first()){
                 v = resultado.getLong("MAX(ID)");
             }
             return v;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    }
}
