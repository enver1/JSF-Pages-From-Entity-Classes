package ejb;

import entidad.FacturaVenta;
import ejb.util.JsfUtil;
import ejb.util.JsfUtil.PersistAction;
import entidad.Articulos;
import entidad.FacturaDetalleVenta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "facturaVentaController")
@SessionScoped
public class FacturaVentaController implements Serializable {

    @EJB
    private ejb.FacturaVentaFacade ejbFacade;
    private List<FacturaVenta> items = null;
    private FacturaVenta selected;

    public FacturaVentaController() {
    }

    public FacturaVenta getSelected() {
        return selected;
    }

    public void setSelected(FacturaVenta selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FacturaVentaFacade getFacade() {
        return ejbFacade;
    }

    public FacturaVenta prepareCreate() {
        selected = new FacturaVenta();
        
        initializeEmbeddableKey();
        return selected;
    }


    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FacturaVentaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FacturaVentaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<FacturaVenta> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<FacturaVenta> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<FacturaVenta> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = FacturaVenta.class)
    public static class FacturaVentaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FacturaVentaController controller = (FacturaVentaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "facturaVentaController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof FacturaVenta) {
                FacturaVenta o = (FacturaVenta) object;
                return getStringKey(o.getIdeFacvent());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FacturaVenta.class.getName()});
                return null;
            }
        }

    }

    List<FacturaDetalleVenta> detalle = new ArrayList<FacturaDetalleVenta>();
    Articulos articulo_seleccionado;
    public void addFila(ActionEvent evt) {
        //Los servicios de matbodega y los otros de inv inventarios 
        System.out.print("metodo addFila");
        if (articulo_seleccionado != null) {
            System.out.println("articulo seleccionasdo:" + articulo_seleccionado.getNombreArt());
            FacturaDetalleVenta fila = new FacturaDetalleVenta();
            fila.setIdeArt(articulo_seleccionado);
//                fila.setCantidadFacdetven(articulo_seleccionado.getIdeArt());
            detalle.add(fila);
            articulo_seleccionado = null;
        }
    }

    public void create() {
        if (selected.getIdeFacvent() != 0) {
//            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FacturaVentaCreated"));
            ejbFacade.guardarFac(selected);
          
            for (int i = 0; i < detalle.size(); i++) {

                FacturaDetalleVenta aux=detalle.get(i);

                System.out.println("aux::: " + detalle.get(i).getCantidadFacdetven());
                aux.setIdeFacvent(selected);
                ejbFacade.guardarDetalle(aux);
//                  persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FacturaDetalleVentaCreated"));

            }
        }

        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<FacturaDetalleVenta> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<FacturaDetalleVenta> detalle) {
        this.detalle = detalle;
    }

    public Articulos getArticulo_seleccionado() {
        return articulo_seleccionado;
    }

    public void setArticulo_seleccionado(Articulos articulo_seleccionado) {
        this.articulo_seleccionado = articulo_seleccionado;
    }

}
