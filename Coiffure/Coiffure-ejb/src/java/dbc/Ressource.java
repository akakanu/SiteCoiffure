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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Ressource", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Ressource.findAll", query = "SELECT r FROM Ressource r")
    , @NamedQuery(name = "Ressource.findById", query = "SELECT r FROM Ressource r WHERE r.id = :id")
    , @NamedQuery(name = "Ressource.findByCode", query = "SELECT r FROM Ressource r WHERE r.code = :code")
    , @NamedQuery(name = "Ressource.findByLibelle", query = "SELECT r FROM Ressource r WHERE r.libelle = :libelle")})
public class Ressource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "code")
    private Character code;
    @Column(name = "libelle")
    private Character libelle;
    @JoinColumn(name = "pageId", referencedColumnName = "Id")
    @ManyToOne
    private Page pageId;
    @OneToMany(mappedBy = "ressourceId")
    private List<Accesressource> accesressourceList;

    public Ressource() {
    }

    public Ressource(Integer id) {
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

    public Character getLibelle() {
        return libelle;
    }

    public void setLibelle(Character libelle) {
        this.libelle = libelle;
    }

    public Page getPageId() {
        return pageId;
    }

    public void setPageId(Page pageId) {
        this.pageId = pageId;
    }

    public List<Accesressource> getAccesressourceList() {
        return accesressourceList;
    }

    public void setAccesressourceList(List<Accesressource> accesressourceList) {
        this.accesressourceList = accesressourceList;
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
        if (!(object instanceof Ressource)) {
            return false;
        }
        Ressource other = (Ressource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Ressource[ id=" + id + " ]";
    }
    
}
