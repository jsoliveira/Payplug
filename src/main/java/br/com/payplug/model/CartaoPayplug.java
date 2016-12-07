/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "cartao_payplug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartaoPayplug.findAll", query = "SELECT c FROM CartaoPayplug c"),
    @NamedQuery(name = "CartaoPayplug.findById", query = "SELECT c FROM CartaoPayplug c WHERE c.id = :id"),
    @NamedQuery(name = "CartaoPayplug.findByNumero", query = "SELECT c FROM CartaoPayplug c WHERE c.numero = :numero"),
    @NamedQuery(name = "CartaoPayplug.findBySaldoTotal", query = "SELECT c FROM CartaoPayplug c WHERE c.saldoTotal = :saldoTotal"),
    @NamedQuery(name = "CartaoPayplug.findBySaldoDisponivelSaque", query = "SELECT c FROM CartaoPayplug c WHERE c.saldoDisponivelSaque = :saldoDisponivelSaque"),
    @NamedQuery(name = "CartaoPayplug.findByIdTipoCartao", query = "SELECT c FROM CartaoPayplug c WHERE c.idTipoCartao = :idTipoCartao"),
    @NamedQuery(name = "CartaoPayplug.findByDataValidade", query = "SELECT c FROM CartaoPayplug c WHERE c.dataValidade = :dataValidade"),
    @NamedQuery(name = "CartaoPayplug.findByDataCadastro", query = "SELECT c FROM CartaoPayplug c WHERE c.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "CartaoPayplug.findByGeracaoFisicaStatus", query = "SELECT c FROM CartaoPayplug c WHERE c.geracaoFisicaStatus = :geracaoFisicaStatus"),
    @NamedQuery(name = "CartaoPayplug.findByGeracaoFisicaEnvioGrafica", query = "SELECT c FROM CartaoPayplug c WHERE c.geracaoFisicaEnvioGrafica = :geracaoFisicaEnvioGrafica"),
    @NamedQuery(name = "CartaoPayplug.findByGeracaoFisicaConclusao", query = "SELECT c FROM CartaoPayplug c WHERE c.geracaoFisicaConclusao = :geracaoFisicaConclusao"),
    @NamedQuery(name = "CartaoPayplug.findByStatusCartao", query = "SELECT c FROM CartaoPayplug c WHERE c.statusCartao = :statusCartao"),
    @NamedQuery(name = "CartaoPayplug.findByStatusCartaoDataAlteracao", query = "SELECT c FROM CartaoPayplug c WHERE c.statusCartaoDataAlteracao = :statusCartaoDataAlteracao")})
public class CartaoPayplug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero")
    private BigInteger numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo_total")
    private BigDecimal saldoTotal;
    @Column(name = "saldo_disponivel_saque")
    private BigDecimal saldoDisponivelSaque;
    @Column(name = "id_tipo_cartao")
    private Integer idTipoCartao;
    @Column(name = "data_validade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataValidade;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "geracao_fisica_status")
    private Integer geracaoFisicaStatus;
    @Column(name = "geracao_fisica_envio_grafica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date geracaoFisicaEnvioGrafica;
    @Column(name = "geracao_fisica_conclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date geracaoFisicaConclusao;
    @Column(name = "status_cartao")
    private Integer statusCartao;
    @Column(name = "status_cartao_data_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusCartaoDataAlteracao;
    @OneToMany(mappedBy = "idCartaoPayplug")
    private List<Transacoes> transacoesList;
    @JoinColumn(name = "id_usuario_solicitante", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarioSolicitante;
    @JoinColumn(name = "id_usuario_dono", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarioDono;

    public CartaoPayplug() {
    }

    public CartaoPayplug(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(BigDecimal saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public BigDecimal getSaldoDisponivelSaque() {
        return saldoDisponivelSaque;
    }

    public void setSaldoDisponivelSaque(BigDecimal saldoDisponivelSaque) {
        this.saldoDisponivelSaque = saldoDisponivelSaque;
    }

    public Integer getIdTipoCartao() {
        return idTipoCartao;
    }

    public void setIdTipoCartao(Integer idTipoCartao) {
        this.idTipoCartao = idTipoCartao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getGeracaoFisicaStatus() {
        return geracaoFisicaStatus;
    }

    public void setGeracaoFisicaStatus(Integer geracaoFisicaStatus) {
        this.geracaoFisicaStatus = geracaoFisicaStatus;
    }

    public Date getGeracaoFisicaEnvioGrafica() {
        return geracaoFisicaEnvioGrafica;
    }

    public void setGeracaoFisicaEnvioGrafica(Date geracaoFisicaEnvioGrafica) {
        this.geracaoFisicaEnvioGrafica = geracaoFisicaEnvioGrafica;
    }

    public Date getGeracaoFisicaConclusao() {
        return geracaoFisicaConclusao;
    }

    public void setGeracaoFisicaConclusao(Date geracaoFisicaConclusao) {
        this.geracaoFisicaConclusao = geracaoFisicaConclusao;
    }

    public Integer getStatusCartao() {
        return statusCartao;
    }

    public void setStatusCartao(Integer statusCartao) {
        this.statusCartao = statusCartao;
    }

    public Date getStatusCartaoDataAlteracao() {
        return statusCartaoDataAlteracao;
    }

    public void setStatusCartaoDataAlteracao(Date statusCartaoDataAlteracao) {
        this.statusCartaoDataAlteracao = statusCartaoDataAlteracao;
    }

    @XmlTransient
    public List<Transacoes> getTransacoesList() {
        return transacoesList;
    }

    public void setTransacoesList(List<Transacoes> transacoesList) {
        this.transacoesList = transacoesList;
    }

    public Usuarios getIdUsuarioSolicitante() {
        return idUsuarioSolicitante;
    }

    public void setIdUsuarioSolicitante(Usuarios idUsuarioSolicitante) {
        this.idUsuarioSolicitante = idUsuarioSolicitante;
    }

    public Usuarios getIdUsuarioDono() {
        return idUsuarioDono;
    }

    public void setIdUsuarioDono(Usuarios idUsuarioDono) {
        this.idUsuarioDono = idUsuarioDono;
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
        if (!(object instanceof CartaoPayplug)) {
            return false;
        }
        CartaoPayplug other = (CartaoPayplug) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.CartaoPayplug[ id=" + id + " ]";
    }
    
}
