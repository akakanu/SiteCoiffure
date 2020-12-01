/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import bean.UsersC;
import dbc.Niveauacces;
import dbc.Tiers;
import dbc.Utilisateur;
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
public class ManagedUsersC extends Managed implements Serializable {

    private UsersC usersc = new UsersC();
    List<Utilisateur> listutilisateurs = new ArrayList<>();

    public ManagedUsersC() {
    }

    public UsersC getUsersc() {
        return usersc;
    }

    public void setUsersc(UsersC usersc) {
        this.usersc = usersc;
    }

    public List<Utilisateur> getListutilisateurs() {
        return listutilisateurs;
    }

    public void setListutilisateurs(List<Utilisateur> listutilisateurs) {
        this.listutilisateurs = listutilisateurs;
    }

    public void loadListUsersc() {
        listutilisateurs = dao.list("Utilisateur.findAll", new String[]{}, new Object[]{});
    }
    
    public void reset(){
    usersc = new UsersC();
    }

    public void saveUsersC() {
        Utilisateur utilisateur = new Utilisateur();
        int id = usersc.getId();
        String code = usersc.getCode();
        String motpasse = usersc.getMotpasse();
        Tiers tiersId = new Tiers(usersc.getId());
        Niveauacces niveauaccesId = new Niveauacces(usersc.getId());

        utilisateur.setId(id);
        utilisateur.setCode(code);
        utilisateur.setMotPasse(motpasse);
        utilisateur.setNiveauAccesId(niveauaccesId);
        utilisateur.setTiersId(tiersId);

        if (id > 0) {
            dao.update(utilisateur);
        } else {
            utilisateur.setId(null);
            utilisateur = (Utilisateur)dao.insert(utilisateur);
        }
        int id1 = utilisateur.getId();
        usersc.setId(id1);
        int index = listutilisateurs.indexOf(utilisateur);
        if(index > -1){
        listutilisateurs.set(index, utilisateur);
        }else{
        listutilisateurs.add(utilisateur);
        }        
        
        reset();
        succes();       
    }
    
    public void delUserC(Utilisateur utilisateur){
    dao.delete(utilisateur);
    listutilisateurs.remove(utilisateur);
    }
    
    public void selectUserC(SelectEvent ev){
        Utilisateur utilisateur = (Utilisateur)ev.getObject();
        int id = utilisateur.getId();
        String code = utilisateur.getCode();
        String motpasse = utilisateur.getMotPasse();
        Tiers tierId = new Tiers(utilisateur.getId());
        Niveauacces niveauaccesId = new Niveauacces(utilisateur.getId());
        
        usersc.setId(id);
        usersc.setCode(code);
        usersc.setMotpasse(motpasse);
        usersc.setTiersId(tierId);
        usersc.setNiveauAccesId(niveauaccesId);       
    }
    
    public void unSelectUserc(UnselectEvent ev){
        reset();
    }

}
