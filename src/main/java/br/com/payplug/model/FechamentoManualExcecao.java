/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "fechamento_manual_excecao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechamentoManualExcecao.findAll", query = "SELECT f FROM FechamentoManualExcecao f"),
    @NamedQuery(name = "FechamentoManualExcecao.findById", query = "SELECT f FROM FechamentoManualExcecao f WHERE f.id = :id"),
    @NamedQuery(name = "FechamentoManualExcecao.findByIdTransacao", query = "SELECT f FROM FechamentoManualExcecao f WHERE f.idTransacao = :idTransacao"),
    @NamedQuery(name = "FechamentoManualExcecao.findByIdTipoExcecao", query = "SELECT f FROM FechamentoManualExcecao f WHERE f.idTipoExcecao = :idTipoExcecao"),
    @NamedQuery(name = "FechamentoManualExcecao.findByDataCadastro", query = "SELECT f FROM FechamentoManualExcecao f WHERE f.dataCadastro = :dataCadastro")})
public class FechamentoManualExcecao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_transacao")
    private int idTransacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_excecao")
    private int idTipoExcecao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    public FechamentoManualExcecao() {
    }

    public FechamentoManualExcecao(Integer id) {
        this.id = id;
    }

    public FechamentoManualExcecao(Integer id, int idTransacao, int idTipoExcecao, Date dataCadastro) {
        this.id = id;
        this.idTransacao = idTransacao;
        this.idTipoExcecao = idTipoExcecao;
        this.dataCadastro = dataCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public int getIdTipoExcecao() {
        return idTipoExcecao;
    }

    public void setIdTipoExcecao(int idTipoExcecao) {
        this.idTipoExcecao = idTipoExcecao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
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
        if (!(object instanceof FechamentoManualExcecao)) {
            return false;
        }
        FechamentoManualExcecao other = (FechamentoManualExcecao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.FechamentoManualExcecao[ id=" + id + " ]";
    }
    
}
