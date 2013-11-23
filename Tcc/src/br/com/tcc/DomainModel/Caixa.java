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
import javax.persistence.FetchType;
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
@Table(name="Caixas")
public class Caixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Caixa() {
        this.vendas = new LinkedList<>();
        this.dataAbertura = new Date();
        this.dataFechamento = new Date();
        this.funcionario = new Funcionario();
        this.depositos = new LinkedList<>();
        this.retiradas = new LinkedList<>();
    }
    
    

     //@OneToMany(cascade= CascadeType.ALL, mappedBy="venda",targetEntity=ItemVenda.class)
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "caixa",targetEntity = Venda.class)
    private List<Venda> vendas;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAbertura;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataFechamento;
    
    @ManyToOne
    private Funcionario funcionario;
    
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "caixa",targetEntity = Deposito.class)
    private List<Deposito> depositos;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "caixa",targetEntity = Retirada.class)
    private List<Retirada> retiradas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Deposito> getDepositos() {
        return depositos;
    }

    public void setDepositos(List<Deposito> depositos) {
        this.depositos = depositos;
    }

    public List<Retirada> getRetiradas() {
        return retiradas;
    }

    public void setRetiradas(List<Retirada> retiradas) {
        this.retiradas = retiradas;
    }
    
    public void addVenda(Venda v){
        if(!vendas.contains(v)){
            vendas.add(v);
        }
    }
    
    public void removeVenda(Venda v){
        if(vendas.contains(v)){
            vendas.remove(v);
        }
    }
    
    public void addDeposito(Deposito d){
        if(!depositos.contains(d)){
            depositos.add(d);
        }
    }
    public void removeDeposito(Deposito d){
        if(depositos.contains(d)){
            depositos.remove(d);
        }
    }
    
    public void addRetirada(Retirada r){
        if(!retiradas.contains(r)){
            retiradas.add(r);
        }
    }
    
    public void removeRetirada(Retirada r){
        if(retiradas.contains(r)){
            retiradas.remove(r);
        }
    }
    
    public float calcularTotalCaixa(){
        float valor = 0;
        
        //Calculando valor dos depositos
        for(Deposito d :depositos){
           valor +=  d.getValor();
        }
        
        for(Retirada r :retiradas){
            valor -= r.getValor();
        }
        
        //calculando valor das vendas
       
        for(Venda v : vendas){
            for(Produto p: v.getProdutos()){
                valor+= p.getPrecoVenda() * p.getQtdVenda();
                
            }
            
            for(Servico s: v.getServicos()){
                valor+=s.getValor();
            }
        }
       
        return valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.vendas);
        hash = 89 * hash + Objects.hashCode(this.dataAbertura);
        hash = 89 * hash + Objects.hashCode(this.dataFechamento);
        hash = 89 * hash + Objects.hashCode(this.funcionario);
        hash = 89 * hash + Objects.hashCode(this.depositos);
        hash = 89 * hash + Objects.hashCode(this.retiradas);
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
        final Caixa other = (Caixa) obj;
        if (!Objects.equals(this.vendas, other.vendas)) {
            return false;
        }
        if (!Objects.equals(this.dataAbertura, other.dataAbertura)) {
            return false;
        }
        if (!Objects.equals(this.dataFechamento, other.dataFechamento)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.depositos, other.depositos)) {
            return false;
        }
        if (!Objects.equals(this.retiradas, other.retiradas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa{" + "id=" + id + ", vendas=" + vendas + ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento + ", funcionario=" + funcionario + ", depositos=" + depositos + ", retiradas=" + retiradas + '}';
    }

   
    
}
