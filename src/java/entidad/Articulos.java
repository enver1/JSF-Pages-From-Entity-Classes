/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author casa
 */
@Entity
@Table(name = "articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a"),
    @NamedQuery(name = "Articulos.findByIdeArt", query = "SELECT a FROM Articulos a WHERE a.ideArt = :ideArt"),
    @NamedQuery(name = "Articulos.findByNombreArt", query = "SELECT a FROM Articulos a WHERE a.nombreArt = :nombreArt"),
    @NamedQuery(name = "Articulos.findByCantidadArt", query = "SELECT a FROM Articulos a WHERE a.cantidadArt = :cantidadArt"),
    @NamedQuery(name = "Articulos.findByPreciounitarioArt", query = "SELECT a FROM Articulos a WHERE a.preciounitarioArt = :preciounitarioArt")})
public class Articulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ide_art")
    private Integer ideArt;
    @Size(max = 100)
    @Column(name = "nombre_art")
    private String nombreArt;
    @Column(name = "cantidad_art")
    private Integer cantidadArt;
    @Column(name = "preciounitario_art")
    private BigInteger preciounitarioArt;
    @OneToMany(mappedBy = "ideArt")
    private Collection<FacturaDetalleVenta> facturaDetalleVentaCollection;

    public Articulos() {
    }

    public Articulos(Integer ideArt) {
        this.ideArt = ideArt;
    }

    public Integer getIdeArt() {
        return ideArt;
    }

    public void setIdeArt(Integer ideArt) {
        this.ideArt = ideArt;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public Integer getCantidadArt() {
        return cantidadArt;
    }

    public void setCantidadArt(Integer cantidadArt) {
        this.cantidadArt = cantidadArt;
    }

    public BigInteger getPreciounitarioArt() {
        return preciounitarioArt;
    }

    public void setPreciounitarioArt(BigInteger preciounitarioArt) {
        this.preciounitarioArt = preciounitarioArt;
    }

    @XmlTransient
    public Collection<FacturaDetalleVenta> getFacturaDetalleVentaCollection() {
        return facturaDetalleVentaCollection;
    }

    public void setFacturaDetalleVentaCollection(Collection<FacturaDetalleVenta> facturaDetalleVentaCollection) {
        this.facturaDetalleVentaCollection = facturaDetalleVentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideArt != null ? ideArt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.ideArt == null && other.ideArt != null) || (this.ideArt != null && !this.ideArt.equals(other.ideArt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Articulos[ ideArt=" + ideArt + " ]";
    }
    
}
