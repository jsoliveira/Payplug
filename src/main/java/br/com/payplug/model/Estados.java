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
@Table(name = "estados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e"),
    @NamedQuery(name = "Estados.findById", query = "SELECT e FROM Estados e WHERE e.id = :id"),
    @NamedQuery(name = "Estados.findBySigla", query = "SELECT e FROM Estados e WHERE e.sigla = :sigla"),
    @NamedQuery(name = "Estados.findByNome", query = "SELECT e FROM Estados e WHERE e.nome = :nome"),
    @NamedQuery(name = "Estados.findByRemovido", query = "SELECT e FROM Estados e WHERE e.removido = :removido")})
public class Estados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "sigla")
    private String sigla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome")
    private String nome;
    @Column(name = "removido")
    private Integer removido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Cidades> cidadesList;

    public Estados() {
    }

    public Estados(Integer id) {
        this.id = id;
    }

    public Estados(Integer id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRemovido() {
        return removido;
    }

    public void setRemovido(Integer removido) {
        this.removido = removido;
    }

    @XmlTransient
    public List<Cidades> getCidadesList() {
        return cidadesList;
    }

    public void setCidadesList(List<Cidades> cidadesList) {
        this.cidadesList = cidadesList;
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
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Estados[ id=" + id + " ]";
    }
    
}
