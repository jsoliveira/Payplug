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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "moedas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moedas.findAll", query = "SELECT m FROM Moedas m"),
    @NamedQuery(name = "Moedas.findById", query = "SELECT m FROM Moedas m WHERE m.id = :id"),
    @NamedQuery(name = "Moedas.findByNome", query = "SELECT m FROM Moedas m WHERE m.nome = :nome"),
    @NamedQuery(name = "Moedas.findBySimbolo", query = "SELECT m FROM Moedas m WHERE m.simbolo = :simbolo"),
    @NamedQuery(name = "Moedas.findByCambioCompra", query = "SELECT m FROM Moedas m WHERE m.cambioCompra = :cambioCompra"),
    @NamedQuery(name = "Moedas.findByCambioVenda", query = "SELECT m FROM Moedas m WHERE m.cambioVenda = :cambioVenda"),
    @NamedQuery(name = "Moedas.findByDataCotacao", query = "SELECT m FROM Moedas m WHERE m.dataCotacao = :dataCotacao"),
    @NamedQuery(name = "Moedas.findByQtdMinimaDiasParaSaque", query = "SELECT m FROM Moedas m WHERE m.qtdMinimaDiasParaSaque = :qtdMinimaDiasParaSaque"),
    @NamedQuery(name = "Moedas.findByRemovido", query = "SELECT m FROM Moedas m WHERE m.removido = :removido"),
    @NamedQuery(name = "Moedas.findByPadrao", query = "SELECT m FROM Moedas m WHERE m.padrao = :padrao")})
public class Moedas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "simbolo")
    private String simbolo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambio_compra")
    private BigDecimal cambioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambio_venda")
    private BigDecimal cambioVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cotacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCotacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtd_minima_dias_para_saque")
    private int qtdMinimaDiasParaSaque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "padrao")
    private int padrao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMoeda")
    private List<Usuarios> usuariosList;
    @OneToMany(mappedBy = "idMoedaUsuario")
    private List<Transacoes> transacoesList;

    public Moedas() {
    }

    public Moedas(Integer id) {
        this.id = id;
    }

    public Moedas(Integer id, String nome, String simbolo, BigDecimal cambioCompra, BigDecimal cambioVenda, Date dataCotacao, int qtdMinimaDiasParaSaque, int removido, int padrao) {
        this.id = id;
        this.nome = nome;
        this.simbolo = simbolo;
        this.cambioCompra = cambioCompra;
        this.cambioVenda = cambioVenda;
        this.dataCotacao = dataCotacao;
        this.qtdMinimaDiasParaSaque = qtdMinimaDiasParaSaque;
        this.removido = removido;
        this.padrao = padrao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public BigDecimal getCambioCompra() {
        return cambioCompra;
    }

    public void setCambioCompra(BigDecimal cambioCompra) {
        this.cambioCompra = cambioCompra;
    }

    public BigDecimal getCambioVenda() {
        return cambioVenda;
    }

    public void setCambioVenda(BigDecimal cambioVenda) {
        this.cambioVenda = cambioVenda;
    }

    public Date getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(Date dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

    public int getQtdMinimaDiasParaSaque() {
        return qtdMinimaDiasParaSaque;
    }

    public void setQtdMinimaDiasParaSaque(int qtdMinimaDiasParaSaque) {
        this.qtdMinimaDiasParaSaque = qtdMinimaDiasParaSaque;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public int getPadrao() {
        return padrao;
    }

    public void setPadrao(int padrao) {
        this.padrao = padrao;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<Transacoes> getTransacoesList() {
        return transacoesList;
    }

    public void setTransacoesList(List<Transacoes> transacoesList) {
        this.transacoesList = transacoesList;
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
        if (!(object instanceof Moedas)) {
            return false;
        }
        Moedas other = (Moedas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Moedas[ id=" + id + " ]";
    }
    
}
