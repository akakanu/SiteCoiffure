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
@Table(name = "Achat", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Achat.findAll", query = "SELECT a FROM Achat a")
    , @NamedQuery(name = "Achat.findById", query = "SELECT a FROM Achat a WHERE a.id = :id")
    , @NamedQuery(name = "Achat.findByReference", query = "SELECT a FROM Achat a WHERE a.reference = :reference")
    , @NamedQuery(name = "Achat.findByDateAchat", query = "SELECT a FROM Achat a WHERE a.dateAchat = :dateAchat")})
public class Achat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    @Column(name = "dateAchat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAchat;
    @OneToMany(mappedBy = "achatId")
    private List<Contenuachat> contenuachatList;
    @JoinColumn(name = "fournisseurId", referencedColumnName = "Id")
    @ManyToOne
    private Fournisseur fournisseurId;

    public Achat() {
    }

    public Achat(Integer id) {
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

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public List<Contenuachat> getContenuachatList() {
        return contenuachatList;
    }

    public void setContenuachatList(List<Contenuachat> contenuachatList) {
        this.contenuachatList = contenuachatList;
    }

    public Fournisseur getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Fournisseur fournisseurId) {
        this.fournisseurId = fournisseurId;
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
        if (!(object instanceof Achat)) {
            return false;
        }
        Achat other = (Achat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Achat[ id=" + id + " ]";
    }
    
}
