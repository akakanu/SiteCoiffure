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
public class FournisseursC implements Serializable {
    
    private int id;
    private String adresse;
    private TiersC tiersc = new TiersC();
    
    public FournisseursC() {
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

    public TiersC getTiersc() {
        return tiersc;
    }

    public void setTiersc(TiersC tiersc) {
        this.tiersc = tiersc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.adresse);
        hash = 89 * hash + Objects.hashCode(this.tiersc);
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
        final FournisseursC other = (FournisseursC) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.tiersc != other.tiersc) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        return true;
    }
    
}
