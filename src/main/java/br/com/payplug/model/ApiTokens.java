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
@Table(name = "api_tokens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApiTokens.findAll", query = "SELECT a FROM ApiTokens a"),
    @NamedQuery(name = "ApiTokens.findById", query = "SELECT a FROM ApiTokens a WHERE a.id = :id"),
    @NamedQuery(name = "ApiTokens.findByToken", query = "SELECT a FROM ApiTokens a WHERE a.token = :token"),
    @NamedQuery(name = "ApiTokens.findByRequestDate", query = "SELECT a FROM ApiTokens a WHERE a.requestDate = :requestDate"),
    @NamedQuery(name = "ApiTokens.findByExpirationDate", query = "SELECT a FROM ApiTokens a WHERE a.expirationDate = :expirationDate"),
    @NamedQuery(name = "ApiTokens.findByUserIp", query = "SELECT a FROM ApiTokens a WHERE a.userIp = :userIp")})
public class ApiTokens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "request_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Size(max = 50)
    @Column(name = "user_ip")
    private String userIp;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUser;

    public ApiTokens() {
    }

    public ApiTokens(Integer id) {
        this.id = id;
    }

    public ApiTokens(Integer id, Date requestDate, Date expirationDate) {
        this.id = id;
        this.requestDate = requestDate;
        this.expirationDate = expirationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Usuarios getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuarios idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof ApiTokens)) {
            return false;
        }
        ApiTokens other = (ApiTokens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.ApiTokens[ id=" + id + " ]";
    }
    
}
