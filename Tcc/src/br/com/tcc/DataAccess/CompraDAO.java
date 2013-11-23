/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Compra;

/**
 *
 * @author Home
 */
public class CompraDAO extends DAOGenerico<Compra>{
    
    public CompraDAO(){
        super(CompraDAO.class);
    }

    @Override
    public boolean Apagar(Compra obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
