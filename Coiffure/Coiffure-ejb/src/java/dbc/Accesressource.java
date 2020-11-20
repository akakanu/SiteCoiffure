/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbc;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "Acces_ressource", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Accesressource.findAll", query = "SELECT a FROM Accesressource a")
    , @NamedQuery(name = "Accesressource.findById", query = "SELECT a FROM Accesressource a WHERE a.id = :id")
    , @NamedQuery(name = "Accesressource.findByAcces", query = "SELECT a FROM Accesressource a WHERE a.acces = :acces")})
public class Accesressource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "acces")
    private Character acces;
    @JoinColumn(name = "niveau_accesId", referencedColumnName = "Id")
    @ManyToOne
    private Niveauacces niveauaccesId;
    @JoinColumn(name = "ressourceId", referencedColumnName = "Id")
    @ManyToOne
    private Ressource ressourceId;

    public Accesressource() {
    }

    public Accesressource(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getAcces() {
        return acces;
    }

    public void setAcces(Character acces) {
        this.acces = acces;
    }

    public Niveauacces getNiveauaccesId() {
        return niveauaccesId;
    }

    public void setNiveauaccesId(Niveauacces niveauaccesId) {
        this.niveauaccesId = niveauaccesId;
    }

    public Ressource getRessourceId() {
        return ressourceId;
    }

    public void setRessourceId(Ressource ressourceId) {
        this.ressourceId = ressourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accesressource)) {
            return false;
        }
        Accesressource other = (Accesressource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Accesressource[ id=" + id + " ]";
    }
    
}
