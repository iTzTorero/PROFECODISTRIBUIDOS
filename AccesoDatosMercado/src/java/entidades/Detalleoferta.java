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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "detalleoferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleoferta.findAll", query = "SELECT d FROM Detalleoferta d")
    , @NamedQuery(name = "Detalleoferta.findByIddetalleoferta", query = "SELECT d FROM Detalleoferta d WHERE d.iddetalleoferta = :iddetalleoferta")})
public class Detalleoferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalleoferta")
    private Integer iddetalleoferta;
    @JoinColumn(name = "idoferta", referencedColumnName = "idoferta")
    @ManyToOne(optional = false)
    private Oferta idoferta;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto idproducto;

    public Detalleoferta() {
    }

    public Detalleoferta(Integer iddetalleoferta) {
        this.iddetalleoferta = iddetalleoferta;
    }

    public Integer getIddetalleoferta() {
        return iddetalleoferta;
    }

    public void setIddetalleoferta(Integer iddetalleoferta) {
        this.iddetalleoferta = iddetalleoferta;
    }

    public Oferta getIdoferta() {
        return idoferta;
    }

    public void setIdoferta(Oferta idoferta) {
        this.idoferta = idoferta;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleoferta != null ? iddetalleoferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleoferta)) {
            return false;
        }
        Detalleoferta other = (Detalleoferta) object;
        if ((this.iddetalleoferta == null && other.iddetalleoferta != null) || (this.iddetalleoferta != null && !this.iddetalleoferta.equals(other.iddetalleoferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Detalleoferta[ iddetalleoferta=" + iddetalleoferta + " ]";
    }
    
}
