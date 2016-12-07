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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "moedas_historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MoedasHistorico.findAll", query = "SELECT m FROM MoedasHistorico m"),
    @NamedQuery(name = "MoedasHistorico.findById", query = "SELECT m FROM MoedasHistorico m WHERE m.id = :id"),
    @NamedQuery(name = "MoedasHistorico.findByIdMoeda", query = "SELECT m FROM MoedasHistorico m WHERE m.idMoeda = :idMoeda"),
    @NamedQuery(name = "MoedasHistorico.findByCambioCompra", query = "SELECT m FROM MoedasHistorico m WHERE m.cambioCompra = :cambioCompra"),
    @NamedQuery(name = "MoedasHistorico.findByCambioVenda", query = "SELECT m FROM MoedasHistorico m WHERE m.cambioVenda = :cambioVenda"),
    @NamedQuery(name = "MoedasHistorico.findByDataCotacao", query = "SELECT m FROM MoedasHistorico m WHERE m.dataCotacao = :dataCotacao")})
public class MoedasHistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_moeda")
    private int idMoeda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambio_compra")
    private BigDecimal cambioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambio_venda")
    private BigDecimal cambioVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cotacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCotacao;

    public MoedasHistorico() {
    }

    public MoedasHistorico(Integer id) {
        this.id = id;
    }

    public MoedasHistorico(Integer id, int idMoeda, BigDecimal cambioCompra, BigDecimal cambioVenda, Date dataCotacao) {
        this.id = id;
        this.idMoeda = idMoeda;
        this.cambioCompra = cambioCompra;
        this.cambioVenda = cambioVenda;
        this.dataCotacao = dataCotacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdMoeda() {
        return idMoeda;
    }

    public void setIdMoeda(int idMoeda) {
        this.idMoeda = idMoeda;
    }

    public BigDecimal getCambioCompra() {
        return cambioCompra;
    }

    public void setCambioCompra(BigDecimal cambioCompra) {
        this.cambioCompra = cambioCompra;
    }

    public BigDecimal getCambioVenda() {
        return cambioVenda;
    }

    public void setCambioVenda(BigDecimal cambioVenda) {
        this.cambioVenda = cambioVenda;
    }

    public Date getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(Date dataCotacao) {
        this.dataCotacao = dataCotacao;
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
        if (!(object instanceof MoedasHistorico)) {
            return false;
        }
        MoedasHistorico other = (MoedasHistorico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.MoedasHistorico[ id=" + id + " ]";
    }
    
}
