/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Usuario;

/**
 *
 * @author Thaisa
 */
public class UsuarioDAO extends DAOGenerico<Usuario>{
    public UsuarioDAO(){
        super(Usuario.class);
    }
}
