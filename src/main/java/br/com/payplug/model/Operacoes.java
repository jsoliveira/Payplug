/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "operacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operacoes.findAll", query = "SELECT o FROM Operacoes o"),
    @NamedQuery(name = "Operacoes.findById", query = "SELECT o FROM Operacoes o WHERE o.id = :id"),
    @NamedQuery(name = "Operacoes.findByNome", query = "SELECT o FROM Operacoes o WHERE o.nome = :nome")})
public class Operacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperacoes")
    private List<SmsTextos> smsTextosList;
    @OneToMany(mappedBy = "idOperacao")
    private List<Transacoes> transacoesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperacao")
    private List<OperacoesTaxas> operacoesTaxasList;
    @Column(name = "indoperacao")
    private String indoperacao;
    @Column(name = "indbonificacao")
    private String indbonificacao;
    @Column(name = "qtdcobranca")
    private Integer qtdcobranca;

    public Integer getQtdcobranca() {
        return qtdcobranca;
    }

    public void setQtdcobranca(Integer qtdcobranca) {
        this.qtdcobranca = qtdcobranca;
    }
    
    public String getIndoperacao() {
        return indoperacao;
    }

    public void setIndoperacao(String indoperacao) {
        this.indoperacao = indoperacao;
    }

    public String getIndbonificacao() {
        return indbonificacao;
    }

    public void setIndbonificacao(String indbonificacao) {
        this.indbonificacao = indbonificacao;
    }

    public Operacoes() {
    }

    public Operacoes(Integer id) {
        this.id = id;
    }

    public Operacoes(Integer id, String nome) {
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
    public List<SmsTextos> getSmsTextosList() {
        return smsTextosList;
    }

    public void setSmsTextosList(List<SmsTextos> smsTextosList) {
        this.smsTextosList = smsTextosList;
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
        if (!(object instanceof Operacoes)) {
            return false;
        }
        Operacoes other = (Operacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Operacoes[ id=" + id + nome + " ]";
    }
    
}
