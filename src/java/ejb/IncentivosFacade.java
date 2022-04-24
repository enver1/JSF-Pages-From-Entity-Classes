/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidad.Incentivos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author casa
 */
@Stateless
public class IncentivosFacade extends AbstractFacade<Incentivos> {
    @PersistenceContext(unitName = "practico1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncentivosFacade() {
        super(Incentivos.class);
    }
    
}
