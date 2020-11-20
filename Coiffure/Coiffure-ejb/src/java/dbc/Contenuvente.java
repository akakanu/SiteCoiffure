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
@Table(name = "Contenu_vente", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Contenuvente.findAll", query = "SELECT c FROM Contenuvente c")
    , @NamedQuery(name = "Contenuvente.findById", query = "SELECT c FROM Contenuvente c WHERE c.id = :id")
    , @NamedQuery(name = "Contenuvente.findByQuantite", query = "SELECT c FROM Contenuvente c WHERE c.quantite = :quantite")})
public class Contenuvente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "quantite")
    private Integer quantite;
    @JoinColumn(name = "articleId", referencedColumnName = "Id")
    @ManyToOne
    private Article articleId;
    @JoinColumn(name = "venteId", referencedColumnName = "Id")
    @ManyToOne
    private Vente venteId;

    public Contenuvente() {
    }

    public Contenuvente(Integer id) {
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

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
    }

    public Vente getVenteId() {
        return venteId;
    }

    public void setVenteId(Vente venteId) {
        this.venteId = venteId;
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
        if (!(object instanceof Contenuvente)) {
            return false;
        }
        Contenuvente other = (Contenuvente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Contenuvente[ id=" + id + " ]";
    }
    
}
