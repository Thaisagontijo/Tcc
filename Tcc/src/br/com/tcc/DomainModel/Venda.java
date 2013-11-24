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
import javax.persistence.CascadeType;
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
@Table(name="Vendas")
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Caixa caixa;

    public Venda() {
        this.funcionario = null;
        this.produtos = new LinkedList<>();
        this.cliente = null;
        this.formaDePagamento = null;
        this.servicos = new LinkedList<>();
        this.dataHora = new Date();
        this.caixa = new Caixa();
    }

   
    @ManyToOne
    private Funcionario funcionario;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "Venda",targetEntity = ItemVendaProduto.class)
    private List<ItemVendaProduto> produtos;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private FormaDePagamento formaDePagamento;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "Venda",targetEntity = ItemVendaServico.class)
    private List<ItemVendaServico> servicos;
    
    private String Observacao;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHora;
    
    
    private float valorVenda;

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    
    

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

    public List<ItemVendaProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ItemVendaProduto> produtos) {
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

    public List<ItemVendaServico> getServicos() {
        return servicos;
    }

    public void setServicos(List<ItemVendaServico> servicos) {
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
    public void addServico(ItemVendaServico s){
        if(!servicos.contains(s)){
            servicos.add(s);
        }
    }
    
    public void removeServico(ItemVendaServico s){
        if(servicos.contains(s)){
            servicos.remove(s);
        }
    }
    
    
    public void addProduto(ItemVendaProduto p){
        if(!produtos.contains(p)){
            produtos.add(p);
        }
    }
    
    public void removeProduto(ItemVendaProduto p){
        if(produtos.contains(p)){
            produtos.remove(p);
        }
    }

    public float calculaValorTotal(){
        float valorTotal = 0;
        for(ItemVendaServico s : servicos){
            valorTotal+= s.getValor();
            
        }
        
        for(ItemVendaProduto p : produtos){
            valorTotal+= (p.getQtd() * p.getProduto().getPrecoVenda());
        }
    
        return valorTotal;
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
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.funcionario);
        hash = 37 * hash + Objects.hashCode(this.Observacao);
        hash = 37 * hash + Objects.hashCode(this.dataHora);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.Observacao, other.Observacao)) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
            return false;
        }
        return true;
    }

  

        public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

  

    @Override
    public String toString() {
        return "eoo";
    }

   
    
}
