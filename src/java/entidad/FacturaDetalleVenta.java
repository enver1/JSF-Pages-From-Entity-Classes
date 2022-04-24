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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author casa
 */
@Entity
@Table(name = "factura_detalle_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaDetalleVenta.findAll", query = "SELECT f FROM FacturaDetalleVenta f"),
    @NamedQuery(name = "FacturaDetalleVenta.findByIdeFacdetven", query = "SELECT f FROM FacturaDetalleVenta f WHERE f.ideFacdetven = :ideFacdetven"),
    @NamedQuery(name = "FacturaDetalleVenta.findByCantidadFacdetven", query = "SELECT f FROM FacturaDetalleVenta f WHERE f.cantidadFacdetven = :cantidadFacdetven"),
    @NamedQuery(name = "FacturaDetalleVenta.findByPreciounitarioFacdetven", query = "SELECT f FROM FacturaDetalleVenta f WHERE f.preciounitarioFacdetven = :preciounitarioFacdetven"),
    @NamedQuery(name = "FacturaDetalleVenta.findByTotalFacdetven", query = "SELECT f FROM FacturaDetalleVenta f WHERE f.totalFacdetven = :totalFacdetven"),
    @NamedQuery(name = "FacturaDetalleVenta.findByIncentivoFacdetven", query = "SELECT f FROM FacturaDetalleVenta f WHERE f.incentivoFacdetven = :incentivoFacdetven")})
public class FacturaDetalleVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ide_facdetven")
    private Integer ideFacdetven;
    @Column(name = "cantidad_facdetven")
    private Integer cantidadFacdetven;
    @Column(name = "preciounitario_facdetven")
    private BigInteger preciounitarioFacdetven;
    @Column(name = "total_facdetven")
    private BigInteger totalFacdetven;
    @Column(name = "incentivo_facdetven")
    private BigInteger incentivoFacdetven;
    @OneToMany(mappedBy = "ideFacdetven")
    private Collection<Inventario> inventarioCollection;
    @JoinColumn(name = "ide_art", referencedColumnName = "ide_art")
    @ManyToOne
    private Articulos ideArt;
    @JoinColumn(name = "ide_facvent", referencedColumnName = "ide_facvent")
    @ManyToOne
    private FacturaVenta ideFacvent;
    @JoinColumn(name = "ide_ince", referencedColumnName = "ide_ince")
    @ManyToOne
    private Incentivos ideInce;

    public FacturaDetalleVenta() {
    }

    public FacturaDetalleVenta(Integer ideFacdetven) {
        this.ideFacdetven = ideFacdetven;
    }

    public Integer getIdeFacdetven() {
        return ideFacdetven;
    }

    public void setIdeFacdetven(Integer ideFacdetven) {
        this.ideFacdetven = ideFacdetven;
    }

    public Integer getCantidadFacdetven() {
        return cantidadFacdetven;
    }

    public void setCantidadFacdetven(Integer cantidadFacdetven) {
        this.cantidadFacdetven = cantidadFacdetven;
    }

    public BigInteger getPreciounitarioFacdetven() {
        return preciounitarioFacdetven;
    }

    public void setPreciounitarioFacdetven(BigInteger preciounitarioFacdetven) {
        this.preciounitarioFacdetven = preciounitarioFacdetven;
    }

    public BigInteger getTotalFacdetven() {
        return totalFacdetven;
    }

    public void setTotalFacdetven(BigInteger totalFacdetven) {
        this.totalFacdetven = totalFacdetven;
    }

    public BigInteger getIncentivoFacdetven() {
        return incentivoFacdetven;
    }

    public void setIncentivoFacdetven(BigInteger incentivoFacdetven) {
        this.incentivoFacdetven = incentivoFacdetven;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    public Articulos getIdeArt() {
        return ideArt;
    }

    public void setIdeArt(Articulos ideArt) {
        this.ideArt = ideArt;
    }

    public FacturaVenta getIdeFacvent() {
        return ideFacvent;
    }

    public void setIdeFacvent(FacturaVenta ideFacvent) {
        this.ideFacvent = ideFacvent;
    }

    public Incentivos getIdeInce() {
        return ideInce;
    }

    public void setIdeInce(Incentivos ideInce) {
        this.ideInce = ideInce;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideFacdetven != null ? ideFacdetven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDetalleVenta)) {
            return false;
        }
        FacturaDetalleVenta other = (FacturaDetalleVenta) object;
        if ((this.ideFacdetven == null && other.ideFacdetven != null) || (this.ideFacdetven != null && !this.ideFacdetven.equals(other.ideFacdetven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.FacturaDetalleVenta[ ideFacdetven=" + ideFacdetven + " ]";
    }
    
}
