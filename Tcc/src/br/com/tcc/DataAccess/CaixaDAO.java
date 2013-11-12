/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Caixa;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
