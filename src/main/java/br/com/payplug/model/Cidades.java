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
@Table(name = "cidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidades.findAll", query = "SELECT c FROM Cidades c"),
    @NamedQuery(name = "Cidades.findById", query = "SELECT c FROM Cidades c WHERE c.id = :id"),
    @NamedQuery(name = "Cidades.findByNome", query = "SELECT c FROM Cidades c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cidades.findByRemovido", query = "SELECT c FROM Cidades c WHERE c.removido = :removido")})
public class Cidades implements Serializable {

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
    @Column(name = "removido")
    private Integer removido;
    @OneToMany(mappedBy = "idCidade")
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estados idEstado;

    public Cidades() {
    }

    public Cidades(Integer id) {
        this.id = id;
    }

    public Cidades(Integer id, String nome) {
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

    public Integer getRemovido() {
        return removido;
    }

    public void setRemovido(Integer removido) {
        this.removido = removido;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Estados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estados idEstado) {
        this.idEstado = idEstado;
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
        if (!(object instanceof Cidades)) {
            return false;
        }
        Cidades other = (Cidades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Cidades[ id=" + id + " ]";
    }
    
}
