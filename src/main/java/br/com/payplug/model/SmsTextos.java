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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sms_textos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmsTextos.findAll", query = "SELECT s FROM SmsTextos s"),
    @NamedQuery(name = "SmsTextos.findById", query = "SELECT s FROM SmsTextos s WHERE s.id = :id"),
    @NamedQuery(name = "SmsTextos.findByTextoSms", query = "SELECT s FROM SmsTextos s WHERE s.textoSms = :textoSms"),
    @NamedQuery(name = "SmsTextos.findByAcao", query = "SELECT s FROM SmsTextos s WHERE s.acao = :acao"),
    @NamedQuery(name = "SmsTextos.findByRemovido", query = "SELECT s FROM SmsTextos s WHERE s.removido = :removido")})
public class SmsTextos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "texto_sms")
    private String textoSms;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "acao")
    private String acao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @JoinColumn(name = "id_operacoes", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operacoes idOperacoes;

    public SmsTextos() {
    }

    public SmsTextos(Integer id) {
        this.id = id;
    }

    public SmsTextos(Integer id, String textoSms, String acao, int removido) {
        this.id = id;
        this.textoSms = textoSms;
        this.acao = acao;
        this.removido = removido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextoSms() {
        return textoSms;
    }

    public void setTextoSms(String textoSms) {
        this.textoSms = textoSms;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public Operacoes getIdOperacoes() {
        return idOperacoes;
    }

    public void setIdOperacoes(Operacoes idOperacoes) {
        this.idOperacoes = idOperacoes;
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
        if (!(object instanceof SmsTextos)) {
            return false;
        }
        SmsTextos other = (SmsTextos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.SmsTextos[ id=" + id + " ]";
    }
    
}
