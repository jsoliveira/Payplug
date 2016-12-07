/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jsoliveira
 */
@Embeddable
public class NumeroCartaoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_cliente")
    private long numeroCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificador_emitente")
    private int identificadorEmitente;

    public NumeroCartaoPK() {
    }

    public NumeroCartaoPK(long numeroCliente, int identificadorEmitente) {
        this.numeroCliente = numeroCliente;
        this.identificadorEmitente = identificadorEmitente;
    }

    public long getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(long numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getIdentificadorEmitente() {
        return identificadorEmitente;
    }

    public void setIdentificadorEmitente(int identificadorEmitente) {
        this.identificadorEmitente = identificadorEmitente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroCliente;
        hash += (int) identificadorEmitente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumeroCartaoPK)) {
            return false;
        }
        NumeroCartaoPK other = (NumeroCartaoPK) object;
        if (this.numeroCliente != other.numeroCliente) {
            return false;
        }
        if (this.identificadorEmitente != other.identificadorEmitente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.NumeroCartaoPK[ numeroCliente=" + numeroCliente + ", identificadorEmitente=" + identificadorEmitente + " ]";
    }
    
}
