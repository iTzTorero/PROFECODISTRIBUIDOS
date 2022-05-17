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
@Table(name = "multa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multa.findAll", query = "SELECT m FROM Multa m")
    , @NamedQuery(name = "Multa.findByIdmulta", query = "SELECT m FROM Multa m WHERE m.idmulta = :idmulta")
    , @NamedQuery(name = "Multa.findByDescripcion", query = "SELECT m FROM Multa m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Multa.findByImporte", query = "SELECT m FROM Multa m WHERE m.importe = :importe")
    , @NamedQuery(name = "Multa.findByIdmercado", query = "SELECT m FROM Multa m WHERE m.idmercado = :idmercado")})
public class Multa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmulta")
    private Integer idmulta;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "importe")
    private float importe;
    @Basic(optional = false)
    @Column(name = "idmercado")
    private int idmercado;

    public Multa() {
    }

    public Multa(Integer idmulta) {
        this.idmulta = idmulta;
    }

    public Multa(Integer idmulta, String descripcion, float importe, int idmercado) {
        this.idmulta = idmulta;
        this.descripcion = descripcion;
        this.importe = importe;
        this.idmercado = idmercado;
    }

    public Integer getIdmulta() {
        return idmulta;
    }

    public void setIdmulta(Integer idmulta) {
        this.idmulta = idmulta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
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
        hash += (idmulta != null ? idmulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multa)) {
            return false;
        }
        Multa other = (Multa) object;
        if ((this.idmulta == null && other.idmulta != null) || (this.idmulta != null && !this.idmulta.equals(other.idmulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Multa[ idmulta=" + idmulta + " ]";
    }
    
}
