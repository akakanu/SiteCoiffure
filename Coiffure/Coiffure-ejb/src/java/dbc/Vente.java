/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbc;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "Vente", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Vente.findAll", query = "SELECT v FROM Vente v")
    , @NamedQuery(name = "Vente.findById", query = "SELECT v FROM Vente v WHERE v.id = :id")
    , @NamedQuery(name = "Vente.findByReference", query = "SELECT v FROM Vente v WHERE v.reference = :reference")
    , @NamedQuery(name = "Vente.findByDateVente", query = "SELECT v FROM Vente v WHERE v.dateVente = :dateVente")})
public class Vente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    @Column(name = "dateVente")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVente;
    @OneToMany(mappedBy = "venteId")
    private List<Contenuvente> contenuventeList;
    @JoinColumn(name = "clientId", referencedColumnName = "Id")
    @ManyToOne
    private Client clientId;
    @JoinColumn(name = "localisationId", referencedColumnName = "Id")
    @ManyToOne
    private Localisation localisationId;

    public Vente() {
    }

    public Vente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public List<Contenuvente> getContenuventeList() {
        return contenuventeList;
    }

    public void setContenuventeList(List<Contenuvente> contenuventeList) {
        this.contenuventeList = contenuventeList;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Localisation getLocalisationId() {
        return localisationId;
    }

    public void setLocalisationId(Localisation localisationId) {
        this.localisationId = localisationId;
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
        if (!(object instanceof Vente)) {
            return false;
        }
        Vente other = (Vente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Vente[ id=" + id + " ]";
    }
    
}
