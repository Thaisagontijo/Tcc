/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Retirada;

/**
 *
 * @author Ana Luiza
 */
public class RetiradaDAO extends DAOGenerico<Retirada>{
    public RetiradaDAO(){
        super(Retirada.class);
    }

    @Override
    public boolean Apagar(Retirada obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
