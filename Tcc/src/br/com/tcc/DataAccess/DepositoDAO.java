/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Deposito;

/**
 *
 * @author Ana Luiza
 */
public class DepositoDAO extends DAOGenerico<Deposito>{

    public DepositoDAO() {
        super(Deposito.class);
    }

    
    
    @Override
    public boolean Apagar(Deposito obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
