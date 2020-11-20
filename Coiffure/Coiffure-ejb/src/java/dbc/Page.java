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
@Table(name = "Page", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Page.findAll", query = "SELECT p FROM Page p")
    , @NamedQuery(name = "Page.findById", query = "SELECT p FROM Page p WHERE p.id = :id")
    , @NamedQuery(name = "Page.findByCode", query = "SELECT p FROM Page p WHERE p.code = :code")
    , @NamedQuery(name = "Page.findByLibelle", query = "SELECT p FROM Page p WHERE p.libelle = :libelle")})
public class Page implements Serializable {

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
    @OneToMany(mappedBy = "pageId")
    private List<Ressource> ressourceList;
    @OneToMany(mappedBy = "pageId")
    private List<Accespage> accespageList;

    public Page() {
    }

    public Page(Integer id) {
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

    public List<Ressource> getRessourceList() {
        return ressourceList;
    }

    public void setRessourceList(List<Ressource> ressourceList) {
        this.ressourceList = ressourceList;
    }

    public List<Accespage> getAccespageList() {
        return accespageList;
    }

    public void setAccespageList(List<Accespage> accespageList) {
        this.accespageList = accespageList;
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
        if (!(object instanceof Page)) {
            return false;
        }
        Page other = (Page) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Page[ id=" + id + " ]";
    }
    
}
