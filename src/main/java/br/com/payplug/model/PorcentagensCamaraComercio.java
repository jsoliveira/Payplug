/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "porcentagens_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PorcentagensCamaraComercio.findAll", query = "SELECT p FROM PorcentagensCamaraComercio p"),
    @NamedQuery(name = "PorcentagensCamaraComercio.findById", query = "SELECT p FROM PorcentagensCamaraComercio p WHERE p.id = :id"),
    @NamedQuery(name = "PorcentagensCamaraComercio.findByValor", query = "SELECT p FROM PorcentagensCamaraComercio p WHERE p.valor = :valor")})
public class PorcentagensCamaraComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;

    public PorcentagensCamaraComercio() {
    }

    public PorcentagensCamaraComercio(Integer id) {
        this.id = id;
    }

    public PorcentagensCamaraComercio(Integer id, BigDecimal valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
        if (!(object instanceof PorcentagensCamaraComercio)) {
            return false;
        }
        PorcentagensCamaraComercio other = (PorcentagensCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.PorcentagensCamaraComercio[ id=" + id + " ]";
    }
    
}
