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
public class Servicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private int duracaoAproximada; // em minutos
    private int descontoMaximo; // em porcentagem
    private String descicao;
    private float valor;

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

    public int getDescontoMaximo() {
        return descontoMaximo;
    }

    public void setDescontoMaximo(int descontoMaximo) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + this.duracaoAproximada;
        hash = 79 * hash + this.descontoMaximo;
        hash = 79 * hash + Objects.hashCode(this.descicao);
        hash = 79 * hash + Float.floatToIntBits(this.valor);
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
        final Servicos other = (Servicos) obj;
        if (!Objects.equals(this.nome, other.nome)) {
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
