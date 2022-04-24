/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author casa
 */
@Entity
@Table(name = "incentivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incentivos.findAll", query = "SELECT i FROM Incentivos i"),
    @NamedQuery(name = "Incentivos.findByIdeInce", query = "SELECT i FROM Incentivos i WHERE i.ideInce = :ideInce"),
    @NamedQuery(name = "Incentivos.findByCodigoInce", query = "SELECT i FROM Incentivos i WHERE i.codigoInce = :codigoInce"),
    @NamedQuery(name = "Incentivos.findByPorcentajeInce", query = "SELECT i FROM Incentivos i WHERE i.porcentajeInce = :porcentajeInce")})
public class Incentivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ide_ince")
    private Integer ideInce;
    @Column(name = "codigo_ince")
    private Integer codigoInce;
    @Column(name = "porcentaje_ince")
    private Integer porcentajeInce;
    @OneToMany(mappedBy = "ideInce")
    private Collection<FacturaDetalleVenta> facturaDetalleVentaCollection;

    public Incentivos() {
    }

    public Incentivos(Integer ideInce) {
        this.ideInce = ideInce;
    }

    public Integer getIdeInce() {
        return ideInce;
    }

    public void setIdeInce(Integer ideInce) {
        this.ideInce = ideInce;
    }

    public Integer getCodigoInce() {
        return codigoInce;
    }

    public void setCodigoInce(Integer codigoInce) {
        this.codigoInce = codigoInce;
    }

    public Integer getPorcentajeInce() {
        return porcentajeInce;
    }

    public void setPorcentajeInce(Integer porcentajeInce) {
        this.porcentajeInce = porcentajeInce;
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
        hash += (ideInce != null ? ideInce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incentivos)) {
            return false;
        }
        Incentivos other = (Incentivos) object;
        if ((this.ideInce == null && other.ideInce != null) || (this.ideInce != null && !this.ideInce.equals(other.ideInce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Incentivos[ ideInce=" + ideInce + " ]";
    }
    
}
