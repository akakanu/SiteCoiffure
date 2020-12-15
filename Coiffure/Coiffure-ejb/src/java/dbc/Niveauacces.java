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
@Table(name = "niveau_acces", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Niveauacces.findAll", query = "SELECT n FROM Niveauacces n")
    , @NamedQuery(name = "Niveauacces.findById", query = "SELECT n FROM Niveauacces n WHERE n.id = :id")
    , @NamedQuery(name = "Niveauacces.findByLibelle", query = "SELECT n FROM Niveauacces n WHERE n.libelle = :libelle")})
public class Niveauacces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "libelle")
    private String libelle;

    public Niveauacces() {
    }

    public Niveauacces(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id != null ? id : 0;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
