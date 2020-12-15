/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import bean.FournisseursC;
import bean.TiersC;
import dbc.Fournisseur;
import dbc.Tiers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Alex
 */
@Named
@SessionScoped
public class ManagedFournisseurC extends Managed implements Serializable {
    
    private FournisseursC fournisseursc = new FournisseursC();
    private List<Fournisseur> listfournisseurs = new ArrayList<>();

    public ManagedFournisseurC() {
    }

    public FournisseursC getFournisseursc() {
        return fournisseursc;
    }

    public void setFournisseursc(FournisseursC fournisseursc) {
        this.fournisseursc = fournisseursc;
    }

    public List<Fournisseur> getListfournisseurs() {
        return listfournisseurs;
    }

    public void setListfournisseurs(List<Fournisseur> listfournisseurs) {
        this.listfournisseurs = listfournisseurs;
    }
    
    public void loadListFournisseurs() {
        listfournisseurs = dao.list("Fournisseur.findAll", new String[]{}, new Object[]{});
    }

    public void reset() {
        fournisseursc = new FournisseursC();
    }
    
    public void delFournisseurs(Fournisseur pfournisseur){
        dao.delete(pfournisseur);
        listfournisseurs.remove(pfournisseur);
    }
    
    public void unSelectFournisseurc(UnselectEvent ev){
        reset();
    }
    
    public void saveFournisseurs(){
    
        Fournisseur fournisseur = new Fournisseur();        
        int id = fournisseursc.getId();
        String adresse = fournisseursc.getAdresse();
        
        String nom = fournisseursc.getTiersc().getNom();
        String prenom = fournisseursc.getTiersc().getPrenom();        
        
        Tiers tiersfournis = new Tiers(fournisseursc.getTiersc().getId());             
        tiersfournis.setNom(nom);
        tiersfournis.setPrenom(prenom);
        
        fournisseur.setId(id);
        fournisseur.setAddresse(adresse);
        fournisseur.setTiersId(tiersfournis);
        //si le fournisseur existe déjà
        if(id > 0){
        dao.update(tiersfournis);
        dao.update(fournisseur);
        }else{//vérifier si il y a dans la bd un tiers avec ce nom&prenom si oui le rattacher au fsseur 
        Tiers tierswithnp = (Tiers)dao.one("Tiers.findByNomPrenom", new String[]{"name", "prenom"}, new Object[]{nom, prenom});
            if(tierswithnp != null? tierswithnp.getId() < 1 : true){
                tiersfournis.setId(null);
                tiersfournis = (Tiers)dao.insert(tiersfournis);
            }else{
                Fournisseur fsseurwithidtiers = (Fournisseur)dao.one("Fournisseur.findByTiersId", new String[]{"tiersid"}, new Object[]{tierswithnp});
                if(fsseurwithidtiers != null ? fsseurwithidtiers.getId() > 0 : false){
                    getErrorMessage("Ce tiers est deja rattaché à un fournisseur");
                    return;
                }  
            }
            fournisseur.setTiersId(tiersfournis);
            fournisseur.setId(null);
            fournisseur = (Fournisseur) dao.insert(fournisseur);  
        }
         int id1 = fournisseur.getId();
        fournisseursc.setId(id1);
        int index = listfournisseurs.indexOf(fournisseur);
        if (index > -1) {
            listfournisseurs.set(index, fournisseur);
        } else {
            listfournisseurs.add(fournisseur);
        }        
        reset();
        succes();        
    } 
    
    public void selectFournisseursc(SelectEvent ev) {
        Fournisseur fournisseur = (Fournisseur) ev.getObject();
        
        TiersC tierc = new TiersC();
        
        int id = fournisseur.getId();
        String adresse = fournisseur.getAddresse();
        
        String nom = fournisseur.getTiersId().getNom();
        String prenom = fournisseur.getTiersId().getPrenom();
        int tierId = fournisseur.getTiersId().getId();
        
        tierc.setNom(nom);
        tierc.setPrenom(prenom);
        tierc.setId(tierId);
        
        fournisseursc.setId(id);
        fournisseursc.setAdresse(adresse);
        fournisseursc.setTiersc(tierc);
        
    }
}
