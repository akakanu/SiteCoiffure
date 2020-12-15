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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "Fournisseur", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f")
    , @NamedQuery(name = "Fournisseur.findByAddresse", query = "SELECT f FROM Fournisseur f WHERE f.addresse = :addresse")
    , @NamedQuery(name = "Fournisseur.findByTiersId", query = "SELECT f FROM Fournisseur f WHERE f.tiersid = :tiersid")
    , @NamedQuery(name = "Fournisseur.findById", query = "SELECT f FROM Fournisseur f WHERE f.id = :id")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "addresse")
    private String addresse;
    @JoinColumn(name = "tiersid", referencedColumnName = "id")
    @ManyToOne
    private Tiers tiersid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Fournisseur() {
    }

    public Fournisseur(Integer id) {
        this.id = id;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public Tiers getTiersId() {
        return tiersid;
    }

    public void setTiersId(Tiers tiersId) {
        this.tiersid = tiersId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Fournisseur[ id=" + id + " ]";
    }
    
}
