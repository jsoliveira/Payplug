/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "cotacoes_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CotacoesCamaraComercio.findAll", query = "SELECT c FROM CotacoesCamaraComercio c"),
    @NamedQuery(name = "CotacoesCamaraComercio.findById", query = "SELECT c FROM CotacoesCamaraComercio c WHERE c.id = :id"),
    @NamedQuery(name = "CotacoesCamaraComercio.findByIdClassificacao", query = "SELECT c FROM CotacoesCamaraComercio c WHERE c.idClassificacao = :idClassificacao"),
    @NamedQuery(name = "CotacoesCamaraComercio.findByIsCompra", query = "SELECT c FROM CotacoesCamaraComercio c WHERE c.isCompra = :isCompra"),
    @NamedQuery(name = "CotacoesCamaraComercio.findByData", query = "SELECT c FROM CotacoesCamaraComercio c WHERE c.data = :data"),
    @NamedQuery(name = "CotacoesCamaraComercio.findByIsPreco", query = "SELECT c FROM CotacoesCamaraComercio c WHERE c.isPreco = :isPreco"),
    @NamedQuery(name = "CotacoesCamaraComercio.findByQuantidade", query = "SELECT c FROM CotacoesCamaraComercio c WHERE c.quantidade = :quantidade"),
    @NamedQuery(name = "CotacoesCamaraComercio.findByValor", query = "SELECT c FROM CotacoesCamaraComercio c WHERE c.valor = :valor"),
    @NamedQuery(name = "CotacoesCamaraComercio.findByRemovido", query = "SELECT c FROM CotacoesCamaraComercio c WHERE c.removido = :removido"),
    @NamedQuery(name = "CotacoesCamaraComercio.findByDataCadastro", query = "SELECT c FROM CotacoesCamaraComercio c WHERE c.dataCadastro = :dataCadastro")})
public class CotacoesCamaraComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_classificacao")
    private Integer idClassificacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_compra")
    private boolean isCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_preco")
    private boolean isPreco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCotacaoVenda")
    private List<ContratosCamaraComercio> contratosCamaraComercioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCotacaoCompra")
    private List<ContratosCamaraComercio> contratosCamaraComercioList1;
    @JoinColumn(name = "id_centro", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CentrosCamaraComercio idCentro;
    @JoinColumn(name = "id_estado_cotacao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstadosCotacaoCamaraComercio idEstadoCotacao;
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProdutosCamaraComercio idProduto;
    @JoinColumn(name = "id_proponente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idProponente;

    public CotacoesCamaraComercio() {
    }

    public CotacoesCamaraComercio(Integer id) {
        this.id = id;
    }

    public CotacoesCamaraComercio(Integer id, boolean isCompra, Date data, boolean isPreco, int quantidade, int removido) {
        this.id = id;
        this.isCompra = isCompra;
        this.data = data;
        this.isPreco = isPreco;
        this.quantidade = quantidade;
        this.removido = removido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(Integer idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public boolean getIsCompra() {
        return isCompra;
    }

    public void setIsCompra(boolean isCompra) {
        this.isCompra = isCompra;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean getIsPreco() {
        return isPreco;
    }

    public void setIsPreco(boolean isPreco) {
        this.isPreco = isPreco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @XmlTransient
    public List<ContratosCamaraComercio> getContratosCamaraComercioList() {
        return contratosCamaraComercioList;
    }

    public void setContratosCamaraComercioList(List<ContratosCamaraComercio> contratosCamaraComercioList) {
        this.contratosCamaraComercioList = contratosCamaraComercioList;
    }

    @XmlTransient
    public List<ContratosCamaraComercio> getContratosCamaraComercioList1() {
        return contratosCamaraComercioList1;
    }

    public void setContratosCamaraComercioList1(List<ContratosCamaraComercio> contratosCamaraComercioList1) {
        this.contratosCamaraComercioList1 = contratosCamaraComercioList1;
    }

    public CentrosCamaraComercio getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(CentrosCamaraComercio idCentro) {
        this.idCentro = idCentro;
    }

    public EstadosCotacaoCamaraComercio getIdEstadoCotacao() {
        return idEstadoCotacao;
    }

    public void setIdEstadoCotacao(EstadosCotacaoCamaraComercio idEstadoCotacao) {
        this.idEstadoCotacao = idEstadoCotacao;
    }

    public ProdutosCamaraComercio getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(ProdutosCamaraComercio idProduto) {
        this.idProduto = idProduto;
    }

    public Usuarios getIdProponente() {
        return idProponente;
    }

    public void setIdProponente(Usuarios idProponente) {
        this.idProponente = idProponente;
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
        if (!(object instanceof CotacoesCamaraComercio)) {
            return false;
        }
        CotacoesCamaraComercio other = (CotacoesCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.CotacoesCamaraComercio[ id=" + id + " ]";
    }
    
}
