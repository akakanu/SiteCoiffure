/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcoiffure;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author Alex
 */
@Stateless
public class Datadbc <T extends Serializable> extends Abstractdbc<T> implements Idbc<T>{

    @Override
    public EntityManager getEm() {
       return em;
    }
    
}
