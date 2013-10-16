/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DomainModel;

import br.com.tcc.DataAccess.CargoDAO;
import br.com.tcc.DataAccess.FormaDePagamentoDAO;

/**
 *
 * @author Modric
 */
public class Tcc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       FormaDePagamento f = new FormaDePagamento();
       Cargo cargo = new Cargo();
       f.setNome("Á vista");
       
       cargo.setDescricao("cargo teste");
       cargo.setNome("caixa");
       cargo.setValorSalario(200);
       
        FormaDePagamentoDAO dao = new FormaDePagamentoDAO();
        
        CargoDAO daoc = new CargoDAO();
        
        daoc.Salvar(cargo);
        dao.Salvar(f);
                
    }
}
