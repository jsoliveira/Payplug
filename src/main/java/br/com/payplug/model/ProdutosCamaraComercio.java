/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "produtos_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutosCamaraComercio.findAll", query = "SELECT p FROM ProdutosCamaraComercio p"),
    @NamedQuery(name = "ProdutosCamaraComercio.findById", query = "SELECT p FROM ProdutosCamaraComercio p WHERE p.id = :id"),
    @NamedQuery(name = "ProdutosCamaraComercio.findByNome", query = "SELECT p FROM ProdutosCamaraComercio p WHERE p.nome = :nome"),
    @NamedQuery(name = "ProdutosCamaraComercio.findByLote", query = "SELECT p FROM ProdutosCamaraComercio p WHERE p.lote = :lote"),
    @NamedQuery(name = "ProdutosCamaraComercio.findByNomeImagem", query = "SELECT p FROM ProdutosCamaraComercio p WHERE p.nomeImagem = :nomeImagem"),
    @NamedQuery(name = "ProdutosCamaraComercio.findByRemovido", query = "SELECT p FROM ProdutosCamaraComercio p WHERE p.removido = :removido")})
public class ProdutosCamaraComercio implements Serializable {

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "lote")
    private BigDecimal lote;
    @Lob
    @Column(name = "imagem")
    private byte[] imagem;
    @Size(max = 200)
    @Column(name = "nome_imagem")
    private String nomeImagem;
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
    @JoinColumn(name = "id_comercializacao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FormasComercializacaoCamaraComercio idComercializacao;
    @JoinColumn(name = "id_ncm", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ncm idNcm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<CotacoesCamaraComercio> cotacoesCamaraComercioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<PlanosCamaraComercio> planosCamaraComercioList;

    public ProdutosCamaraComercio() {
    }

    public ProdutosCamaraComercio(Integer id) {
        this.id = id;
    }

    public ProdutosCamaraComercio(Integer id, String nome, BigDecimal lote, int removido) {
        this.id = id;
        this.nome = nome;
        this.lote = lote;
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

    public BigDecimal getLote() {
        return lote;
    }

    public void setLote(BigDecimal lote) {
        this.lote = lote;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
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

    public FormasComercializacaoCamaraComercio getIdComercializacao() {
        return idComercializacao;
    }

    public void setIdComercializacao(FormasComercializacaoCamaraComercio idComercializacao) {
        this.idComercializacao = idComercializacao;
    }

    public Ncm getIdNcm() {
        return idNcm;
    }

    public void setIdNcm(Ncm idNcm) {
        this.idNcm = idNcm;
    }

    @XmlTransient
    public List<CotacoesCamaraComercio> getCotacoesCamaraComercioList() {
        return cotacoesCamaraComercioList;
    }

    public void setCotacoesCamaraComercioList(List<CotacoesCamaraComercio> cotacoesCamaraComercioList) {
        this.cotacoesCamaraComercioList = cotacoesCamaraComercioList;
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
        if (!(object instanceof ProdutosCamaraComercio)) {
            return false;
        }
        ProdutosCamaraComercio other = (ProdutosCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.ProdutosCamaraComercio[ id=" + id + " ]";
    }
    
}
