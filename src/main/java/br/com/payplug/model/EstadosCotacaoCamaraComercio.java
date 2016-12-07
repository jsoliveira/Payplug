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
@Table(name = "estados_cotacao_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosCotacaoCamaraComercio.findAll", query = "SELECT e FROM EstadosCotacaoCamaraComercio e"),
    @NamedQuery(name = "EstadosCotacaoCamaraComercio.findById", query = "SELECT e FROM EstadosCotacaoCamaraComercio e WHERE e.id = :id"),
    @NamedQuery(name = "EstadosCotacaoCamaraComercio.findByNome", query = "SELECT e FROM EstadosCotacaoCamaraComercio e WHERE e.nome = :nome")})
public class EstadosCotacaoCamaraComercio implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoCotacao")
    private List<CotacoesCamaraComercio> cotacoesCamaraComercioList;

    public EstadosCotacaoCamaraComercio() {
    }

    public EstadosCotacaoCamaraComercio(Integer id) {
        this.id = id;
    }

    public EstadosCotacaoCamaraComercio(Integer id, String nome) {
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
    public List<CotacoesCamaraComercio> getCotacoesCamaraComercioList() {
        return cotacoesCamaraComercioList;
    }

    public void setCotacoesCamaraComercioList(List<CotacoesCamaraComercio> cotacoesCamaraComercioList) {
        this.cotacoesCamaraComercioList = cotacoesCamaraComercioList;
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
        if (!(object instanceof EstadosCotacaoCamaraComercio)) {
            return false;
        }
        EstadosCotacaoCamaraComercio other = (EstadosCotacaoCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.EstadosCotacaoCamaraComercio[ id=" + id + " ]";
    }
    
}
