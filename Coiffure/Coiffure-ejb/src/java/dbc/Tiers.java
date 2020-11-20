/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbc;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Tiers", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Tiers.findAll", query = "SELECT t FROM Tiers t")
    , @NamedQuery(name = "Tiers.findByNom", query = "SELECT t FROM Tiers t WHERE t.nom = :nom")
    , @NamedQuery(name = "Tiers.findByPrenom", query = "SELECT t FROM Tiers t WHERE t.prenom = :prenom")
    , @NamedQuery(name = "Tiers.findById", query = "SELECT t FROM Tiers t WHERE t.id = :id")})
public class Tiers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nom")
    private Character nom;
    @Column(name = "prenom")
    private Character prenom;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tiers")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "tiersId")
    private List<Client> clientList;
    @OneToMany(mappedBy = "tiersId")
    private List<Utilisateur> utilisateurList;

    public Tiers() {
    }

    public Tiers(Integer id) {
        this.id = id;
    }

    public Character getNom() {
        return nom;
    }

    public void setNom(Character nom) {
        this.nom = nom;
    }

    public Character getPrenom() {
        return prenom;
    }

    public void setPrenom(Character prenom) {
        this.prenom = prenom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
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
