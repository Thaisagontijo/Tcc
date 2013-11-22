/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.DomainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Thaisa
 */
@Entity
@Table(name="Servicos")
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Servico(){
        this.ativo = true;
    }
    private String nome;
    private int duracaoAproximada; // em minutos
    private float descontoMaximo; // em porcentagem
    private String descicao;
    private float valor;
    private float comissao;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoAproximada() {
        return duracaoAproximada;
    }

    public void setDuracaoAproximada(int duracaoAproximada) {
        this.duracaoAproximada = duracaoAproximada;
    }

    public float getDescontoMaximo() {
        return descontoMaximo;
    }

    public void setDescontoMaximo(float descontoMaximo) {
        this.descontoMaximo = descontoMaximo;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.nome);
        hash = 31 * hash + this.duracaoAproximada;
        hash = 31 * hash + Float.floatToIntBits(this.descontoMaximo);
        hash = 31 * hash + Float.floatToIntBits(this.valor);
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.duracaoAproximada != other.duracaoAproximada) {
            return false;
        }
        if (Float.floatToIntBits(this.descontoMaximo) != Float.floatToIntBits(other.descontoMaximo)) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        return true;
    }

    
  
    

 

    @Override
    public String toString() {
        return  nome;
    }
    
}
