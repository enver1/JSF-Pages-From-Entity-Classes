/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidad.FacturaDetalleVenta;
import entidad.FacturaVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author casa
 */
@Stateless
public class FacturaVentaFacade extends AbstractFacade<FacturaVenta> {
    @PersistenceContext(unitName = "practico1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaVentaFacade() {
        super(FacturaVenta.class);
    }
    
    public void guardarDetalle(FacturaDetalleVenta obj){
        em.persist(obj);
        
    }
    public void guardarFac(FacturaVenta obj){
        em.persist(obj);
    }
    
    
            
            
    
    public int getUltimo(String nomtabla, String campo_codigo) {
        int ultimo = 0;  
            Query q = em.createQuery("select " + campo_codigo + " from " + nomtabla + "  order by " + campo_codigo + " desc");
            if (q.getResultList().isEmpty()) {
                ultimo = 1;
            } else {
                ultimo = Integer.parseInt(q.getResultList().get(0).toString());
                ultimo++;
            }
        return ultimo;
    }
}
    

