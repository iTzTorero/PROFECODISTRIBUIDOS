/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o")
    , @NamedQuery(name = "Oferta.findByIdoferta", query = "SELECT o FROM Oferta o WHERE o.idoferta = :idoferta")
    , @NamedQuery(name = "Oferta.findByDescuento", query = "SELECT o FROM Oferta o WHERE o.descuento = :descuento")
    , @NamedQuery(name = "Oferta.findByDuracion", query = "SELECT o FROM Oferta o WHERE o.duracion = :duracion")
    , @NamedQuery(name = "Oferta.findByDescripcion", query = "SELECT o FROM Oferta o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Oferta.findByIdmercado", query = "SELECT o FROM Oferta o WHERE o.idmercado = :idmercado")})
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idoferta")
    private Integer idoferta;
    @Basic(optional = false)
    @Column(name = "descuento")
    private float descuento;
    @Basic(optional = false)
    @Column(name = "duracion")
    private int duracion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "idmercado")
    private int idmercado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idoferta")
    private Collection<Detalleoferta> detalleofertaCollection;

    public Oferta() {
    }

    public Oferta(Integer idoferta) {
        this.idoferta = idoferta;
    }

    public Oferta(Integer idoferta, float descuento, int duracion, String descripcion, int idmercado) {
        this.idoferta = idoferta;
        this.descuento = descuento;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.idmercado = idmercado;
    }

    public Integer getIdoferta() {
        return idoferta;
    }

    public void setIdoferta(Integer idoferta) {
        this.idoferta = idoferta;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdmercado() {
        return idmercado;
    }

    public void setIdmercado(int idmercado) {
        this.idmercado = idmercado;
    }

    @XmlTransient
    public Collection<Detalleoferta> getDetalleofertaCollection() {
        return detalleofertaCollection;
    }

    public void setDetalleofertaCollection(Collection<Detalleoferta> detalleofertaCollection) {
        this.detalleofertaCollection = detalleofertaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoferta != null ? idoferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idoferta == null && other.idoferta != null) || (this.idoferta != null && !this.idoferta.equals(other.idoferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Oferta[ idoferta=" + idoferta + " ]";
    }
    
}
