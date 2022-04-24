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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author casa
 */
@Entity
@Table(name = "vendedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v"),
    @NamedQuery(name = "Vendedores.findByNombreVend", query = "SELECT v FROM Vendedores v WHERE v.nombreVend = :nombreVend"),
    @NamedQuery(name = "Vendedores.findByIdentificacionVend", query = "SELECT v FROM Vendedores v WHERE v.identificacionVend = :identificacionVend"),
    @NamedQuery(name = "Vendedores.findByIdeVend", query = "SELECT v FROM Vendedores v WHERE v.ideVend = :ideVend"),
    @NamedQuery(name = "Vendedores.findByCodigoVend", query = "SELECT v FROM Vendedores v WHERE v.codigoVend = :codigoVend")})
public class Vendedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "nombre_vend")
    private String nombreVend;
    @Size(max = 25)
    @Column(name = "identificacion_vend")
    private String identificacionVend;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ide_vend")
    private Integer ideVend;
    @Size(max = 10)
    @Column(name = "codigo_vend")
    private String codigoVend;
    @OneToMany(mappedBy = "ideVend")
    private Collection<FacturaVenta> facturaVentaCollection;
    @OneToMany(mappedBy = "ideVend")
    private Collection<Inventario> inventarioCollection;

    public Vendedores() {
    }

    public Vendedores(Integer ideVend) {
        this.ideVend = ideVend;
    }

    public String getNombreVend() {
        return nombreVend;
    }

    public void setNombreVend(String nombreVend) {
        this.nombreVend = nombreVend;
    }

    public String getIdentificacionVend() {
        return identificacionVend;
    }

    public void setIdentificacionVend(String identificacionVend) {
        this.identificacionVend = identificacionVend;
    }

    public Integer getIdeVend() {
        return ideVend;
    }

    public void setIdeVend(Integer ideVend) {
        this.ideVend = ideVend;
    }

    public String getCodigoVend() {
        return codigoVend;
    }

    public void setCodigoVend(String codigoVend) {
        this.codigoVend = codigoVend;
    }

    @XmlTransient
    public Collection<FacturaVenta> getFacturaVentaCollection() {
        return facturaVentaCollection;
    }

    public void setFacturaVentaCollection(Collection<FacturaVenta> facturaVentaCollection) {
        this.facturaVentaCollection = facturaVentaCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideVend != null ? ideVend.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedores)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.ideVend == null && other.ideVend != null) || (this.ideVend != null && !this.ideVend.equals(other.ideVend))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Vendedores[ ideVend=" + ideVend + " ]";
    }
    
}
