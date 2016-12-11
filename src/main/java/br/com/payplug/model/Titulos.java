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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jnakamura
 */

@Entity
@Table(name = "titulos")
@XmlRootElement

public class Titulos implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_titulo")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "id_transacao", referencedColumnName = "id")
    private Transacoes idTransacao;
    
    @Column(name = "dat_titulo")
    private Date dataTitulo;

    @Column(name = "dat_liquidacao")
    private Date dataLiquidacao;

    @Column(name = "dat_transacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTransacao;

    @Column(name = "dat_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "val_titulo")
    private BigDecimal valorTitulo; 
    
    @Basic(optional = false)
    @Column(name = "val_liquidacao")
    private BigDecimal valorLiquidacao; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataTitulo() {
        return dataTitulo;
    }

    public void setDataTitulo(Date dataTitulo) {
        this.dataTitulo = dataTitulo;
    }

    public Date getDataLiquidacao() {
        return dataLiquidacao;
    }

    public void setDataLiquidacao(Date dataLiquidacao) {
        this.dataLiquidacao = dataLiquidacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public BigDecimal getValorTitulo() {
        return valorTitulo;
    }

    public void setValorTitulo(BigDecimal valorTitulo) {
        this.valorTitulo = valorTitulo;
    }

    public BigDecimal getValorLiquidacao() {
        return valorLiquidacao;
    }

    public void setValorLiquidacao(BigDecimal valorLiquidacao) {
        this.valorLiquidacao = valorLiquidacao;
    }

    public Titulos() {
    }

    public Titulos(Integer id, Date dataTitulo, Date dataLiquidacao, Date dataTransacao, Date dataAlteracao, BigDecimal valorTitulo, BigDecimal valorLiquidacao) {
        this.id = id;
        this.dataTitulo = dataTitulo;
        this.dataLiquidacao = dataLiquidacao;
        this.dataTransacao = dataTransacao;
        this.dataAlteracao = dataAlteracao;
        this.valorTitulo = valorTitulo;
        this.valorLiquidacao = valorLiquidacao;
    }

    public Transacoes getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Transacoes idTransacao) {
        this.idTransacao = idTransacao;
    }
    
    
}
