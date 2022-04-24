/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author casa
 */
@Entity
@Table(name = "factura_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaVenta.findAll", query = "SELECT f FROM FacturaVenta f"),
    @NamedQuery(name = "FacturaVenta.findByIdeFacvent", query = "SELECT f FROM FacturaVenta f WHERE f.ideFacvent = :ideFacvent"),
    @NamedQuery(name = "FacturaVenta.findByClavepagoFacvent", query = "SELECT f FROM FacturaVenta f WHERE f.clavepagoFacvent = :clavepagoFacvent"),
    @NamedQuery(name = "FacturaVenta.findByTotalFacvent", query = "SELECT f FROM FacturaVenta f WHERE f.totalFacvent = :totalFacvent"),
    @NamedQuery(name = "FacturaVenta.findByFechaFacvent", query = "SELECT f FROM FacturaVenta f WHERE f.fechaFacvent = :fechaFacvent"),
    @NamedQuery(name = "FacturaVenta.findByIncentivoFacvent", query = "SELECT f FROM FacturaVenta f WHERE f.incentivoFacvent = :incentivoFacvent")})
public class FacturaVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ide_facvent")
    private Integer ideFacvent;
    @Column(name = "clavepago_facvent")
    private Integer clavepagoFacvent;
    @Column(name = "total_facvent")
    private BigInteger totalFacvent;
    @Column(name = "fecha_facvent")
    @Temporal(TemporalType.DATE)
    private Date fechaFacvent;
    @Column(name = "incentivo_facvent")
    private BigInteger incentivoFacvent;
    @JoinColumn(name = "ide_vend", referencedColumnName = "ide_vend")
    @ManyToOne
    private Vendedores ideVend;
    @OneToMany(mappedBy = "ideFacvent")
    private Collection<FacturaDetalleVenta> facturaDetalleVentaCollection;

    public FacturaVenta() {
    }

    public FacturaVenta(Integer ideFacvent) {
        this.ideFacvent = ideFacvent;
    }

    public Integer getIdeFacvent() {
        return ideFacvent;
    }

    public void setIdeFacvent(Integer ideFacvent) {
        this.ideFacvent = ideFacvent;
    }

    public Integer getClavepagoFacvent() {
        return clavepagoFacvent;
    }

    public void setClavepagoFacvent(Integer clavepagoFacvent) {
        this.clavepagoFacvent = clavepagoFacvent;
    }

    public BigInteger getTotalFacvent() {
        return totalFacvent;
    }

    public void setTotalFacvent(BigInteger totalFacvent) {
        this.totalFacvent = totalFacvent;
    }

    public Date getFechaFacvent() {
        return fechaFacvent;
    }

    public void setFechaFacvent(Date fechaFacvent) {
        this.fechaFacvent = fechaFacvent;
    }

    public BigInteger getIncentivoFacvent() {
        return incentivoFacvent;
    }

    public void setIncentivoFacvent(BigInteger incentivoFacvent) {
        this.incentivoFacvent = incentivoFacvent;
    }

    public Vendedores getIdeVend() {
        return ideVend;
    }

    public void setIdeVend(Vendedores ideVend) {
        this.ideVend = ideVend;
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
        hash += (ideFacvent != null ? ideFacvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaVenta)) {
            return false;
        }
        FacturaVenta other = (FacturaVenta) object;
        if ((this.ideFacvent == null && other.ideFacvent != null) || (this.ideFacvent != null && !this.ideFacvent.equals(other.ideFacvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.FacturaVenta[ ideFacvent=" + ideFacvent + " ]";
    }
    
}
