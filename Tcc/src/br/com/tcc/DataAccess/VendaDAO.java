/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Venda;

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

   
}
