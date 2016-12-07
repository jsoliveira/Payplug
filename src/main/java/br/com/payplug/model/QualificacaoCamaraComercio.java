/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "qualificacao_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QualificacaoCamaraComercio.findAll", query = "SELECT q FROM QualificacaoCamaraComercio q"),
    @NamedQuery(name = "QualificacaoCamaraComercio.findById", query = "SELECT q FROM QualificacaoCamaraComercio q WHERE q.id = :id"),
    @NamedQuery(name = "QualificacaoCamaraComercio.findByNome", query = "SELECT q FROM QualificacaoCamaraComercio q WHERE q.nome = :nome"),
    @NamedQuery(name = "QualificacaoCamaraComercio.findByRemovido", query = "SELECT q FROM QualificacaoCamaraComercio q WHERE q.removido = :removido")})
public class QualificacaoCamaraComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;

    public QualificacaoCamaraComercio() {
    }

    public QualificacaoCamaraComercio(Integer id) {
        this.id = id;
    }

    public QualificacaoCamaraComercio(Integer id, String nome, int removido) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QualificacaoCamaraComercio)) {
            return false;
        }
        QualificacaoCamaraComercio other = (QualificacaoCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.QualificacaoCamaraComercio[ id=" + id + " ]";
    }
    
}
