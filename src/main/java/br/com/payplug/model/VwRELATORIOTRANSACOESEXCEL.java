/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "vw_RELATORIO_TRANSACOESEXCEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findAll", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByLancamento", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.lancamento = :lancamento"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByTransacaoId", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.transacaoId = :transacaoId"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByTransacaoPaiId", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.transacaoPaiId = :transacaoPaiId"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByConta", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.conta = :conta"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByDescricao", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.descricao = :descricao"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByData", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.data = :data"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByContaMae", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.contaMae = :contaMae"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByValorReal", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.valorReal = :valorReal"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByValorMoedaUsuario", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.valorMoedaUsuario = :valorMoedaUsuario"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findBySaldoMoedaUsuario", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.saldoMoedaUsuario = :saldoMoedaUsuario"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findBySaldoRealUsuario", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.saldoRealUsuario = :saldoRealUsuario"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByTaxaCambio", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.taxaCambio = :taxaCambio"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByStatus", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.status = :status"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByTaxa", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.taxa = :taxa"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByOrigemPaga", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.origemPaga = :origemPaga"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByTaxaPercentual", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.taxaPercentual = :taxaPercentual"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByTaxaReal", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.taxaReal = :taxaReal"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByTaxaFormaPagamento", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.taxaFormaPagamento = :taxaFormaPagamento"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByTaxaOperacao", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.taxaOperacao = :taxaOperacao"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByCodigo", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByCodigoLiberacao", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.codigoLiberacao = :codigoLiberacao"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByDataAprovacao", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.dataAprovacao = :dataAprovacao"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByDataCancelamento", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.dataCancelamento = :dataCancelamento"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByDataLiberacao", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.dataLiberacao = :dataLiberacao"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByDataPagamento", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.dataPagamento = :dataPagamento"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByDataReprovacao", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.dataReprovacao = :dataReprovacao"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByDataVencimento", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByCartaoPayPlug", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.cartaoPayPlug = :cartaoPayPlug"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByCodigoContrato", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.codigoContrato = :codigoContrato"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByFormaPagamento", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.formaPagamento = :formaPagamento"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByUsuarioLogado", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.usuarioLogado = :usuarioLogado"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByCamaraComercio", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.camaraComercio = :camaraComercio"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByJustificativaCancelamento", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.justificativaCancelamento = :justificativaCancelamento"),
    @NamedQuery(name = "VwRELATORIOTRANSACOESEXCEL.findByJustificativaReprovacao", query = "SELECT v FROM VwRELATORIOTRANSACOESEXCEL v WHERE v.justificativaReprovacao = :justificativaReprovacao")})
public class VwRELATORIOTRANSACOESEXCEL implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Lancamento")
    @Id
    private int lancamento;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TransacaoId")
    private int transacaoId;
    
    @Column(name = "TransacaoPaiId")
    private Integer transacaoPaiId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Conta")
    private String conta;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "Descricao")
    private String descricao;
    
    @Size(max = 10)
    @Column(name = "Data")
    private String data;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ContaMae")
    private String contaMae;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorReal")
    private BigDecimal valorReal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorMoedaUsuario")
    private BigDecimal valorMoedaUsuario;
    
    @Column(name = "SaldoMoedaUsuario")
    private BigDecimal saldoMoedaUsuario;
    
    @Column(name = "SaldoRealUsuario")
    private BigDecimal saldoRealUsuario;
    
    @Column(name = "TaxaCambio")
    private BigDecimal taxaCambio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Status")
    private String status;
    
    @Size(max = 50)
    @Column(name = "Taxa")
    private String taxa;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "OrigemPaga")
    private String origemPaga;
    
    @Column(name = "TaxaPercentual")
    private BigDecimal taxaPercentual;
    
    @Column(name = "TaxaReal")
    private BigDecimal taxaReal;
    
    @Size(max = 200)
    @Column(name = "TaxaFormaPagamento")
    private String taxaFormaPagamento;
    
    @Size(max = 50)
    @Column(name = "TaxaOperacao")
    private String taxaOperacao;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Codigo")
    private String codigo;
    
    @Size(max = 20)
    @Column(name = "CodigoLiberacao")
    private String codigoLiberacao;
    
    @Size(max = 10)
    @Column(name = "DataAprovacao")
    private String dataAprovacao;
    
    @Size(max = 10)
    @Column(name = "DataCancelamento")
    private String dataCancelamento;
    
    @Size(max = 10)
    @Column(name = "DataLiberacao")
    private String dataLiberacao;
    
    @Size(max = 10)
    @Column(name = "DataPagamento")
    private String dataPagamento;
    
    @Size(max = 10)
    @Column(name = "DataReprovacao")
    private String dataReprovacao;
    
    @Size(max = 10)
    @Column(name = "DataVencimento")
    private String dataVencimento;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CartaoPayPlug")
    private String cartaoPayPlug;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoContrato")
    private int codigoContrato;
    
    @Size(max = 200)
    @Column(name = "FormaPagamento")
    private String formaPagamento;
    
    @Size(max = 200)
    @Column(name = "UsuarioLogado")
    private String usuarioLogado;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CamaraComercio")
    private String camaraComercio;
    
    @Size(max = 2147483647)
    @Column(name = "JustificativaCancelamento")
    private String justificativaCancelamento;
    
    @Size(max = 2147483647)
    @Column(name = "JustificativaReprovacao")
    private String justificativaReprovacao;

    public VwRELATORIOTRANSACOESEXCEL() {
    }

    public int getLancamento() {
        return lancamento;
    }

    public void setLancamento(int lancamento) {
        this.lancamento = lancamento;
    }

    public int getTransacaoId() {
        return transacaoId;
    }

    public void setTransacaoId(int transacaoId) {
        this.transacaoId = transacaoId;
    }

    public Integer getTransacaoPaiId() {
        return transacaoPaiId;
    }

    public void setTransacaoPaiId(Integer transacaoPaiId) {
        this.transacaoPaiId = transacaoPaiId;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getContaMae() {
        return contaMae;
    }

    public void setContaMae(String contaMae) {
        this.contaMae = contaMae;
    }

    public BigDecimal getValorReal() {
        return valorReal;
    }

    public void setValorReal(BigDecimal valorReal) {
        this.valorReal = valorReal;
    }

    public BigDecimal getValorMoedaUsuario() {
        return valorMoedaUsuario;
    }

    public void setValorMoedaUsuario(BigDecimal valorMoedaUsuario) {
        this.valorMoedaUsuario = valorMoedaUsuario;
    }

    public BigDecimal getSaldoMoedaUsuario() {
        return saldoMoedaUsuario;
    }

    public void setSaldoMoedaUsuario(BigDecimal saldoMoedaUsuario) {
        this.saldoMoedaUsuario = saldoMoedaUsuario;
    }

    public BigDecimal getSaldoRealUsuario() {
        return saldoRealUsuario;
    }

    public void setSaldoRealUsuario(BigDecimal saldoRealUsuario) {
        this.saldoRealUsuario = saldoRealUsuario;
    }

    public BigDecimal getTaxaCambio() {
        return taxaCambio;
    }

    public void setTaxaCambio(BigDecimal taxaCambio) {
        this.taxaCambio = taxaCambio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    public String getOrigemPaga() {
        return origemPaga;
    }

    public void setOrigemPaga(String origemPaga) {
        this.origemPaga = origemPaga;
    }

    public BigDecimal getTaxaPercentual() {
        return taxaPercentual;
    }

    public void setTaxaPercentual(BigDecimal taxaPercentual) {
        this.taxaPercentual = taxaPercentual;
    }

    public BigDecimal getTaxaReal() {
        return taxaReal;
    }

    public void setTaxaReal(BigDecimal taxaReal) {
        this.taxaReal = taxaReal;
    }

    public String getTaxaFormaPagamento() {
        return taxaFormaPagamento;
    }

    public void setTaxaFormaPagamento(String taxaFormaPagamento) {
        this.taxaFormaPagamento = taxaFormaPagamento;
    }

    public String getTaxaOperacao() {
        return taxaOperacao;
    }

    public void setTaxaOperacao(String taxaOperacao) {
        this.taxaOperacao = taxaOperacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoLiberacao() {
        return codigoLiberacao;
    }

    public void setCodigoLiberacao(String codigoLiberacao) {
        this.codigoLiberacao = codigoLiberacao;
    }

    public String getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(String dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public String getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(String dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public String getDataLiberacao() {
        return dataLiberacao;
    }

    public void setDataLiberacao(String dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getDataReprovacao() {
        return dataReprovacao;
    }

    public void setDataReprovacao(String dataReprovacao) {
        this.dataReprovacao = dataReprovacao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCartaoPayPlug() {
        return cartaoPayPlug;
    }

    public void setCartaoPayPlug(String cartaoPayPlug) {
        this.cartaoPayPlug = cartaoPayPlug;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String getCamaraComercio() {
        return camaraComercio;
    }

    public void setCamaraComercio(String camaraComercio) {
        this.camaraComercio = camaraComercio;
    }

    public String getJustificativaCancelamento() {
        return justificativaCancelamento;
    }

    public void setJustificativaCancelamento(String justificativaCancelamento) {
        this.justificativaCancelamento = justificativaCancelamento;
    }

    public String getJustificativaReprovacao() {
        return justificativaReprovacao;
    }

    public void setJustificativaReprovacao(String justificativaReprovacao) {
        this.justificativaReprovacao = justificativaReprovacao;
    }
    
}
