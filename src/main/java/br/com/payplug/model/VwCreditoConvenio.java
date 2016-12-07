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
@Table(name = "vw_credito_convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwCreditoConvenio.findAll", query = "SELECT v FROM VwCreditoConvenio v"),
    @NamedQuery(name = "VwCreditoConvenio.findById", query = "SELECT v FROM VwCreditoConvenio v WHERE v.id = :id"),
    @NamedQuery(name = "VwCreditoConvenio.findByIdTransacaoCorrespondente", query = "SELECT v FROM VwCreditoConvenio v WHERE v.idTransacaoCorrespondente = :idTransacaoCorrespondente"),
    @NamedQuery(name = "VwCreditoConvenio.findByIdOperacao", query = "SELECT v FROM VwCreditoConvenio v WHERE v.idOperacao = :idOperacao"),
    @NamedQuery(name = "VwCreditoConvenio.findByIdOperacaoTaxa", query = "SELECT v FROM VwCreditoConvenio v WHERE v.idOperacaoTaxa = :idOperacaoTaxa"),
    @NamedQuery(name = "VwCreditoConvenio.findByDataTransacao", query = "SELECT v FROM VwCreditoConvenio v WHERE v.dataTransacao = :dataTransacao"),
    @NamedQuery(name = "VwCreditoConvenio.findByVencimento", query = "SELECT v FROM VwCreditoConvenio v WHERE v.vencimento = :vencimento"),
    @NamedQuery(name = "VwCreditoConvenio.findByOperacao", query = "SELECT v FROM VwCreditoConvenio v WHERE v.operacao = :operacao"),
    @NamedQuery(name = "VwCreditoConvenio.findByDescricao", query = "SELECT v FROM VwCreditoConvenio v WHERE v.descricao = :descricao"),
    @NamedQuery(name = "VwCreditoConvenio.findByIdOrigemDestino", query = "SELECT v FROM VwCreditoConvenio v WHERE v.idOrigemDestino = :idOrigemDestino"),
    @NamedQuery(name = "VwCreditoConvenio.findByNomeOrigemDestino", query = "SELECT v FROM VwCreditoConvenio v WHERE v.nomeOrigemDestino = :nomeOrigemDestino"),
    @NamedQuery(name = "VwCreditoConvenio.findByValorMoedaUsuario", query = "SELECT v FROM VwCreditoConvenio v WHERE v.valorMoedaUsuario = :valorMoedaUsuario")})
public class VwCreditoConvenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "id_transacao_correspondente")
    private Integer idTransacaoCorrespondente;
    @Column(name = "id_operacao")
    private Integer idOperacao;
    @Column(name = "id_operacao_taxa")
    private Integer idOperacaoTaxa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_transacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTransacao;
    @Column(name = "vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vencimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "operacao")
    private String operacao;
    @Size(max = 8000)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_origem_destino")
    private int idOrigemDestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome_origem_destino")
    private String nomeOrigemDestino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_moeda_usuario")
    private BigDecimal valorMoedaUsuario;

    public VwCreditoConvenio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdTransacaoCorrespondente() {
        return idTransacaoCorrespondente;
    }

    public void setIdTransacaoCorrespondente(Integer idTransacaoCorrespondente) {
        this.idTransacaoCorrespondente = idTransacaoCorrespondente;
    }

    public Integer getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(Integer idOperacao) {
        this.idOperacao = idOperacao;
    }

    public Integer getIdOperacaoTaxa() {
        return idOperacaoTaxa;
    }

    public void setIdOperacaoTaxa(Integer idOperacaoTaxa) {
        this.idOperacaoTaxa = idOperacaoTaxa;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdOrigemDestino() {
        return idOrigemDestino;
    }

    public void setIdOrigemDestino(int idOrigemDestino) {
        this.idOrigemDestino = idOrigemDestino;
    }

    public String getNomeOrigemDestino() {
        return nomeOrigemDestino;
    }

    public void setNomeOrigemDestino(String nomeOrigemDestino) {
        this.nomeOrigemDestino = nomeOrigemDestino;
    }

    public BigDecimal getValorMoedaUsuario() {
        return valorMoedaUsuario;
    }

    public void setValorMoedaUsuario(BigDecimal valorMoedaUsuario) {
        this.valorMoedaUsuario = valorMoedaUsuario;
    }
    
}
