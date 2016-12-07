/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
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
@Table(name = "transacoes_debito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransacoesDebito.findAll", query = "SELECT t FROM TransacoesDebito t"),
    @NamedQuery(name = "TransacoesDebito.findById", query = "SELECT t FROM TransacoesDebito t WHERE t.id = :id"),
    @NamedQuery(name = "TransacoesDebito.findByCodigo", query = "SELECT t FROM TransacoesDebito t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TransacoesDebito.findByIdOperacao", query = "SELECT t FROM TransacoesDebito t WHERE t.idOperacao = :idOperacao"),
    @NamedQuery(name = "TransacoesDebito.findByTidOperacao", query = "SELECT t FROM TransacoesDebito t WHERE t.tidOperacao = :tidOperacao")})
public class TransacoesDebito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_operacao")
    private String idOperacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tid_operacao")
    private String tidOperacao;

    public TransacoesDebito() {
    }

    public TransacoesDebito(Integer id) {
        this.id = id;
    }

    public TransacoesDebito(Integer id, String codigo, String idOperacao, String tidOperacao) {
        this.id = id;
        this.codigo = codigo;
        this.idOperacao = idOperacao;
        this.tidOperacao = tidOperacao;
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

    public String getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(String idOperacao) {
        this.idOperacao = idOperacao;
    }

    public String getTidOperacao() {
        return tidOperacao;
    }

    public void setTidOperacao(String tidOperacao) {
        this.tidOperacao = tidOperacao;
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
        if (!(object instanceof TransacoesDebito)) {
            return false;
        }
        TransacoesDebito other = (TransacoesDebito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.TransacoesDebito[ id=" + id + " ]";
    }
    
}
