package br.com.payplug.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 *
 * @author Leticia
 */
@Embeddable
public class TitulosPk implements Serializable {

    @Column(name = "id_transacao")
    private Integer idTransacao;

    @Column(name = "id_titulo")
    private Integer idTitulo;

    public TitulosPk() {
    }

    public TitulosPk(Integer idTransacao, Integer idTitulo) {
        this.idTransacao = idTransacao;
        this.idTitulo = idTitulo;
    }

    public Integer getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Integer idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Integer getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(Integer idTitulo) {
        this.idTitulo = idTitulo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.idTransacao);
        hash = 43 * hash + Objects.hashCode(this.idTitulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TitulosPk other = (TitulosPk) obj;
        if (!Objects.equals(this.idTransacao, other.idTransacao)) {
            return false;
        }
        if (!Objects.equals(this.idTitulo, other.idTitulo)) {
            return false;
        }
        return true;
    }

}
