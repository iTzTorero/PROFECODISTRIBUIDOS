/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r")
    , @NamedQuery(name = "Review.findByIdreview", query = "SELECT r FROM Review r WHERE r.idreview = :idreview")
    , @NamedQuery(name = "Review.findByContenido", query = "SELECT r FROM Review r WHERE r.contenido = :contenido")
    , @NamedQuery(name = "Review.findByCalificacion", query = "SELECT r FROM Review r WHERE r.calificacion = :calificacion")
    , @NamedQuery(name = "Review.findByIdconsumidor", query = "SELECT r FROM Review r WHERE r.idconsumidor = :idconsumidor")
    , @NamedQuery(name = "Review.findByIdmercado", query = "SELECT r FROM Review r WHERE r.idmercado = :idmercado")})
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreview")
    private Integer idreview;
    @Basic(optional = false)
    @Column(name = "contenido")
    private String contenido;
    @Basic(optional = false)
    @Column(name = "calificacion")
    private int calificacion;
    @Basic(optional = false)
    @Column(name = "idconsumidor")
    private int idconsumidor;
    @Basic(optional = false)
    @Column(name = "idmercado")
    private int idmercado;

    public Review() {
    }

    public Review(Integer idreview) {
        this.idreview = idreview;
    }

    public Review(Integer idreview, String contenido, int calificacion, int idconsumidor, int idmercado) {
        this.idreview = idreview;
        this.contenido = contenido;
        this.calificacion = calificacion;
        this.idconsumidor = idconsumidor;
        this.idmercado = idmercado;
    }

    public Integer getIdreview() {
        return idreview;
    }

    public void setIdreview(Integer idreview) {
        this.idreview = idreview;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdconsumidor() {
        return idconsumidor;
    }

    public void setIdconsumidor(int idconsumidor) {
        this.idconsumidor = idconsumidor;
    }

    public int getIdmercado() {
        return idmercado;
    }

    public void setIdmercado(int idmercado) {
        this.idmercado = idmercado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreview != null ? idreview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.idreview == null && other.idreview != null) || (this.idreview != null && !this.idreview.equals(other.idreview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Review[ idreview=" + idreview + " ]";
    }
    
}
