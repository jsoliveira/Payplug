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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "categorias_classificacoes_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriasClassificacoesCamaraComercio.findAll", query = "SELECT c FROM CategoriasClassificacoesCamaraComercio c"),
    @NamedQuery(name = "CategoriasClassificacoesCamaraComercio.findById", query = "SELECT c FROM CategoriasClassificacoesCamaraComercio c WHERE c.id = :id"),
    @NamedQuery(name = "CategoriasClassificacoesCamaraComercio.findByRemovido", query = "SELECT c FROM CategoriasClassificacoesCamaraComercio c WHERE c.removido = :removido")})
public class CategoriasClassificacoesCamaraComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoriasCamaraComercio idCategoria;
    @JoinColumn(name = "id_classificacao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClassificacoesCamaraComercio idClassificacao;

    public CategoriasClassificacoesCamaraComercio() {
    }

    public CategoriasClassificacoesCamaraComercio(Integer id) {
        this.id = id;
    }

    public CategoriasClassificacoesCamaraComercio(Integer id, int removido) {
        this.id = id;
        this.removido = removido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public CategoriasCamaraComercio getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriasCamaraComercio idCategoria) {
        this.idCategoria = idCategoria;
    }

    public ClassificacoesCamaraComercio getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(ClassificacoesCamaraComercio idClassificacao) {
        this.idClassificacao = idClassificacao;
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
        if (!(object instanceof CategoriasClassificacoesCamaraComercio)) {
            return false;
        }
        CategoriasClassificacoesCamaraComercio other = (CategoriasClassificacoesCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.CategoriasClassificacoesCamaraComercio[ id=" + id + " ]";
    }
    
}
