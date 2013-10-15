/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Thaisa
 */
@Entity
@Table(name="Agendamentos")
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne // verifcar
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;
    
    @OneToMany
    private List<Servico> servicos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataHora;
    private String Observacao;
    
    public void addServico(Servico s){
        if(!servicos.contains(s)){
            servicos.add(s);
        }
    }
    
    public void removeServico(Servico s){
        if(servicos.contains(s)){
            servicos.remove(s);
        }
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.cliente);
        hash = 31 * hash + Objects.hashCode(this.funcionario);
        hash = 31 * hash + Objects.hashCode(this.servicos);
        hash = 31 * hash + Objects.hashCode(this.dataHora);
        hash = 31 * hash + Objects.hashCode(this.Observacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.servicos, other.servicos)) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
            return false;
        }
        if (!Objects.equals(this.Observacao, other.Observacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Observacao;
    }
    
    
    
    
}
