/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author casa
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByIdeInve", query = "SELECT i FROM Inventario i WHERE i.ideInve = :ideInve"),
    @NamedQuery(name = "Inventario.findByTotalInve", query = "SELECT i FROM Inventario i WHERE i.totalInve = :totalInve"),
    @NamedQuery(name = "Inventario.findByIncentivoInve", query = "SELECT i FROM Inventario i WHERE i.incentivoInve = :incentivoInve")})
public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ide_inve")
    private Integer ideInve;
    @Column(name = "total_inve")
    private BigInteger totalInve;
    @Column(name = "incentivo_inve")
    private BigInteger incentivoInve;
    @JoinColumn(name = "ide_facdetven", referencedColumnName = "ide_facdetven")
    @ManyToOne
    private FacturaDetalleVenta ideFacdetven;
    @JoinColumn(name = "ide_vend", referencedColumnName = "ide_vend")
    @ManyToOne
    private Vendedores ideVend;

    public Inventario() {
    }

    public Inventario(Integer ideInve) {
        this.ideInve = ideInve;
    }

    public Integer getIdeInve() {
        return ideInve;
    }

    public void setIdeInve(Integer ideInve) {
        this.ideInve = ideInve;
    }

    public BigInteger getTotalInve() {
        return totalInve;
    }

    public void setTotalInve(BigInteger totalInve) {
        this.totalInve = totalInve;
    }

    public BigInteger getIncentivoInve() {
        return incentivoInve;
    }

    public void setIncentivoInve(BigInteger incentivoInve) {
        this.incentivoInve = incentivoInve;
    }

    public FacturaDetalleVenta getIdeFacdetven() {
        return ideFacdetven;
    }

    public void setIdeFacdetven(FacturaDetalleVenta ideFacdetven) {
        this.ideFacdetven = ideFacdetven;
    }

    public Vendedores getIdeVend() {
        return ideVend;
    }

    public void setIdeVend(Vendedores ideVend) {
        this.ideVend = ideVend;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideInve != null ? ideInve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.ideInve == null && other.ideInve != null) || (this.ideInve != null && !this.ideInve.equals(other.ideInve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Inventario[ ideInve=" + ideInve + " ]";
    }
    
}
