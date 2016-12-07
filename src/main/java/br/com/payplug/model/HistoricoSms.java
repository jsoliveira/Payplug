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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "historico_sms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoSms.findAll", query = "SELECT h FROM HistoricoSms h"),
    @NamedQuery(name = "HistoricoSms.findById", query = "SELECT h FROM HistoricoSms h WHERE h.id = :id"),
    @NamedQuery(name = "HistoricoSms.findByTexto", query = "SELECT h FROM HistoricoSms h WHERE h.texto = :texto"),
    @NamedQuery(name = "HistoricoSms.findByDestinatario", query = "SELECT h FROM HistoricoSms h WHERE h.destinatario = :destinatario"),
    @NamedQuery(name = "HistoricoSms.findByEnviado", query = "SELECT h FROM HistoricoSms h WHERE h.enviado = :enviado"),
    @NamedQuery(name = "HistoricoSms.findByDataInsercao", query = "SELECT h FROM HistoricoSms h WHERE h.dataInsercao = :dataInsercao"),
    @NamedQuery(name = "HistoricoSms.findByDataEnvio", query = "SELECT h FROM HistoricoSms h WHERE h.dataEnvio = :dataEnvio"),
    @NamedQuery(name = "HistoricoSms.findByErro", query = "SELECT h FROM HistoricoSms h WHERE h.erro = :erro")})
public class HistoricoSms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 160)
    @Column(name = "texto")
    private String texto;
    @Size(max = 15)
    @Column(name = "destinatario")
    private String destinatario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enviado")
    private boolean enviado;
    @Column(name = "data_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInsercao;
    @Column(name = "data_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvio;
    @Size(max = 2147483647)
    @Column(name = "erro")
    private String erro;

    public HistoricoSms() {
    }

    public HistoricoSms(Integer id) {
        this.id = id;
    }

    public HistoricoSms(Integer id, boolean enviado) {
        this.id = id;
        this.enviado = enviado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public boolean getEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
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
        if (!(object instanceof HistoricoSms)) {
            return false;
        }
        HistoricoSms other = (HistoricoSms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.HistoricoSms[ id=" + id + " ]";
    }
    
}
