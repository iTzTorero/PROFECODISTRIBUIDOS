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
@Table(name = "wishlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wishlist.findAll", query = "SELECT w FROM Wishlist w")
    , @NamedQuery(name = "Wishlist.findByIdwishlist", query = "SELECT w FROM Wishlist w WHERE w.idwishlist = :idwishlist")
    , @NamedQuery(name = "Wishlist.findByIdusuario", query = "SELECT w FROM Wishlist w WHERE w.idusuario = :idusuario")})
public class Wishlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idwishlist")
    private Integer idwishlist;
    @Basic(optional = false)
    @Column(name = "idusuario")
    private int idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idwishlist")
    private Collection<Detallewishlist> detallewishlistCollection;

    public Wishlist() {
    }

    public Wishlist(Integer idwishlist) {
        this.idwishlist = idwishlist;
    }

    public Wishlist(Integer idwishlist, int idusuario) {
        this.idwishlist = idwishlist;
        this.idusuario = idusuario;
    }

    public Integer getIdwishlist() {
        return idwishlist;
    }

    public void setIdwishlist(Integer idwishlist) {
        this.idwishlist = idwishlist;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public Collection<Detallewishlist> getDetallewishlistCollection() {
        return detallewishlistCollection;
    }

    public void setDetallewishlistCollection(Collection<Detallewishlist> detallewishlistCollection) {
        this.detallewishlistCollection = detallewishlistCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idwishlist != null ? idwishlist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wishlist)) {
            return false;
        }
        Wishlist other = (Wishlist) object;
        if ((this.idwishlist == null && other.idwishlist != null) || (this.idwishlist != null && !this.idwishlist.equals(other.idwishlist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Wishlist[ idwishlist=" + idwishlist + " ]";
    }
    
}
