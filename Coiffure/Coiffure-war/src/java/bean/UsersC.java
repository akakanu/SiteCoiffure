/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dbc.Niveauacces;
import dbc.Tiers;
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
public class UsersC implements Serializable {
    
    private int id;
    private String code;
    private String motpasse;
    private int tiersId;
    private int niveauAccesId;

    public UsersC() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMotpasse() {
        return motpasse;
    }

    public void setMotpasse(String motpasse) {
        this.motpasse = motpasse;
    }

    public int getTiersId() {
        return tiersId;
    }

    public void setTiersId(int tiersId) {
        this.tiersId = tiersId;
    }

    public int getNiveauAccesId() {
        return niveauAccesId;
    }

    public void setNiveauAccesId(int niveauAccesId) {
        this.niveauAccesId = niveauAccesId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.code);
        hash = 29 * hash + Objects.hashCode(this.motpasse);
        hash = 29 * hash + Objects.hashCode(this.tiersId);
        hash = 29 * hash + Objects.hashCode(this.niveauAccesId);
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
        final UsersC other = (UsersC) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.motpasse, other.motpasse)) {
            return false;
        }
        if (!Objects.equals(this.tiersId, other.tiersId)) {
            return false;
        }
        if (!Objects.equals(this.niveauAccesId, other.niveauAccesId)) {
            return false;
        }
        return true;
    }
    
    
    
}
