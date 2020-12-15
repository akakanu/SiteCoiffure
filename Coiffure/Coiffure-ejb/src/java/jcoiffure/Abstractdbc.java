/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcoiffure;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alex
 */
public abstract class Abstractdbc<T extends Serializable> {

    @PersistenceContext(unitName = "Coiffure-ejbPU")
    EntityManager em;

    public abstract EntityManager getEm();

    public boolean delete(T tentity) {

        try {
            T tem = getEm().merge(tentity);
            getEm().remove(tem);
            getEm().flush();
            return true;
        } catch (EJBException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public T update(T tentity) {
        try {
            getEm().clear();
            T tem = getEm().merge(tentity);
            getEm().flush();
        return tem;
        } catch (EJBException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return tentity;
    }
    
    public T insert(T tentity) {
        try {
            getEm().persist(tentity);
            getEm().flush();
        } catch (EJBException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return tentity;
    }

    public List<T> list(String nquery, String[] tblnquery, Object[] tblobjet) {
        try {
            getEm().clear();
            Query query = getEm().createNamedQuery(nquery);
            for (int i = 0; i < tblnquery.length; i++) {
                query.setParameter(tblnquery[i], tblobjet[i]);
            }
            return query.getResultList();

        } catch (EJBException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public T one(String nquery, String[] tblnquery, Object[] tblobjet) {
        try {
            getEm().clear();
            Query query = getEm().createNamedQuery(nquery);
            for (int i = 0; i < tblnquery.length; i++) {
                query.setParameter(tblnquery[i], tblobjet[i]);
            }
            query.setFirstResult(0);
            query.setMaxResults(1);
            try{
                return (T)query.getSingleResult();
            }catch(Exception e){
                return null;
            }
        } catch (EJBException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
