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
@Table(name = "cnae")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cnae.findAll", query = "SELECT c FROM Cnae c"),
    @NamedQuery(name = "Cnae.findById", query = "SELECT c FROM Cnae c WHERE c.id = :id"),
    @NamedQuery(name = "Cnae.findBySecao", query = "SELECT c FROM Cnae c WHERE c.secao = :secao"),
    @NamedQuery(name = "Cnae.findByDivisao", query = "SELECT c FROM Cnae c WHERE c.divisao = :divisao"),
    @NamedQuery(name = "Cnae.findByGrupo", query = "SELECT c FROM Cnae c WHERE c.grupo = :grupo"),
    @NamedQuery(name = "Cnae.findByClasse", query = "SELECT c FROM Cnae c WHERE c.classe = :classe"),
    @NamedQuery(name = "Cnae.findBySubclasse", query = "SELECT c FROM Cnae c WHERE c.subclasse = :subclasse"),
    @NamedQuery(name = "Cnae.findByDenominacao", query = "SELECT c FROM Cnae c WHERE c.denominacao = :denominacao"),
    @NamedQuery(name = "Cnae.findByRemovido", query = "SELECT c FROM Cnae c WHERE c.removido = :removido")})
public class Cnae implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "secao")
    private String secao;
    @Size(max = 10)
    @Column(name = "divisao")
    private String divisao;
    @Size(max = 10)
    @Column(name = "grupo")
    private String grupo;
    @Size(max = 10)
    @Column(name = "classe")
    private String classe;
    @Size(max = 10)
    @Column(name = "subclasse")
    private String subclasse;
    @Size(max = 500)
    @Column(name = "denominacao")
    private String denominacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;

    public Cnae() {
    }

    public Cnae(Integer id) {
        this.id = id;
    }

    public Cnae(Integer id, int removido) {
        this.id = id;
        this.removido = removido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getDivisao() {
        return divisao;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSubclasse() {
        return subclasse;
    }

    public void setSubclasse(String subclasse) {
        this.subclasse = subclasse;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
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
        if (!(object instanceof Cnae)) {
            return false;
        }
        Cnae other = (Cnae) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Cnae[ id=" + id + " ]";
    }
    
}
