/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbc;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "Localisation", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Localisation.findAll", query = "SELECT l FROM Localisation l")
    , @NamedQuery(name = "Localisation.findById", query = "SELECT l FROM Localisation l WHERE l.id = :id")
    , @NamedQuery(name = "Localisation.findByLibelle", query = "SELECT l FROM Localisation l WHERE l.libelle = :libelle")
    , @NamedQuery(name = "Localisation.findByCout", query = "SELECT l FROM Localisation l WHERE l.cout = :cout")})
public class Localisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "libelle")
    private Character libelle;
    @Column(name = "cout")
    private Integer cout;
    @OneToMany(mappedBy = "localisationId")
    private List<Vente> venteList;

    public Localisation() {
    }

    public Localisation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getLibelle() {
        return libelle;
    }

    public void setLibelle(Character libelle) {
        this.libelle = libelle;
    }

    public Integer getCout() {
        return cout;
    }

    public void setCout(Integer cout) {
        this.cout = cout;
    }

    public List<Vente> getVenteList() {
        return venteList;
    }

    public void setVenteList(List<Vente> venteList) {
        this.venteList = venteList;
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
        if (!(object instanceof Localisation)) {
            return false;
        }
        Localisation other = (Localisation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Localisation[ id=" + id + " ]";
    }
    
}
