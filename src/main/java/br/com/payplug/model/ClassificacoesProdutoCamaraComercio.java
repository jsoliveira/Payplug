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
@Table(name = "classificacoes_produto_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassificacoesProdutoCamaraComercio.findAll", query = "SELECT c FROM ClassificacoesProdutoCamaraComercio c"),
    @NamedQuery(name = "ClassificacoesProdutoCamaraComercio.findById", query = "SELECT c FROM ClassificacoesProdutoCamaraComercio c WHERE c.id = :id"),
    @NamedQuery(name = "ClassificacoesProdutoCamaraComercio.findByNome", query = "SELECT c FROM ClassificacoesProdutoCamaraComercio c WHERE c.nome = :nome")})
public class ClassificacoesProdutoCamaraComercio implements Serializable {

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

    public ClassificacoesProdutoCamaraComercio() {
    }

    public ClassificacoesProdutoCamaraComercio(Integer id) {
        this.id = id;
    }

    public ClassificacoesProdutoCamaraComercio(Integer id, String nome) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassificacoesProdutoCamaraComercio)) {
            return false;
        }
        ClassificacoesProdutoCamaraComercio other = (ClassificacoesProdutoCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.ClassificacoesProdutoCamaraComercio[ id=" + id + " ]";
    }
    
}
