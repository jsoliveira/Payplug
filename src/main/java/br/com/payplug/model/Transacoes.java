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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "transacoes")
@XmlRootElement
public class Transacoes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "codigo")
    private String codigo;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_moeda_usuario")
    private BigDecimal valorMoedaUsuario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_em_real")
    private BigDecimal valorEmReal;

    @Column(name = "taxa_cambio")
    private BigDecimal taxaCambio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_transacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTransacao;

    @Column(name = "data_liberacao_saque")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLiberacaoSaque;

    @Column(name = "data_cancelamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCancelamento;

    @Size(max = 2147483647)
    @Column(name = "justificativa_cancelamento")
    private String justificativaCancelamento;

    @Column(name = "data_aprovacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAprovacao;

    @Column(name = "data_reprovacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataReprovacao;

    @Size(max = 2147483647)
    @Column(name = "justificativa_reprovacao")
    private String justificativaReprovacao;

    @Size(max = 2000)
    @Column(name = "descricao")
    private String descricao;

    @Size(max = 20)
    @Column(name = "codigo_liberacao")
    private String codigoLiberacao;

    @Column(name = "data_pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPagamento;

    @Column(name = "data_vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;

    @Column(name = "saldo_moeda_usuario")
    private BigDecimal saldoMoedaUsuario;

    @Column(name = "saldo_real_usuario")
    private BigDecimal saldoRealUsuario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_logado")
    private int idUsuarioLogado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contrato")
    private int idContrato;

    @Basic(optional = false)
    @NotNull
    @Column(name = "is_camara")
    private boolean isCamara;

    @Column(name = "id_tipo_isencao_taxa")
    private Integer idTipoIsencaoTaxa;

    @JoinColumn(name = "id_cartao_payplug", referencedColumnName = "id")
    @ManyToOne
    private CartaoPayplug idCartaoPayplug;

    @JoinColumn(name = "id_forma_pagamento", referencedColumnName = "id")
    @ManyToOne
    private FormasPagamentos idFormaPagamento;

    @JoinColumn(name = "id_moeda_usuario", referencedColumnName = "id")
    @ManyToOne
    private Moedas idMoedaUsuario;

    @JoinColumn(name = "id_operacao", referencedColumnName = "id")
    @ManyToOne
    private Operacoes idOperacao;

    @JoinColumn(name = "id_operacao_taxa", referencedColumnName = "id")
    @ManyToOne
    private OperacoesTaxas idOperacaoTaxa;

    @OneToMany(mappedBy = "idPai")
    private List<Transacoes> transacoesList;

    @JoinColumn(name = "id_pai", referencedColumnName = "id")
    @ManyToOne
    private Transacoes idPai;

    @OneToMany(mappedBy = "idTransacaoCorrespondente")
    private List<Transacoes> transacoesList1;

    @JoinColumn(name = "id_transacao_correspondente", referencedColumnName = "id")
    @ManyToOne
    private Transacoes idTransacaoCorrespondente;

    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    @ManyToOne
    private TransacoesEstados idEstado;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTransacao")
    private List<Boletos> boletosList;

    public Transacoes() {
    }

    public Transacoes(Integer id) {
        this.id = id;
    }

    public Transacoes(Integer id, String codigo, BigDecimal valorMoedaUsuario, BigDecimal valorEmReal, Date dataTransacao, int removido, int idUsuarioLogado, int idContrato, boolean isCamara) {
        this.id = id;
        this.codigo = codigo;
        this.valorMoedaUsuario = valorMoedaUsuario;
        this.valorEmReal = valorEmReal;
        this.dataTransacao = dataTransacao;
        this.removido = removido;
        this.idUsuarioLogado = idUsuarioLogado;
        this.idContrato = idContrato;
        this.isCamara = isCamara;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValorMoedaUsuario() {
        return valorMoedaUsuario;
    }

    public void setValorMoedaUsuario(BigDecimal valorMoedaUsuario) {
        this.valorMoedaUsuario = valorMoedaUsuario;
    }

    public BigDecimal getValorEmReal() {
        return valorEmReal;
    }

    public void setValorEmReal(BigDecimal valorEmReal) {
        this.valorEmReal = valorEmReal;
    }

    public BigDecimal getTaxaCambio() {
        return taxaCambio;
    }

    public void setTaxaCambio(BigDecimal taxaCambio) {
        this.taxaCambio = taxaCambio;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Date getDataLiberacaoSaque() {
        return dataLiberacaoSaque;
    }

    public void setDataLiberacaoSaque(Date dataLiberacaoSaque) {
        this.dataLiberacaoSaque = dataLiberacaoSaque;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public String getJustificativaCancelamento() {
        return justificativaCancelamento;
    }

    public void setJustificativaCancelamento(String justificativaCancelamento) {
        this.justificativaCancelamento = justificativaCancelamento;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public Date getDataReprovacao() {
        return dataReprovacao;
    }

    public void setDataReprovacao(Date dataReprovacao) {
        this.dataReprovacao = dataReprovacao;
    }

    public String getJustificativaReprovacao() {
        return justificativaReprovacao;
    }

    public void setJustificativaReprovacao(String justificativaReprovacao) {
        this.justificativaReprovacao = justificativaReprovacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoLiberacao() {
        return codigoLiberacao;
    }

    public void setCodigoLiberacao(String codigoLiberacao) {
        this.codigoLiberacao = codigoLiberacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
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

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public int getIdUsuarioLogado() {
        return idUsuarioLogado;
    }

    public void setIdUsuarioLogado(int idUsuarioLogado) {
        this.idUsuarioLogado = idUsuarioLogado;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public boolean getIsCamara() {
        return isCamara;
    }

    public void setIsCamara(boolean isCamara) {
        this.isCamara = isCamara;
    }

    public Integer getIdTipoIsencaoTaxa() {
        return idTipoIsencaoTaxa;
    }

    public void setIdTipoIsencaoTaxa(Integer idTipoIsencaoTaxa) {
        this.idTipoIsencaoTaxa = idTipoIsencaoTaxa;
    }

    public CartaoPayplug getIdCartaoPayplug() {
        return idCartaoPayplug;
    }

    public void setIdCartaoPayplug(CartaoPayplug idCartaoPayplug) {
        this.idCartaoPayplug = idCartaoPayplug;
    }

    public FormasPagamentos getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(FormasPagamentos idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public Moedas getIdMoedaUsuario() {
        return idMoedaUsuario;
    }

    public void setIdMoedaUsuario(Moedas idMoedaUsuario) {
        this.idMoedaUsuario = idMoedaUsuario;
    }

    public Operacoes getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(Operacoes idOperacao) {
        this.idOperacao = idOperacao;
    }

    public OperacoesTaxas getIdOperacaoTaxa() {
        return idOperacaoTaxa;
    }

    public void setIdOperacaoTaxa(OperacoesTaxas idOperacaoTaxa) {
        this.idOperacaoTaxa = idOperacaoTaxa;
    }

    @XmlTransient
    public List<Transacoes> getTransacoesList() {
        return transacoesList;
    }

    public void setTransacoesList(List<Transacoes> transacoesList) {
        this.transacoesList = transacoesList;
    }

    public Transacoes getIdPai() {
        return idPai;
    }

    public void setIdPai(Transacoes idPai) {
        this.idPai = idPai;
    }

    @XmlTransient
    public List<Transacoes> getTransacoesList1() {
        return transacoesList1;
    }

    public void setTransacoesList1(List<Transacoes> transacoesList1) {
        this.transacoesList1 = transacoesList1;
    }

    public Transacoes getIdTransacaoCorrespondente() {
        return idTransacaoCorrespondente;
    }

    public void setIdTransacaoCorrespondente(Transacoes idTransacaoCorrespondente) {
        this.idTransacaoCorrespondente = idTransacaoCorrespondente;
    }

    public TransacoesEstados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TransacoesEstados idEstado) {
        this.idEstado = idEstado;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Boletos> getBoletosList() {
        return boletosList;
    }

    public void setBoletosList(List<Boletos> boletosList) {
        this.boletosList = boletosList;
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
        if (!(object instanceof Transacoes)) {
            return false;
        }
        Transacoes other = (Transacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Transacoes[ id=" + id + " ]";
    }
    
}
