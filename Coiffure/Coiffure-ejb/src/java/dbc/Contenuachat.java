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
@Table(name = "Contenu_achat", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Contenuachat.findAll", query = "SELECT c FROM Contenuachat c")
    , @NamedQuery(name = "Contenuachat.findById", query = "SELECT c FROM Contenuachat c WHERE c.id = :id")
    , @NamedQuery(name = "Contenuachat.findByQuantite", query = "SELECT c FROM Contenuachat c WHERE c.quantite = :quantite")})
public class Contenuachat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "quantite")
    private Integer quantite;
    @JoinColumn(name = "achatId", referencedColumnName = "Id")
    @ManyToOne
    private Achat achatId;
    @JoinColumn(name = "articleId", referencedColumnName = "Id")
    @ManyToOne
    private Article articleId;

    public Contenuachat() {
    }

    public Contenuachat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Achat getAchatId() {
        return achatId;
    }

    public void setAchatId(Achat achatId) {
        this.achatId = achatId;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
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
        if (!(object instanceof Contenuachat)) {
            return false;
        }
        Contenuachat other = (Contenuachat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Contenuachat[ id=" + id + " ]";
    }
    
}
