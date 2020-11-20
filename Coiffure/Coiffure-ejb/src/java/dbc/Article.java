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
@Table(name = "Article", catalog = "dbcoiffure", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
    , @NamedQuery(name = "Article.findById", query = "SELECT a FROM Article a WHERE a.id = :id")
    , @NamedQuery(name = "Article.findByCode", query = "SELECT a FROM Article a WHERE a.code = :code")
    , @NamedQuery(name = "Article.findByType", query = "SELECT a FROM Article a WHERE a.type = :type")
    , @NamedQuery(name = "Article.findByPua", query = "SELECT a FROM Article a WHERE a.pua = :pua")
    , @NamedQuery(name = "Article.findByPuv", query = "SELECT a FROM Article a WHERE a.puv = :puv")
    , @NamedQuery(name = "Article.findByPhoto", query = "SELECT a FROM Article a WHERE a.photo = :photo")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "code")
    private Character code;
    @Column(name = "type")
    private Integer type;
    @Column(name = "pua")
    private Integer pua;
    @Column(name = "puv")
    private Integer puv;
    @Column(name = "photo")
    private Character photo;
    @OneToMany(mappedBy = "articleId")
    private List<Contenuvente> contenuventeList;
    @OneToMany(mappedBy = "articleId")
    private List<Contenuachat> contenuachatList;

    public Article() {
    }

    public Article(Integer id) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPua() {
        return pua;
    }

    public void setPua(Integer pua) {
        this.pua = pua;
    }

    public Integer getPuv() {
        return puv;
    }

    public void setPuv(Integer puv) {
        this.puv = puv;
    }

    public Character getPhoto() {
        return photo;
    }

    public void setPhoto(Character photo) {
        this.photo = photo;
    }

    public List<Contenuvente> getContenuventeList() {
        return contenuventeList;
    }

    public void setContenuventeList(List<Contenuvente> contenuventeList) {
        this.contenuventeList = contenuventeList;
    }

    public List<Contenuachat> getContenuachatList() {
        return contenuachatList;
    }

    public void setContenuachatList(List<Contenuachat> contenuachatList) {
        this.contenuachatList = contenuachatList;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbc.Article[ id=" + id + " ]";
    }
    
}
