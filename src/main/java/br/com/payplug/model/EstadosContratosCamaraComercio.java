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
@Table(name = "estados_contratos_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosContratosCamaraComercio.findAll", query = "SELECT e FROM EstadosContratosCamaraComercio e"),
    @NamedQuery(name = "EstadosContratosCamaraComercio.findById", query = "SELECT e FROM EstadosContratosCamaraComercio e WHERE e.id = :id"),
    @NamedQuery(name = "EstadosContratosCamaraComercio.findByNome", query = "SELECT e FROM EstadosContratosCamaraComercio e WHERE e.nome = :nome")})
public class EstadosContratosCamaraComercio implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoContrato")
    private List<ContratosCamaraComercio> contratosCamaraComercioList;

    public EstadosContratosCamaraComercio() {
    }

    public EstadosContratosCamaraComercio(Integer id) {
        this.id = id;
    }

    public EstadosContratosCamaraComercio(Integer id, String nome) {
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
    public List<ContratosCamaraComercio> getContratosCamaraComercioList() {
        return contratosCamaraComercioList;
    }

    public void setContratosCamaraComercioList(List<ContratosCamaraComercio> contratosCamaraComercioList) {
        this.contratosCamaraComercioList = contratosCamaraComercioList;
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
        if (!(object instanceof EstadosContratosCamaraComercio)) {
            return false;
        }
        EstadosContratosCamaraComercio other = (EstadosContratosCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.EstadosContratosCamaraComercio[ id=" + id + " ]";
    }
    
}
