/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "consulta_gasto_mes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultaGastoMes.findAll", query = "SELECT c FROM ConsultaGastoMes c"),
    @NamedQuery(name = "ConsultaGastoMes.findByOperacao", query = "SELECT c FROM ConsultaGastoMes c WHERE c.operacao = :operacao"),
    @NamedQuery(name = "ConsultaGastoMes.findByUsuario", query = "SELECT c FROM ConsultaGastoMes c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "ConsultaGastoMes.findByTotalPorOperacao", query = "SELECT c FROM ConsultaGastoMes c WHERE c.totalPorOperacao = :totalPorOperacao")})
public class ConsultaGastoMes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "operacao")
    private String operacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "usuario")
    private String usuario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_por_operacao")
    private BigDecimal totalPorOperacao;

    public ConsultaGastoMes() {
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getTotalPorOperacao() {
        return totalPorOperacao;
    }

    public void setTotalPorOperacao(BigDecimal totalPorOperacao) {
        this.totalPorOperacao = totalPorOperacao;
    }
    
}
