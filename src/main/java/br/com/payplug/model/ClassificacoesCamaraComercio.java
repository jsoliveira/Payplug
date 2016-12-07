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
@Table(name = "classificacoes_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassificacoesCamaraComercio.findAll", query = "SELECT c FROM ClassificacoesCamaraComercio c"),
    @NamedQuery(name = "ClassificacoesCamaraComercio.findById", query = "SELECT c FROM ClassificacoesCamaraComercio c WHERE c.id = :id"),
    @NamedQuery(name = "ClassificacoesCamaraComercio.findByNome", query = "SELECT c FROM ClassificacoesCamaraComercio c WHERE c.nome = :nome"),
    @NamedQuery(name = "ClassificacoesCamaraComercio.findByRemovido", query = "SELECT c FROM ClassificacoesCamaraComercio c WHERE c.removido = :removido")})
public class ClassificacoesCamaraComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClassificacao")
    private List<ProdutosCamaraComercio> produtosCamaraComercioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClassificacao")
    private List<CategoriasClassificacoesCamaraComercio> categoriasClassificacoesCamaraComercioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClassificacaoProduto")
    private List<PlanosCamaraComercio> planosCamaraComercioList;

    public ClassificacoesCamaraComercio() {
    }

    public ClassificacoesCamaraComercio(Integer id) {
        this.id = id;
    }

    public ClassificacoesCamaraComercio(Integer id, String nome, int removido) {
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

    @XmlTransient
    public List<ProdutosCamaraComercio> getProdutosCamaraComercioList() {
        return produtosCamaraComercioList;
    }

    public void setProdutosCamaraComercioList(List<ProdutosCamaraComercio> produtosCamaraComercioList) {
        this.produtosCamaraComercioList = produtosCamaraComercioList;
    }

    @XmlTransient
    public List<CategoriasClassificacoesCamaraComercio> getCategoriasClassificacoesCamaraComercioList() {
        return categoriasClassificacoesCamaraComercioList;
    }

    public void setCategoriasClassificacoesCamaraComercioList(List<CategoriasClassificacoesCamaraComercio> categoriasClassificacoesCamaraComercioList) {
        this.categoriasClassificacoesCamaraComercioList = categoriasClassificacoesCamaraComercioList;
    }

    @XmlTransient
    public List<PlanosCamaraComercio> getPlanosCamaraComercioList() {
        return planosCamaraComercioList;
    }

    public void setPlanosCamaraComercioList(List<PlanosCamaraComercio> planosCamaraComercioList) {
        this.planosCamaraComercioList = planosCamaraComercioList;
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
        if (!(object instanceof ClassificacoesCamaraComercio)) {
            return false;
        }
        ClassificacoesCamaraComercio other = (ClassificacoesCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.ClassificacoesCamaraComercio[ id=" + id + " ]";
    }
    
}
