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
@Table(name = "fechamento_manual_resgate_credito_convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechamentoManualResgateCreditoConvenio.findAll", query = "SELECT f FROM FechamentoManualResgateCreditoConvenio f"),
    @NamedQuery(name = "FechamentoManualResgateCreditoConvenio.findById", query = "SELECT f FROM FechamentoManualResgateCreditoConvenio f WHERE f.id = :id"),
    @NamedQuery(name = "FechamentoManualResgateCreditoConvenio.findByIdTransacaoFechamento", query = "SELECT f FROM FechamentoManualResgateCreditoConvenio f WHERE f.idTransacaoFechamento = :idTransacaoFechamento"),
    @NamedQuery(name = "FechamentoManualResgateCreditoConvenio.findByIdTransacaoResgate", query = "SELECT f FROM FechamentoManualResgateCreditoConvenio f WHERE f.idTransacaoResgate = :idTransacaoResgate"),
    @NamedQuery(name = "FechamentoManualResgateCreditoConvenio.findByIdUsuarioFuncionario", query = "SELECT f FROM FechamentoManualResgateCreditoConvenio f WHERE f.idUsuarioFuncionario = :idUsuarioFuncionario"),
    @NamedQuery(name = "FechamentoManualResgateCreditoConvenio.findByCreditoRecebido", query = "SELECT f FROM FechamentoManualResgateCreditoConvenio f WHERE f.creditoRecebido = :creditoRecebido"),
    @NamedQuery(name = "FechamentoManualResgateCreditoConvenio.findByValorResgatado", query = "SELECT f FROM FechamentoManualResgateCreditoConvenio f WHERE f.valorResgatado = :valorResgatado"),
    @NamedQuery(name = "FechamentoManualResgateCreditoConvenio.findByDataCadastro", query = "SELECT f FROM FechamentoManualResgateCreditoConvenio f WHERE f.dataCadastro = :dataCadastro")})
public class FechamentoManualResgateCreditoConvenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_transacao_fechamento")
    private int idTransacaoFechamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_transacao_resgate")
    private int idTransacaoResgate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_funcionario")
    private int idUsuarioFuncionario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "credito_recebido")
    private BigDecimal creditoRecebido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_resgatado")
    private BigDecimal valorResgatado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @JoinColumn(name = "id_fechamento_manual_convenio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FechamentoManualConvenio idFechamentoManualConvenio;

    public FechamentoManualResgateCreditoConvenio() {
    }

    public FechamentoManualResgateCreditoConvenio(Integer id) {
        this.id = id;
    }

    public FechamentoManualResgateCreditoConvenio(Integer id, int idTransacaoFechamento, int idTransacaoResgate, int idUsuarioFuncionario, BigDecimal creditoRecebido, BigDecimal valorResgatado, Date dataCadastro) {
        this.id = id;
        this.idTransacaoFechamento = idTransacaoFechamento;
        this.idTransacaoResgate = idTransacaoResgate;
        this.idUsuarioFuncionario = idUsuarioFuncionario;
        this.creditoRecebido = creditoRecebido;
        this.valorResgatado = valorResgatado;
        this.dataCadastro = dataCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdTransacaoFechamento() {
        return idTransacaoFechamento;
    }

    public void setIdTransacaoFechamento(int idTransacaoFechamento) {
        this.idTransacaoFechamento = idTransacaoFechamento;
    }

    public int getIdTransacaoResgate() {
        return idTransacaoResgate;
    }

    public void setIdTransacaoResgate(int idTransacaoResgate) {
        this.idTransacaoResgate = idTransacaoResgate;
    }

    public int getIdUsuarioFuncionario() {
        return idUsuarioFuncionario;
    }

    public void setIdUsuarioFuncionario(int idUsuarioFuncionario) {
        this.idUsuarioFuncionario = idUsuarioFuncionario;
    }

    public BigDecimal getCreditoRecebido() {
        return creditoRecebido;
    }

    public void setCreditoRecebido(BigDecimal creditoRecebido) {
        this.creditoRecebido = creditoRecebido;
    }

    public BigDecimal getValorResgatado() {
        return valorResgatado;
    }

    public void setValorResgatado(BigDecimal valorResgatado) {
        this.valorResgatado = valorResgatado;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public FechamentoManualConvenio getIdFechamentoManualConvenio() {
        return idFechamentoManualConvenio;
    }

    public void setIdFechamentoManualConvenio(FechamentoManualConvenio idFechamentoManualConvenio) {
        this.idFechamentoManualConvenio = idFechamentoManualConvenio;
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
        if (!(object instanceof FechamentoManualResgateCreditoConvenio)) {
            return false;
        }
        FechamentoManualResgateCreditoConvenio other = (FechamentoManualResgateCreditoConvenio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.FechamentoManualResgateCreditoConvenio[ id=" + id + " ]";
    }
    
}
