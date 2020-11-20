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
@Table(name = "Acces_page", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Accespage.findAll", query = "SELECT a FROM Accespage a")
    , @NamedQuery(name = "Accespage.findById", query = "SELECT a FROM Accespage a WHERE a.id = :id")
    , @NamedQuery(name = "Accespage.findByAcces", query = "SELECT a FROM Accespage a WHERE a.acces = :acces")})
public class Accespage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "acces")
    private Character acces;
    @JoinColumn(name = "niveau_accesId", referencedColumnName = "Id")
    @ManyToOne
    private Niveauacces niveauaccesId;
    @JoinColumn(name = "page_Id", referencedColumnName = "Id")
    @ManyToOne
    private Page pageId;

    public Accespage() {
    }

    public Accespage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getAcces() {
        return acces;
    }

    public void setAcces(Character acces) {
        this.acces = acces;
    }

    public Niveauacces getNiveauaccesId() {
        return niveauaccesId;
    }

    public void setNiveauaccesId(Niveauacces niveauaccesId) {
        this.niveauaccesId = niveauaccesId;
    }

    public Page getPageId() {
        return pageId;
    }

    public void setPageId(Page pageId) {
        this.pageId = pageId;
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
        if (!(object instanceof Accespage)) {
            return false;
        }
        Accespage other = (Accespage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Accespage[ id=" + id + " ]";
    }
    
}
