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
@Table(name = "detallewishlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallewishlist.findAll", query = "SELECT d FROM Detallewishlist d")
    , @NamedQuery(name = "Detallewishlist.findByIddetallewishlist", query = "SELECT d FROM Detallewishlist d WHERE d.iddetallewishlist = :iddetallewishlist")
    , @NamedQuery(name = "Detallewishlist.findByIdconsumidor", query = "SELECT d FROM Detallewishlist d WHERE d.idconsumidor = :idconsumidor")
    , @NamedQuery(name = "Detallewishlist.findByIdproducto", query = "SELECT d FROM Detallewishlist d WHERE d.idproducto = :idproducto")})
public class Detallewishlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallewishlist")
    private Integer iddetallewishlist;
    @Basic(optional = false)
    @Column(name = "idconsumidor")
    private int idconsumidor;
    @Basic(optional = false)
    @Column(name = "idproducto")
    private int idproducto;
    @JoinColumn(name = "idwishlist", referencedColumnName = "idwishlist")
    @ManyToOne(optional = false)
    private Wishlist idwishlist;

    public Detallewishlist() {
    }

    public Detallewishlist(Integer iddetallewishlist) {
        this.iddetallewishlist = iddetallewishlist;
    }

    public Detallewishlist(Integer iddetallewishlist, int idconsumidor, int idproducto) {
        this.iddetallewishlist = iddetallewishlist;
        this.idconsumidor = idconsumidor;
        this.idproducto = idproducto;
    }

    public Integer getIddetallewishlist() {
        return iddetallewishlist;
    }

    public void setIddetallewishlist(Integer iddetallewishlist) {
        this.iddetallewishlist = iddetallewishlist;
    }

    public int getIdconsumidor() {
        return idconsumidor;
    }

    public void setIdconsumidor(int idconsumidor) {
        this.idconsumidor = idconsumidor;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Wishlist getIdwishlist() {
        return idwishlist;
    }

    public void setIdwishlist(Wishlist idwishlist) {
        this.idwishlist = idwishlist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallewishlist != null ? iddetallewishlist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallewishlist)) {
            return false;
        }
        Detallewishlist other = (Detallewishlist) object;
        if ((this.iddetallewishlist == null && other.iddetallewishlist != null) || (this.iddetallewishlist != null && !this.iddetallewishlist.equals(other.iddetallewishlist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Detallewishlist[ iddetallewishlist=" + iddetallewishlist + " ]";
    }
    
}
