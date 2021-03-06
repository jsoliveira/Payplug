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
@Table(name = "tipo_importacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoImportacoes.findAll", query = "SELECT t FROM TipoImportacoes t"),
    @NamedQuery(name = "TipoImportacoes.findById", query = "SELECT t FROM TipoImportacoes t WHERE t.id = :id"),
    @NamedQuery(name = "TipoImportacoes.findByNome", query = "SELECT t FROM TipoImportacoes t WHERE t.nome = :nome")})
public class TipoImportacoes implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoImportacao")
    private List<Importacoes> importacoesList;

    public TipoImportacoes() {
    }

    public TipoImportacoes(Integer id) {
        this.id = id;
    }

    public TipoImportacoes(Integer id, String nome) {
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
    public List<Importacoes> getImportacoesList() {
        return importacoesList;
    }

    public void setImportacoesList(List<Importacoes> importacoesList) {
        this.importacoesList = importacoesList;
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
        if (!(object instanceof TipoImportacoes)) {
            return false;
        }
        TipoImportacoes other = (TipoImportacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.TipoImportacoes[ id=" + id + " ]";
    }
    
}
