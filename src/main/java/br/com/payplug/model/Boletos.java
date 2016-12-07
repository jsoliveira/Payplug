/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "boletos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boletos.findAll", query = "SELECT b FROM Boletos b"),
    @NamedQuery(name = "Boletos.findById", query = "SELECT b FROM Boletos b WHERE b.id = :id"),
    @NamedQuery(name = "Boletos.findByCodigoBarra", query = "SELECT b FROM Boletos b WHERE b.codigoBarra = :codigoBarra"),
    @NamedQuery(name = "Boletos.findByHtml", query = "SELECT b FROM Boletos b WHERE b.html = :html"),
    @NamedQuery(name = "Boletos.findByDataVencimento", query = "SELECT b FROM Boletos b WHERE b.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "Boletos.findByDataCadastro", query = "SELECT b FROM Boletos b WHERE b.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Boletos.findByValor", query = "SELECT b FROM Boletos b WHERE b.valor = :valor"),
    @NamedQuery(name = "Boletos.findByNossoNumero", query = "SELECT b FROM Boletos b WHERE b.nossoNumero = :nossoNumero"),
    @NamedQuery(name = "Boletos.findByNumeroDocumento", query = "SELECT b FROM Boletos b WHERE b.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Boletos.findByCarteira", query = "SELECT b FROM Boletos b WHERE b.carteira = :carteira"),
    @NamedQuery(name = "Boletos.findByCedenteCpfCnpj", query = "SELECT b FROM Boletos b WHERE b.cedenteCpfCnpj = :cedenteCpfCnpj"),
    @NamedQuery(name = "Boletos.findByCedenteNome", query = "SELECT b FROM Boletos b WHERE b.cedenteNome = :cedenteNome"),
    @NamedQuery(name = "Boletos.findByCedenteCodigo", query = "SELECT b FROM Boletos b WHERE b.cedenteCodigo = :cedenteCodigo"),
    @NamedQuery(name = "Boletos.findByCedenteAgencia", query = "SELECT b FROM Boletos b WHERE b.cedenteAgencia = :cedenteAgencia"),
    @NamedQuery(name = "Boletos.findByCedenteDigitoAgencia", query = "SELECT b FROM Boletos b WHERE b.cedenteDigitoAgencia = :cedenteDigitoAgencia"),
    @NamedQuery(name = "Boletos.findByCedenteConta", query = "SELECT b FROM Boletos b WHERE b.cedenteConta = :cedenteConta"),
    @NamedQuery(name = "Boletos.findByCedenteDigitoConta", query = "SELECT b FROM Boletos b WHERE b.cedenteDigitoConta = :cedenteDigitoConta"),
    @NamedQuery(name = "Boletos.findBySacadoCpfCnpj", query = "SELECT b FROM Boletos b WHERE b.sacadoCpfCnpj = :sacadoCpfCnpj"),
    @NamedQuery(name = "Boletos.findBySacadoNome", query = "SELECT b FROM Boletos b WHERE b.sacadoNome = :sacadoNome"),
    @NamedQuery(name = "Boletos.findBySacadoEnd", query = "SELECT b FROM Boletos b WHERE b.sacadoEnd = :sacadoEnd"),
    @NamedQuery(name = "Boletos.findBySacadoBairro", query = "SELECT b FROM Boletos b WHERE b.sacadoBairro = :sacadoBairro"),
    @NamedQuery(name = "Boletos.findBySacadoCep", query = "SELECT b FROM Boletos b WHERE b.sacadoCep = :sacadoCep"),
    @NamedQuery(name = "Boletos.findBySacadoCidade", query = "SELECT b FROM Boletos b WHERE b.sacadoCidade = :sacadoCidade"),
    @NamedQuery(name = "Boletos.findBySacadoUf", query = "SELECT b FROM Boletos b WHERE b.sacadoUf = :sacadoUf"),
    @NamedQuery(name = "Boletos.findByInstrucoes", query = "SELECT b FROM Boletos b WHERE b.instrucoes = :instrucoes"),
    @NamedQuery(name = "Boletos.findByRemovido", query = "SELECT b FROM Boletos b WHERE b.removido = :removido")})
public class Boletos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "html")
    private String html;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nosso_numero")
    private String nossoNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "carteira")
    private String carteira;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "cedente_cpf_cnpj")
    private String cedenteCpfCnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cedente_nome")
    private String cedenteNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cedente_codigo")
    private String cedenteCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedente_agencia")
    private String cedenteAgencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "cedente_digito_agencia")
    private String cedenteDigitoAgencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedente_conta")
    private String cedenteConta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "cedente_digito_conta")
    private String cedenteDigitoConta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "sacado_cpf_cnpj")
    private String sacadoCpfCnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "sacado_nome")
    private String sacadoNome;
    @Size(max = 2000)
    @Column(name = "sacado_end")
    private String sacadoEnd;
    @Size(max = 200)
    @Column(name = "sacado_bairro")
    private String sacadoBairro;
    @Size(max = 9)
    @Column(name = "sacado_cep")
    private String sacadoCep;
    @Size(max = 200)
    @Column(name = "sacado_cidade")
    private String sacadoCidade;
    @Size(max = 200)
    @Column(name = "sacado_uf")
    private String sacadoUf;
    @Size(max = 2147483647)
    @Column(name = "instrucoes")
    private String instrucoes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @JoinColumn(name = "id_transacao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transacoes idTransacao;

    public Boletos() {
    }

    public Boletos(Integer id) {
        this.id = id;
    }

    public Boletos(Integer id, String codigoBarra, String html, Date dataVencimento, Date dataCadastro, BigDecimal valor, String nossoNumero, String numeroDocumento, String carteira, String cedenteCpfCnpj, String cedenteNome, String cedenteCodigo, String cedenteAgencia, String cedenteDigitoAgencia, String cedenteConta, String cedenteDigitoConta, String sacadoCpfCnpj, String sacadoNome, int removido) {
        this.id = id;
        this.codigoBarra = codigoBarra;
        this.html = html;
        this.dataVencimento = dataVencimento;
        this.dataCadastro = dataCadastro;
        this.valor = valor;
        this.nossoNumero = nossoNumero;
        this.numeroDocumento = numeroDocumento;
        this.carteira = carteira;
        this.cedenteCpfCnpj = cedenteCpfCnpj;
        this.cedenteNome = cedenteNome;
        this.cedenteCodigo = cedenteCodigo;
        this.cedenteAgencia = cedenteAgencia;
        this.cedenteDigitoAgencia = cedenteDigitoAgencia;
        this.cedenteConta = cedenteConta;
        this.cedenteDigitoConta = cedenteDigitoConta;
        this.sacadoCpfCnpj = sacadoCpfCnpj;
        this.sacadoNome = sacadoNome;
        this.removido = removido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getCedenteCpfCnpj() {
        return cedenteCpfCnpj;
    }

    public void setCedenteCpfCnpj(String cedenteCpfCnpj) {
        this.cedenteCpfCnpj = cedenteCpfCnpj;
    }

    public String getCedenteNome() {
        return cedenteNome;
    }

    public void setCedenteNome(String cedenteNome) {
        this.cedenteNome = cedenteNome;
    }

    public String getCedenteCodigo() {
        return cedenteCodigo;
    }

    public void setCedenteCodigo(String cedenteCodigo) {
        this.cedenteCodigo = cedenteCodigo;
    }

    public String getCedenteAgencia() {
        return cedenteAgencia;
    }

    public void setCedenteAgencia(String cedenteAgencia) {
        this.cedenteAgencia = cedenteAgencia;
    }

    public String getCedenteDigitoAgencia() {
        return cedenteDigitoAgencia;
    }

    public void setCedenteDigitoAgencia(String cedenteDigitoAgencia) {
        this.cedenteDigitoAgencia = cedenteDigitoAgencia;
    }

    public String getCedenteConta() {
        return cedenteConta;
    }

    public void setCedenteConta(String cedenteConta) {
        this.cedenteConta = cedenteConta;
    }

    public String getCedenteDigitoConta() {
        return cedenteDigitoConta;
    }

    public void setCedenteDigitoConta(String cedenteDigitoConta) {
        this.cedenteDigitoConta = cedenteDigitoConta;
    }

    public String getSacadoCpfCnpj() {
        return sacadoCpfCnpj;
    }

    public void setSacadoCpfCnpj(String sacadoCpfCnpj) {
        this.sacadoCpfCnpj = sacadoCpfCnpj;
    }

    public String getSacadoNome() {
        return sacadoNome;
    }

    public void setSacadoNome(String sacadoNome) {
        this.sacadoNome = sacadoNome;
    }

    public String getSacadoEnd() {
        return sacadoEnd;
    }

    public void setSacadoEnd(String sacadoEnd) {
        this.sacadoEnd = sacadoEnd;
    }

    public String getSacadoBairro() {
        return sacadoBairro;
    }

    public void setSacadoBairro(String sacadoBairro) {
        this.sacadoBairro = sacadoBairro;
    }

    public String getSacadoCep() {
        return sacadoCep;
    }

    public void setSacadoCep(String sacadoCep) {
        this.sacadoCep = sacadoCep;
    }

    public String getSacadoCidade() {
        return sacadoCidade;
    }

    public void setSacadoCidade(String sacadoCidade) {
        this.sacadoCidade = sacadoCidade;
    }

    public String getSacadoUf() {
        return sacadoUf;
    }

    public void setSacadoUf(String sacadoUf) {
        this.sacadoUf = sacadoUf;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public Transacoes getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Transacoes idTransacao) {
        this.idTransacao = idTransacao;
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
        if (!(object instanceof Boletos)) {
            return false;
        }
        Boletos other = (Boletos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Boletos[ id=" + id + " ]";
    }
    
}
