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
@Table(name = "historico_sms_respondidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoSmsRespondidas.findAll", query = "SELECT h FROM HistoricoSmsRespondidas h"),
    @NamedQuery(name = "HistoricoSmsRespondidas.findById", query = "SELECT h FROM HistoricoSmsRespondidas h WHERE h.id = :id"),
    @NamedQuery(name = "HistoricoSmsRespondidas.findByMensagem", query = "SELECT h FROM HistoricoSmsRespondidas h WHERE h.mensagem = :mensagem"),
    @NamedQuery(name = "HistoricoSmsRespondidas.findByNumero", query = "SELECT h FROM HistoricoSmsRespondidas h WHERE h.numero = :numero"),
    @NamedQuery(name = "HistoricoSmsRespondidas.findByData", query = "SELECT h FROM HistoricoSmsRespondidas h WHERE h.data = :data"),
    @NamedQuery(name = "HistoricoSmsRespondidas.findByEnviado", query = "SELECT h FROM HistoricoSmsRespondidas h WHERE h.enviado = :enviado")})
public class HistoricoSmsRespondidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 160)
    @Column(name = "mensagem")
    private String mensagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "enviado")
    private Integer enviado;

    public HistoricoSmsRespondidas() {
    }

    public HistoricoSmsRespondidas(Integer id) {
        this.id = id;
    }

    public HistoricoSmsRespondidas(Integer id, String mensagem, String numero, Date data) {
        this.id = id;
        this.mensagem = mensagem;
        this.numero = numero;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getEnviado() {
        return enviado;
    }

    public void setEnviado(Integer enviado) {
        this.enviado = enviado;
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
        if (!(object instanceof HistoricoSmsRespondidas)) {
            return false;
        }
        HistoricoSmsRespondidas other = (HistoricoSmsRespondidas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.HistoricoSmsRespondidas[ id=" + id + " ]";
    }
    
}
