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
@Table(name = "Utilisateur", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findById", query = "SELECT u FROM Utilisateur u WHERE u.id = :id")
    , @NamedQuery(name = "Utilisateur.findByCode", query = "SELECT u FROM Utilisateur u WHERE u.code = :code")
    , @NamedQuery(name = "Utilisateur.findByMotPasse", query = "SELECT u FROM Utilisateur u WHERE u.motPasse = :motPasse")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "code")
    private Character code;
    @Column(name = "motPasse")
    private Character motPasse;
    @JoinColumn(name = "niveauAccesId", referencedColumnName = "Id")
    @ManyToOne
    private Niveauacces niveauAccesId;
    @JoinColumn(name = "tiersId", referencedColumnName = "Id")
    @ManyToOne
    private Tiers tiersId;

    public Utilisateur() {
    }

    public Utilisateur(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getCode() {
        return code;
    }

    public void setCode(Character code) {
        this.code = code;
    }

    public Character getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(Character motPasse) {
        this.motPasse = motPasse;
    }

    public Niveauacces getNiveauAccesId() {
        return niveauAccesId;
    }

    public void setNiveauAccesId(Niveauacces niveauAccesId) {
        this.niveauAccesId = niveauAccesId;
    }

    public Tiers getTiersId() {
        return tiersId;
    }

    public void setTiersId(Tiers tiersId) {
        this.tiersId = tiersId;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Utilisateur[ id=" + id + " ]";
    }
    
}
