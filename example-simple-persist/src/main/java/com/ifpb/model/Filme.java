package com.ifpb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Amanda
 */
@Entity
public class Filme implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String titulo;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String sinopse;
    private String genero;
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;

    public Filme() {
    }

    public Filme(String titulo, String sinopse, String genero, Date dataLancamento) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.titulo);
        hash = 67 * hash + Objects.hashCode(this.sinopse);
        hash = 67 * hash + Objects.hashCode(this.genero);
        hash = 67 * hash + Objects.hashCode(this.dataLancamento);
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
        final Filme other = (Filme) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.sinopse, other.sinopse)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.dataLancamento, other.dataLancamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", titulo=" + titulo + ", sinopse=" + sinopse + ", genero=" + genero + ", dataLancamento=" + dataLancamento + '}';
    }

}
