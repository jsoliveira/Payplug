/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "operacoes_taxas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperacoesTaxas.findAll", query = "SELECT o FROM OperacoesTaxas o"),
    @NamedQuery(name = "OperacoesTaxas.findById", query = "SELECT o FROM OperacoesTaxas o WHERE o.id = :id"),
    @NamedQuery(name = "OperacoesTaxas.findByNome", query = "SELECT o FROM OperacoesTaxas o WHERE o.nome = :nome"),
    @NamedQuery(name = "OperacoesTaxas.findByTaxaReal", query = "SELECT o FROM OperacoesTaxas o WHERE o.taxaReal = :taxaReal"),
    @NamedQuery(name = "OperacoesTaxas.findByTaxaPercentual", query = "SELECT o FROM OperacoesTaxas o WHERE o.taxaPercentual = :taxaPercentual"),
    @NamedQuery(name = "OperacoesTaxas.findByIsOrigemPaga", query = "SELECT o FROM OperacoesTaxas o WHERE o.isOrigemPaga = :isOrigemPaga"),
    @NamedQuery(name = "OperacoesTaxas.findByRemovido", query = "SELECT o FROM OperacoesTaxas o WHERE o.removido = :removido"),
    @NamedQuery(name = "OperacoesTaxas.findByTipoTaxa", query = "SELECT o FROM OperacoesTaxas o WHERE o.tipoTaxa = :tipoTaxa"),
    @NamedQuery(name = "OperacoesTaxas.findByIsOrigemRecebe", query = "SELECT o FROM OperacoesTaxas o WHERE o.isOrigemRecebe = :isOrigemRecebe")})
public class OperacoesTaxas implements Serializable {

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxa_real")
    private BigDecimal taxaReal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxa_percentual")
    private BigDecimal taxaPercentual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_origem_paga")
    private boolean isOrigemPaga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_taxa")
    private int tipoTaxa;
    @Column(name = "is_origem_recebe")
    private Boolean isOrigemRecebe;
    @OneToMany(mappedBy = "idOperacaoTaxa")
    private List<Transacoes> transacoesList;
    @JoinColumn(name = "id_forma_pagamento", referencedColumnName = "id")
    @ManyToOne
    private FormasPagamentos idFormaPagamento;
    @JoinColumn(name = "id_operacao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operacoes idOperacao;

    public OperacoesTaxas() {
    }

    public OperacoesTaxas(Integer id) {
        this.id = id;
    }

    public OperacoesTaxas(Integer id, String nome, BigDecimal taxaReal, BigDecimal taxaPercentual, boolean isOrigemPaga, int removido, int tipoTaxa) {
        this.id = id;
        this.nome = nome;
        this.taxaReal = taxaReal;
        this.taxaPercentual = taxaPercentual;
        this.isOrigemPaga = isOrigemPaga;
        this.removido = removido;
        this.tipoTaxa = tipoTaxa;
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

    public BigDecimal getTaxaReal() {
        return taxaReal;
    }

    public void setTaxaReal(BigDecimal taxaReal) {
        this.taxaReal = taxaReal;
    }

    public BigDecimal getTaxaPercentual() {
        return taxaPercentual;
    }

    public void setTaxaPercentual(BigDecimal taxaPercentual) {
        this.taxaPercentual = taxaPercentual;
    }

    public boolean getIsOrigemPaga() {
        return isOrigemPaga;
    }

    public void setIsOrigemPaga(boolean isOrigemPaga) {
        this.isOrigemPaga = isOrigemPaga;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public int getTipoTaxa() {
        return tipoTaxa;
    }

    public void setTipoTaxa(int tipoTaxa) {
        this.tipoTaxa = tipoTaxa;
    }

    public Boolean getIsOrigemRecebe() {
        return isOrigemRecebe;
    }

    public void setIsOrigemRecebe(Boolean isOrigemRecebe) {
        this.isOrigemRecebe = isOrigemRecebe;
    }

    @XmlTransient
    public List<Transacoes> getTransacoesList() {
        return transacoesList;
    }

    public void setTransacoesList(List<Transacoes> transacoesList) {
        this.transacoesList = transacoesList;
    }

    public FormasPagamentos getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(FormasPagamentos idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public Operacoes getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(Operacoes idOperacao) {
        this.idOperacao = idOperacao;
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
        if (!(object instanceof OperacoesTaxas)) {
            return false;
        }
        OperacoesTaxas other = (OperacoesTaxas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.OperacoesTaxas[ id=" + id + " ]";
    }
    
}
