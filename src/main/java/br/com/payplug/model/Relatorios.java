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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "relatorios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatorios.findAll", query = "SELECT r FROM Relatorios r"),
    @NamedQuery(name = "Relatorios.findById", query = "SELECT r FROM Relatorios r WHERE r.id = :id"),
    @NamedQuery(name = "Relatorios.findByCodigo", query = "SELECT r FROM Relatorios r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Relatorios.findByNome", query = "SELECT r FROM Relatorios r WHERE r.nome = :nome"),
    @NamedQuery(name = "Relatorios.findByNomeOriginal", query = "SELECT r FROM Relatorios r WHERE r.nomeOriginal = :nomeOriginal"),
    @NamedQuery(name = "Relatorios.findByExtensao", query = "SELECT r FROM Relatorios r WHERE r.extensao = :extensao"),
    @NamedQuery(name = "Relatorios.findByDescricao", query = "SELECT r FROM Relatorios r WHERE r.descricao = :descricao"),
    @NamedQuery(name = "Relatorios.findByData", query = "SELECT r FROM Relatorios r WHERE r.data = :data"),
    @NamedQuery(name = "Relatorios.findByTamanho", query = "SELECT r FROM Relatorios r WHERE r.tamanho = :tamanho"),
    @NamedQuery(name = "Relatorios.findByRemovido", query = "SELECT r FROM Relatorios r WHERE r.removido = :removido"),
    @NamedQuery(name = "Relatorios.findByDataRemocao", query = "SELECT r FROM Relatorios r WHERE r.dataRemocao = :dataRemocao")})
public class Relatorios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_original")
    private String nomeOriginal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "extensao")
    private String extensao;
    @Size(max = 2000)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tamanho")
    private int tamanho;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "rpt_bytes")
    private byte[] rptBytes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @Column(name = "data_remocao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRemocao;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Relatorios() {
    }

    public Relatorios(Integer id) {
        this.id = id;
    }

    public Relatorios(Integer id, String codigo, String nome, String nomeOriginal, String extensao, Date data, int tamanho, byte[] rptBytes, int removido) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.nomeOriginal = nomeOriginal;
        this.extensao = extensao;
        this.data = data;
        this.tamanho = tamanho;
        this.rptBytes = rptBytes;
        this.removido = removido;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public byte[] getRptBytes() {
        return rptBytes;
    }

    public void setRptBytes(byte[] rptBytes) {
        this.rptBytes = rptBytes;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public Date getDataRemocao() {
        return dataRemocao;
    }

    public void setDataRemocao(Date dataRemocao) {
        this.dataRemocao = dataRemocao;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Relatorios)) {
            return false;
        }
        Relatorios other = (Relatorios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Relatorios[ id=" + id + " ]";
    }
    
}
