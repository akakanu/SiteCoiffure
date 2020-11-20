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
@Table(name = "Niveau_acces", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Niveauacces.findAll", query = "SELECT n FROM Niveauacces n")
    , @NamedQuery(name = "Niveauacces.findById", query = "SELECT n FROM Niveauacces n WHERE n.id = :id")
    , @NamedQuery(name = "Niveauacces.findByLibelle", query = "SELECT n FROM Niveauacces n WHERE n.libelle = :libelle")})
public class Niveauacces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "libelle")
    private Character libelle;
    @OneToMany(mappedBy = "niveauaccesId")
    private List<Accesressource> accesressourceList;
    @OneToMany(mappedBy = "niveauaccesId")
    private List<Accespage> accespageList;
    @OneToMany(mappedBy = "niveauAccesId")
    private List<Utilisateur> utilisateurList;

    public Niveauacces() {
    }

    public Niveauacces(Integer id) {
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

    public List<Accesressource> getAccesressourceList() {
        return accesressourceList;
    }

    public void setAccesressourceList(List<Accesressource> accesressourceList) {
        this.accesressourceList = accesressourceList;
    }

    public List<Accespage> getAccespageList() {
        return accespageList;
    }

    public void setAccespageList(List<Accespage> accespageList) {
        this.accespageList = accespageList;
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
        if (!(object instanceof Niveauacces)) {
            return false;
        }
        Niveauacces other = (Niveauacces) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Niveauacces[ id=" + id + " ]";
    }
    
}
