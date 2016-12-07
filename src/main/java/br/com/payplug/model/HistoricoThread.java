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
@Table(name = "historico_thread")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoThread.findAll", query = "SELECT h FROM HistoricoThread h"),
    @NamedQuery(name = "HistoricoThread.findById", query = "SELECT h FROM HistoricoThread h WHERE h.id = :id"),
    @NamedQuery(name = "HistoricoThread.findByDateHour", query = "SELECT h FROM HistoricoThread h WHERE h.dateHour = :dateHour"),
    @NamedQuery(name = "HistoricoThread.findByDescription", query = "SELECT h FROM HistoricoThread h WHERE h.description = :description")})
public class HistoricoThread implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "date_hour")
    private String dateHour;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;

    public HistoricoThread() {
    }

    public HistoricoThread(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof HistoricoThread)) {
            return false;
        }
        HistoricoThread other = (HistoricoThread) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.HistoricoThread[ id=" + id + " ]";
    }
    
}
