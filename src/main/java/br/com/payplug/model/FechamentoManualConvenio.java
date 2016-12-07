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
@Table(name = "fechamento_manual_convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechamentoManualConvenio.findAll", query = "SELECT f FROM FechamentoManualConvenio f"),
    @NamedQuery(name = "FechamentoManualConvenio.findById", query = "SELECT f FROM FechamentoManualConvenio f WHERE f.id = :id"),
    @NamedQuery(name = "FechamentoManualConvenio.findByIdTransacaoCobranca", query = "SELECT f FROM FechamentoManualConvenio f WHERE f.idTransacaoCobranca = :idTransacaoCobranca"),
    @NamedQuery(name = "FechamentoManualConvenio.findByDataVencimento", query = "SELECT f FROM FechamentoManualConvenio f WHERE f.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "FechamentoManualConvenio.findByValor", query = "SELECT f FROM FechamentoManualConvenio f WHERE f.valor = :valor"),
    @NamedQuery(name = "FechamentoManualConvenio.findByDataInicioFechamento", query = "SELECT f FROM FechamentoManualConvenio f WHERE f.dataInicioFechamento = :dataInicioFechamento"),
    @NamedQuery(name = "FechamentoManualConvenio.findByDataFimFechamento", query = "SELECT f FROM FechamentoManualConvenio f WHERE f.dataFimFechamento = :dataFimFechamento"),
    @NamedQuery(name = "FechamentoManualConvenio.findByIdUsuarioParceiro", query = "SELECT f FROM FechamentoManualConvenio f WHERE f.idUsuarioParceiro = :idUsuarioParceiro")})
public class FechamentoManualConvenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_transacao_cobranca")
    private Integer idTransacaoCobranca;
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inicio_fechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicioFechamento;
    @Column(name = "data_fim_fechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFimFechamento;
    @Column(name = "id_usuario_parceiro")
    private Integer idUsuarioParceiro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFechamentoManualConvenio")
    private List<FechamentoManualResgateCreditoConvenio> fechamentoManualResgateCreditoConvenioList;

    public FechamentoManualConvenio() {
    }

    public FechamentoManualConvenio(Integer id) {
        this.id = id;
    }

    public FechamentoManualConvenio(Integer id, Date dataInicioFechamento) {
        this.id = id;
        this.dataInicioFechamento = dataInicioFechamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTransacaoCobranca() {
        return idTransacaoCobranca;
    }

    public void setIdTransacaoCobranca(Integer idTransacaoCobranca) {
        this.idTransacaoCobranca = idTransacaoCobranca;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataInicioFechamento() {
        return dataInicioFechamento;
    }

    public void setDataInicioFechamento(Date dataInicioFechamento) {
        this.dataInicioFechamento = dataInicioFechamento;
    }

    public Date getDataFimFechamento() {
        return dataFimFechamento;
    }

    public void setDataFimFechamento(Date dataFimFechamento) {
        this.dataFimFechamento = dataFimFechamento;
    }

    public Integer getIdUsuarioParceiro() {
        return idUsuarioParceiro;
    }

    public void setIdUsuarioParceiro(Integer idUsuarioParceiro) {
        this.idUsuarioParceiro = idUsuarioParceiro;
    }

    @XmlTransient
    public List<FechamentoManualResgateCreditoConvenio> getFechamentoManualResgateCreditoConvenioList() {
        return fechamentoManualResgateCreditoConvenioList;
    }

    public void setFechamentoManualResgateCreditoConvenioList(List<FechamentoManualResgateCreditoConvenio> fechamentoManualResgateCreditoConvenioList) {
        this.fechamentoManualResgateCreditoConvenioList = fechamentoManualResgateCreditoConvenioList;
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
        if (!(object instanceof FechamentoManualConvenio)) {
            return false;
        }
        FechamentoManualConvenio other = (FechamentoManualConvenio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.FechamentoManualConvenio[ id=" + id + " ]";
    }
    
}
