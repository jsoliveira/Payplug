/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "cobranca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cobranca.findAll", query = "SELECT c FROM Cobranca c"),
    @NamedQuery(name = "Cobranca.findByIdCobranca", query = "SELECT c FROM Cobranca c WHERE c.idCobranca = :idCobranca"),
    @NamedQuery(name = "Cobranca.findByDesCobranca", query = "SELECT c FROM Cobranca c WHERE c.desCobranca = :desCobranca"),
    @NamedQuery(name = "Cobranca.findByDatVencimento", query = "SELECT c FROM Cobranca c WHERE c.datVencimento = :datVencimento"),
    @NamedQuery(name = "Cobranca.findByDatLiquidacao", query = "SELECT c FROM Cobranca c WHERE c.datLiquidacao = :datLiquidacao"),
    @NamedQuery(name = "Cobranca.findByValCobranca", query = "SELECT c FROM Cobranca c WHERE c.valCobranca = :valCobranca"),
    @NamedQuery(name = "Cobranca.findByValLiquidacao", query = "SELECT c FROM Cobranca c WHERE c.valLiquidacao = :valLiquidacao"),
    @NamedQuery(name = "Cobranca.findByDatTransacao", query = "SELECT c FROM Cobranca c WHERE c.datTransacao = :datTransacao"),
    @NamedQuery(name = "Cobranca.findByDatAlteracao", query = "SELECT c FROM Cobranca c WHERE c.datAlteracao = :datAlteracao")})
public class Cobranca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cobranca")
    private Long idCobranca;
    @Size(max = 50)
    @Column(name = "des_cobranca")
    private String desCobranca;
    @Column(name = "dat_vencimento")
    @Temporal(TemporalType.DATE)
    private Date datVencimento;
    @Column(name = "dat_liquidacao")
    @Temporal(TemporalType.DATE)
    private Date datLiquidacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "val_cobranca")
    private BigDecimal valCobranca;
    @Column(name = "val_liquidacao")
    private BigDecimal valLiquidacao;
    @Column(name = "dat_transacao")
    @Temporal(TemporalType.DATE)
    private Date datTransacao;
    @Column(name = "dat_alteracao")
    @Temporal(TemporalType.DATE)
    private Date datAlteracao;

    public Cobranca() {
    }

    public Cobranca(Long idCobranca) {
        this.idCobranca = idCobranca;
    }

    public Long getIdCobranca() {
        return idCobranca;
    }

    public void setIdCobranca(Long idCobranca) {
        this.idCobranca = idCobranca;
    }

    public String getDesCobranca() {
        return desCobranca;
    }

    public void setDesCobranca(String desCobranca) {
        this.desCobranca = desCobranca;
    }

    public Date getDatVencimento() {
        return datVencimento;
    }

    public void setDatVencimento(Date datVencimento) {
        this.datVencimento = datVencimento;
    }

    public Date getDatLiquidacao() {
        return datLiquidacao;
    }

    public void setDatLiquidacao(Date datLiquidacao) {
        this.datLiquidacao = datLiquidacao;
    }

    public BigDecimal getValCobranca() {
        return valCobranca;
    }

    public void setValCobranca(BigDecimal valCobranca) {
        this.valCobranca = valCobranca;
    }

    public BigDecimal getValLiquidacao() {
        return valLiquidacao;
    }

    public void setValLiquidacao(BigDecimal valLiquidacao) {
        this.valLiquidacao = valLiquidacao;
    }

    public Date getDatTransacao() {
        return datTransacao;
    }

    public void setDatTransacao(Date datTransacao) {
        this.datTransacao = datTransacao;
    }

    public Date getDatAlteracao() {
        return datAlteracao;
    }

    public void setDatAlteracao(Date datAlteracao) {
        this.datAlteracao = datAlteracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobranca != null ? idCobranca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobranca)) {
            return false;
        }
        Cobranca other = (Cobranca) object;
        if ((this.idCobranca == null && other.idCobranca != null) || (this.idCobranca != null && !this.idCobranca.equals(other.idCobranca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.payplug.model.Cobranca[ idCobranca=" + idCobranca + " ]";
    }
    
}
