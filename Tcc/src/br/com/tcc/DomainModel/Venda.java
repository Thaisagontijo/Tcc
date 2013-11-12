/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Thaisa
 */
@Entity
@Table(name="Vendas")
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Venda() {
        this.funcionario = new Funcionario();
        this.produtos = new LinkedList<>();
        this.cliente = new Cliente();
        this.formaDePagamento = new FormaDePagamento();
        this.servicos = new LinkedList<>();
        this.dataHora = new Date();
    }

   
    @ManyToOne
    private Funcionario funcionario;
    
    @ManyToMany
    private List<Produto> produtos;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private FormaDePagamento formaDePagamento;
    
    @ManyToMany
    private List<Servico> servicos;
    
    private String Observacao;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
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
    
    
    public void addProduto(Produto p){
        if(!produtos.contains(p)){
            produtos.add(p);
        }
    }
    
    public void removeProduto(Produto p){
        if(produtos.contains(p)){
            produtos.remove(p);
        }
    }
    /*
    public float valorTotalVenda(){
        float valor = 0;
        
        for(Produto p : produtos){
            valor+= p.getPrecoVenda();
        }
    }
    * */

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.funcionario);
        hash = 11 * hash + Objects.hashCode(this.produtos);
        hash = 11 * hash + Objects.hashCode(this.cliente);
        hash = 11 * hash + Objects.hashCode(this.formaDePagamento);
        hash = 11 * hash + Objects.hashCode(this.servicos);
        hash = 11 * hash + Objects.hashCode(this.Observacao);
        hash = 11 * hash + Objects.hashCode(this.dataHora);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.servicos, other.servicos)) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dataHora.toString();
    }
    
    
}
