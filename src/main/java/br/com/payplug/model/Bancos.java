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
@Table(name = "bancos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bancos.findAll", query = "SELECT b FROM Bancos b"),
    @NamedQuery(name = "Bancos.findById", query = "SELECT b FROM Bancos b WHERE b.id = :id"),
    @NamedQuery(name = "Bancos.findByNome", query = "SELECT b FROM Bancos b WHERE b.nome = :nome"),
    @NamedQuery(name = "Bancos.findByCodigo", query = "SELECT b FROM Bancos b WHERE b.codigo = :codigo"),
    @NamedQuery(name = "Bancos.findByRemovido", query = "SELECT b FROM Bancos b WHERE b.removido = :removido")})
public class Bancos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @OneToMany(mappedBy = "idBanco")
    private List<Usuarios> usuariosList;

    public Bancos() {
    }

    public Bancos(Integer id) {
        this.id = id;
    }

    public Bancos(Integer id, String nome, String codigo, int removido) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
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
        if (!(object instanceof Bancos)) {
            return false;
        }
        Bancos other = (Bancos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Bancos[ id=" + id + " ]";
    }
    
}
