/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcoiffure;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Alex
 */
@Local
public interface Idbc<T extends Serializable> {
   
    public boolean delete(T tentity);
    public T update(T tentity);
    public T insert(T tentity);
    public List<T> list(String nquery, String[] tblnquery, Object[] tblobject);
    public T one(String nquery, String[] tblnquery, Object[] tblobject);
    public EntityManager getEm();   
    
}    
