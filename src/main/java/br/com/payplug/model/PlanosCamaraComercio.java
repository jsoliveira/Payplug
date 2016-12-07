/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "planos_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanosCamaraComercio.findAll", query = "SELECT p FROM PlanosCamaraComercio p"),
    @NamedQuery(name = "PlanosCamaraComercio.findById", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.id = :id"),
    @NamedQuery(name = "PlanosCamaraComercio.findByEstimativa", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.estimativa = :estimativa"),
    @NamedQuery(name = "PlanosCamaraComercio.findByTalhao", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.talhao = :talhao"),
    @NamedQuery(name = "PlanosCamaraComercio.findByDe", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.de = :de"),
    @NamedQuery(name = "PlanosCamaraComercio.findByAte", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.ate = :ate"),
    @NamedQuery(name = "PlanosCamaraComercio.findByRastreio", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.rastreio = :rastreio"),
    @NamedQuery(name = "PlanosCamaraComercio.findByValor", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.valor = :valor"),
    @NamedQuery(name = "PlanosCamaraComercio.findByValorMercado", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.valorMercado = :valorMercado"),
    @NamedQuery(name = "PlanosCamaraComercio.findByRemovido", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.removido = :removido"),
    @NamedQuery(name = "PlanosCamaraComercio.findByNomeArquivo", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.nomeArquivo = :nomeArquivo"),
    @NamedQuery(name = "PlanosCamaraComercio.findByNomeOriginal", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.nomeOriginal = :nomeOriginal"),
    @NamedQuery(name = "PlanosCamaraComercio.findByExtensao", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.extensao = :extensao"),
    @NamedQuery(name = "PlanosCamaraComercio.findByTamanho", query = "SELECT p FROM PlanosCamaraComercio p WHERE p.tamanho = :tamanho")})
public class PlanosCamaraComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "estimativa")
    private BigDecimal estimativa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "talhao")
    private BigDecimal talhao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "de")
    @Temporal(TemporalType.TIMESTAMP)
    private Date de;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "rastreio")
    private String rastreio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_mercado")
    private BigDecimal valorMercado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @Size(max = 2147483647)
    @Column(name = "nome_arquivo")
    private String nomeArquivo;
    @Size(max = 2147483647)
    @Column(name = "nome_original")
    private String nomeOriginal;
    @Size(max = 2147483647)
    @Column(name = "extensao")
    private String extensao;
    @Size(max = 2147483647)
    @Column(name = "tamanho")
    private String tamanho;
    @Lob
    @Column(name = "bytes")
    private byte[] bytes;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoriasCamaraComercio idCategoria;
    @JoinColumn(name = "id_classificacao_produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClassificacoesCamaraComercio idClassificacaoProduto;
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProdutosCamaraComercio idProduto;
    @JoinColumn(name = "id_produtor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idProdutor;

    public PlanosCamaraComercio() {
    }

    public PlanosCamaraComercio(Integer id) {
        this.id = id;
    }

    public PlanosCamaraComercio(Integer id, BigDecimal estimativa, BigDecimal talhao, Date de, Date ate, String rastreio, BigDecimal valor, BigDecimal valorMercado, int removido) {
        this.id = id;
        this.estimativa = estimativa;
        this.talhao = talhao;
        this.de = de;
        this.ate = ate;
        this.rastreio = rastreio;
        this.valor = valor;
        this.valorMercado = valorMercado;
        this.removido = removido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getEstimativa() {
        return estimativa;
    }

    public void setEstimativa(BigDecimal estimativa) {
        this.estimativa = estimativa;
    }

    public BigDecimal getTalhao() {
        return talhao;
    }

    public void setTalhao(BigDecimal talhao) {
        this.talhao = talhao;
    }

    public Date getDe() {
        return de;
    }

    public void setDe(Date de) {
        this.de = de;
    }

    public Date getAte() {
        return ate;
    }

    public void setAte(Date ate) {
        this.ate = ate;
    }

    public String getRastreio() {
        return rastreio;
    }

    public void setRastreio(String rastreio) {
        this.rastreio = rastreio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(BigDecimal valorMercado) {
        this.valorMercado = valorMercado;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public CategoriasCamaraComercio getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriasCamaraComercio idCategoria) {
        this.idCategoria = idCategoria;
    }

    public ClassificacoesCamaraComercio getIdClassificacaoProduto() {
        return idClassificacaoProduto;
    }

    public void setIdClassificacaoProduto(ClassificacoesCamaraComercio idClassificacaoProduto) {
        this.idClassificacaoProduto = idClassificacaoProduto;
    }

    public ProdutosCamaraComercio getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(ProdutosCamaraComercio idProduto) {
        this.idProduto = idProduto;
    }

    public Usuarios getIdProdutor() {
        return idProdutor;
    }

    public void setIdProdutor(Usuarios idProdutor) {
        this.idProdutor = idProdutor;
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
        if (!(object instanceof PlanosCamaraComercio)) {
            return false;
        }
        PlanosCamaraComercio other = (PlanosCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.PlanosCamaraComercio[ id=" + id + " ]";
    }
    
}
