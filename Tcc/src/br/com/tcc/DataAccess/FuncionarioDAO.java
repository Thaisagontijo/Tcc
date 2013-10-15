/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DataAccess;

import br.com.tcc.DomainModel.Funcionario;

/**
 *
 * @author Thaisa
 */
public class FuncionarioDAO extends DAOGenerico<Funcionario> {
    
    public FuncionarioDAO(){
        super(Funcionario.class );
    }
}
