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
@Table(name = "utilisateur", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findById", query = "SELECT u FROM Utilisateur u WHERE u.id = :id")
    , @NamedQuery(name = "Utilisateur.findByCode", query = "SELECT u FROM Utilisateur u WHERE u.code = :code")
    , @NamedQuery(name = "Utilisateur.findByMotPasse", query = "SELECT u FROM Utilisateur u WHERE u.motpasse = :motpasse")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "motpasse")
    private String motpasse;
    @JoinColumn(name = "niveauaccesid", referencedColumnName = "id")
    @ManyToOne
    private Niveauacces niveauaccesid;
    @JoinColumn(name = "tiersid", referencedColumnName = "id")
    @ManyToOne
    private Tiers tiersid;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMotPasse() {
        return motpasse;
    }

    public void setMotPasse(String motPasse) {
        this.motpasse = motPasse;
    }

    public Niveauacces getNiveauAccesId() {
        return niveauaccesid;
    }

    public void setNiveauAccesId(Niveauacces niveauAccesId) {
        this.niveauaccesid = niveauAccesId;
    }

    public Tiers getTiersId() {
        return tiersid;
    }

    public void setTiersId(Tiers tiersId) {
        this.tiersid = tiersId;
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
