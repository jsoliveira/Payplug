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
@Table(name = "importacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importacoes.findAll", query = "SELECT i FROM Importacoes i"),
    @NamedQuery(name = "Importacoes.findById", query = "SELECT i FROM Importacoes i WHERE i.id = :id"),
    @NamedQuery(name = "Importacoes.findByNomeOriginal", query = "SELECT i FROM Importacoes i WHERE i.nomeOriginal = :nomeOriginal"),
    @NamedQuery(name = "Importacoes.findByExtensao", query = "SELECT i FROM Importacoes i WHERE i.extensao = :extensao"),
    @NamedQuery(name = "Importacoes.findByDescricao", query = "SELECT i FROM Importacoes i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "Importacoes.findByData", query = "SELECT i FROM Importacoes i WHERE i.data = :data"),
    @NamedQuery(name = "Importacoes.findByTamanho", query = "SELECT i FROM Importacoes i WHERE i.tamanho = :tamanho"),
    @NamedQuery(name = "Importacoes.findByRemovido", query = "SELECT i FROM Importacoes i WHERE i.removido = :removido")})
public class Importacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
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
    @Column(name = "arquivo_bytes")
    private byte[] arquivoBytes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @JoinColumn(name = "id_tipo_importacao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoImportacoes idTipoImportacao;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Importacoes() {
    }

    public Importacoes(Integer id) {
        this.id = id;
    }

    public Importacoes(Integer id, String nomeOriginal, String extensao, Date data, int tamanho, byte[] arquivoBytes, int removido) {
        this.id = id;
        this.nomeOriginal = nomeOriginal;
        this.extensao = extensao;
        this.data = data;
        this.tamanho = tamanho;
        this.arquivoBytes = arquivoBytes;
        this.removido = removido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public byte[] getArquivoBytes() {
        return arquivoBytes;
    }

    public void setArquivoBytes(byte[] arquivoBytes) {
        this.arquivoBytes = arquivoBytes;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public TipoImportacoes getIdTipoImportacao() {
        return idTipoImportacao;
    }

    public void setIdTipoImportacao(TipoImportacoes idTipoImportacao) {
        this.idTipoImportacao = idTipoImportacao;
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
        if (!(object instanceof Importacoes)) {
            return false;
        }
        Importacoes other = (Importacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Importacoes[ id=" + id + " ]";
    }
    
}
