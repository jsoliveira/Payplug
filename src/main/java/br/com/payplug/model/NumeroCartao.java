/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "numero_cartao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumeroCartao.findAll", query = "SELECT n FROM NumeroCartao n"),
    @NamedQuery(name = "NumeroCartao.findByNumeroCliente", query = "SELECT n FROM NumeroCartao n WHERE n.numeroCartaoPK.numeroCliente = :numeroCliente"),
    @NamedQuery(name = "NumeroCartao.findByIdentificadorEmitente", query = "SELECT n FROM NumeroCartao n WHERE n.numeroCartaoPK.identificadorEmitente = :identificadorEmitente")})
public class NumeroCartao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NumeroCartaoPK numeroCartaoPK;
    @JoinColumn(name = "id_usuario_dono", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarioDono;

    public NumeroCartao() {
    }

    public NumeroCartao(NumeroCartaoPK numeroCartaoPK) {
        this.numeroCartaoPK = numeroCartaoPK;
    }

    public NumeroCartao(long numeroCliente, int identificadorEmitente) {
        this.numeroCartaoPK = new NumeroCartaoPK(numeroCliente, identificadorEmitente);
    }

    public NumeroCartaoPK getNumeroCartaoPK() {
        return numeroCartaoPK;
    }

    public void setNumeroCartaoPK(NumeroCartaoPK numeroCartaoPK) {
        this.numeroCartaoPK = numeroCartaoPK;
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
        hash += (numeroCartaoPK != null ? numeroCartaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumeroCartao)) {
            return false;
        }
        NumeroCartao other = (NumeroCartao) object;
        if ((this.numeroCartaoPK == null && other.numeroCartaoPK != null) || (this.numeroCartaoPK != null && !this.numeroCartaoPK.equals(other.numeroCartaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.NumeroCartao[ numeroCartaoPK=" + numeroCartaoPK + " ]";
    }
    
}
