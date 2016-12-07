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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "contratos_camara_comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContratosCamaraComercio.findAll", query = "SELECT c FROM ContratosCamaraComercio c"),
    @NamedQuery(name = "ContratosCamaraComercio.findById", query = "SELECT c FROM ContratosCamaraComercio c WHERE c.id = :id"),
    @NamedQuery(name = "ContratosCamaraComercio.findByIsAssinaturaVenda", query = "SELECT c FROM ContratosCamaraComercio c WHERE c.isAssinaturaVenda = :isAssinaturaVenda"),
    @NamedQuery(name = "ContratosCamaraComercio.findByIsAssinaturaCompra", query = "SELECT c FROM ContratosCamaraComercio c WHERE c.isAssinaturaCompra = :isAssinaturaCompra"),
    @NamedQuery(name = "ContratosCamaraComercio.findByRemovido", query = "SELECT c FROM ContratosCamaraComercio c WHERE c.removido = :removido"),
    @NamedQuery(name = "ContratosCamaraComercio.findByValorBloqueado", query = "SELECT c FROM ContratosCamaraComercio c WHERE c.valorBloqueado = :valorBloqueado"),
    @NamedQuery(name = "ContratosCamaraComercio.findByValorBloqueadoMoedaUsuario", query = "SELECT c FROM ContratosCamaraComercio c WHERE c.valorBloqueadoMoedaUsuario = :valorBloqueadoMoedaUsuario"),
    @NamedQuery(name = "ContratosCamaraComercio.findByTaxaCambio", query = "SELECT c FROM ContratosCamaraComercio c WHERE c.taxaCambio = :taxaCambio"),
    @NamedQuery(name = "ContratosCamaraComercio.findByDataFechamento", query = "SELECT c FROM ContratosCamaraComercio c WHERE c.dataFechamento = :dataFechamento")})
public class ContratosCamaraComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_assinatura_venda")
    private boolean isAssinaturaVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_assinatura_compra")
    private boolean isAssinaturaCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_bloqueado")
    private BigDecimal valorBloqueado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_bloqueado_moeda_usuario")
    private BigDecimal valorBloqueadoMoedaUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxa_cambio")
    private BigDecimal taxaCambio;
    @Column(name = "data_fechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFechamento;
    @JoinColumn(name = "id_cotacao_venda", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CotacoesCamaraComercio idCotacaoVenda;
    @JoinColumn(name = "id_cotacao_compra", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CotacoesCamaraComercio idCotacaoCompra;
    @JoinColumn(name = "id_estado_contrato", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstadosContratosCamaraComercio idEstadoContrato;

    public ContratosCamaraComercio() {
    }

    public ContratosCamaraComercio(Integer id) {
        this.id = id;
    }

    public ContratosCamaraComercio(Integer id, boolean isAssinaturaVenda, boolean isAssinaturaCompra, int removido, BigDecimal valorBloqueado, BigDecimal valorBloqueadoMoedaUsuario, BigDecimal taxaCambio) {
        this.id = id;
        this.isAssinaturaVenda = isAssinaturaVenda;
        this.isAssinaturaCompra = isAssinaturaCompra;
        this.removido = removido;
        this.valorBloqueado = valorBloqueado;
        this.valorBloqueadoMoedaUsuario = valorBloqueadoMoedaUsuario;
        this.taxaCambio = taxaCambio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsAssinaturaVenda() {
        return isAssinaturaVenda;
    }

    public void setIsAssinaturaVenda(boolean isAssinaturaVenda) {
        this.isAssinaturaVenda = isAssinaturaVenda;
    }

    public boolean getIsAssinaturaCompra() {
        return isAssinaturaCompra;
    }

    public void setIsAssinaturaCompra(boolean isAssinaturaCompra) {
        this.isAssinaturaCompra = isAssinaturaCompra;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public BigDecimal getValorBloqueado() {
        return valorBloqueado;
    }

    public void setValorBloqueado(BigDecimal valorBloqueado) {
        this.valorBloqueado = valorBloqueado;
    }

    public BigDecimal getValorBloqueadoMoedaUsuario() {
        return valorBloqueadoMoedaUsuario;
    }

    public void setValorBloqueadoMoedaUsuario(BigDecimal valorBloqueadoMoedaUsuario) {
        this.valorBloqueadoMoedaUsuario = valorBloqueadoMoedaUsuario;
    }

    public BigDecimal getTaxaCambio() {
        return taxaCambio;
    }

    public void setTaxaCambio(BigDecimal taxaCambio) {
        this.taxaCambio = taxaCambio;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public CotacoesCamaraComercio getIdCotacaoVenda() {
        return idCotacaoVenda;
    }

    public void setIdCotacaoVenda(CotacoesCamaraComercio idCotacaoVenda) {
        this.idCotacaoVenda = idCotacaoVenda;
    }

    public CotacoesCamaraComercio getIdCotacaoCompra() {
        return idCotacaoCompra;
    }

    public void setIdCotacaoCompra(CotacoesCamaraComercio idCotacaoCompra) {
        this.idCotacaoCompra = idCotacaoCompra;
    }

    public EstadosContratosCamaraComercio getIdEstadoContrato() {
        return idEstadoContrato;
    }

    public void setIdEstadoContrato(EstadosContratosCamaraComercio idEstadoContrato) {
        this.idEstadoContrato = idEstadoContrato;
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
        if (!(object instanceof ContratosCamaraComercio)) {
            return false;
        }
        ContratosCamaraComercio other = (ContratosCamaraComercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.ContratosCamaraComercio[ id=" + id + " ]";
    }
    
}
