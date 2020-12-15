/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Alex
 */
@Named
@SessionScoped
public class ClientsC implements Serializable {
    
    private int id;
    private String adresse;
    private TiersC tiers = new TiersC();

    
    public ClientsC() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public TiersC getTiers() {
        return tiers;
    }

    public void setTiers(TiersC tiers) {
        this.tiers = tiers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.adresse);
        hash = 31 * hash + Objects.hashCode(this.tiers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientsC other = (ClientsC) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.tiers, other.tiers)) {
            return false;
        }
        return true;
    }

    
    
       
    
}
