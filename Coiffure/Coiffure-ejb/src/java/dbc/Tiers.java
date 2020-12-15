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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "tiers", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Tiers.findAll", query = "SELECT t FROM Tiers t")
    , @NamedQuery(name = "Tiers.findByNom", query = "SELECT t FROM Tiers t WHERE t.nom = :nom")
    , @NamedQuery(name = "Tiers.findByPrenom", query = "SELECT t FROM Tiers t WHERE t.prenom = :prenom")
    , @NamedQuery(name = "Tiers.findById", query = "SELECT t FROM Tiers t WHERE t.id = :id")
    , @NamedQuery(name = "Tiers.findByNomPrenom", query = "SELECT t FROM Tiers t WHERE t.nom = :name AND t.prenom = :prenom")})
public class Tiers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;

    public Tiers() {
    }

    public Tiers(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getId() {
        return id!=null?id:0;
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
        if (!(object instanceof Tiers)) {
            return false;
        }
        Tiers other = (Tiers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Tiers[ id=" + id + " ]";
    }
    
}
