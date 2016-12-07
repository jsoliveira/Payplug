/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "formas_pagamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormasPagamentos.findAll", query = "SELECT f FROM FormasPagamentos f"),
    @NamedQuery(name = "FormasPagamentos.findById", query = "SELECT f FROM FormasPagamentos f WHERE f.id = :id"),
    @NamedQuery(name = "FormasPagamentos.findByNome", query = "SELECT f FROM FormasPagamentos f WHERE f.nome = :nome")})
public class FormasPagamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idFormaPagamento")
    private List<Transacoes> transacoesList;
    @OneToMany(mappedBy = "idFormaPagamento")
    private List<OperacoesTaxas> operacoesTaxasList;

    public FormasPagamentos() {
    }

    public FormasPagamentos(Integer id) {
        this.id = id;
    }

    public FormasPagamentos(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Transacoes> getTransacoesList() {
        return transacoesList;
    }

    public void setTransacoesList(List<Transacoes> transacoesList) {
        this.transacoesList = transacoesList;
    }

    @XmlTransient
    public List<OperacoesTaxas> getOperacoesTaxasList() {
        return operacoesTaxasList;
    }

    public void setOperacoesTaxasList(List<OperacoesTaxas> operacoesTaxasList) {
        this.operacoesTaxasList = operacoesTaxasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormasPagamentos)) {
            return false;
        }
        FormasPagamentos other = (FormasPagamentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.FormasPagamentos[ id=" + id + " ]";
    }
    
}
