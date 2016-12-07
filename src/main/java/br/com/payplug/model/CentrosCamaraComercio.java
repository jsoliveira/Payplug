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
@Table(name = "centros_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentrosCamaraComercio.findAll", query = "SELECT c FROM CentrosCamaraComercio c"),
    @NamedQuery(name = "CentrosCamaraComercio.findById", query = "SELECT c FROM CentrosCamaraComercio c WHERE c.id = :id"),
    @NamedQuery(name = "CentrosCamaraComercio.findByNome", query = "SELECT c FROM CentrosCamaraComercio c WHERE c.nome = :nome"),
    @NamedQuery(name = "CentrosCamaraComercio.findByRemovido", query = "SELECT c FROM CentrosCamaraComercio c WHERE c.removido = :removido")})
public class CentrosCamaraComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentro")
    private List<CotacoesCamaraComercio> cotacoesCamaraComercioList;

    public CentrosCamaraComercio() {
    }

    public CentrosCamaraComercio(Integer id) {
        this.id = id;
    }

    public CentrosCamaraComercio(Integer id, int removido) {
        this.id = id;
        this.removido = removido;
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

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
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
        if (!(object instanceof CentrosCamaraComercio)) {
            return false;
        }
        CentrosCamaraComercio other = (CentrosCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.CentrosCamaraComercio[ id=" + id + " ]";
    }
    
}
