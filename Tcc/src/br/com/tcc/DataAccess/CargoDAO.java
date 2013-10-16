/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Cargo;

/**
 *
 * @author Modric
 */
public class CargoDAO extends DAOGenerico<Cargo>{
    public CargoDAO(){
        super(Cargo.class);
    }
}
