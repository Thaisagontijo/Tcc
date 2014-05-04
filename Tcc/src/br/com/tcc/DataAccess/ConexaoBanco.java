/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.DataAccess;

/**
 *
 * @author Thaisa
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoBanco {
    private Connection conexao;
    
    public ConexaoBanco(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager
            //.getConnection("jdbc:mysql://localhost:3306/trabalhoFinal","root","");
            .getConnection("jdbc:mysql://localhost:3306/beautysystem","root","");
            //.getConnection("jdbc:mysql://localhost:3306/trabalhoFinal","root","170737");
            //conexao.setAutoCommit(false);
        
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        
      }

    public Connection getConexao() {
        try {
            if(conexao.isClosed()){
                conectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void conectar(){
        try {
            conexao = DriverManager
                  .getConnection("jdbc:mysql://localhost:3306/beautysystem","root","");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fechar(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}