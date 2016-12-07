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
@Table(name = "configuracoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracoes.findAll", query = "SELECT c FROM Configuracoes c"),
    @NamedQuery(name = "Configuracoes.findById", query = "SELECT c FROM Configuracoes c WHERE c.id = :id"),
    @NamedQuery(name = "Configuracoes.findBySmtp", query = "SELECT c FROM Configuracoes c WHERE c.smtp = :smtp"),
    @NamedQuery(name = "Configuracoes.findByEmail", query = "SELECT c FROM Configuracoes c WHERE c.email = :email"),
    @NamedQuery(name = "Configuracoes.findBySenha", query = "SELECT c FROM Configuracoes c WHERE c.senha = :senha"),
    @NamedQuery(name = "Configuracoes.findBySsl", query = "SELECT c FROM Configuracoes c WHERE c.ssl = :ssl"),
    @NamedQuery(name = "Configuracoes.findByPorta", query = "SELECT c FROM Configuracoes c WHERE c.porta = :porta")})
public class Configuracoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "smtp")
    private String smtp;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "senha")
    private String senha;
    @Column(name = "ssl")
    private Boolean ssl;
    @Column(name = "porta")
    private Integer porta;

    public Configuracoes() {
    }

    public Configuracoes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
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
        if (!(object instanceof Configuracoes)) {
            return false;
        }
        Configuracoes other = (Configuracoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Configuracoes[ id=" + id + " ]";
    }
    
}
