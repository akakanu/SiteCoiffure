/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import bean.Niveau;
import dbc.Niveauacces;
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
public class ManagedNiveau extends Managed implements Serializable {

    private Niveau niveau = new Niveau();
    private List<Niveauacces> listniv = new ArrayList<>();

    public ManagedNiveau() {
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public List<Niveauacces> getListniv() {
        return listniv;
    }

    public void setListniv(List<Niveauacces> listniv) {
        this.listniv = listniv;
    }

    public void loadListniv() {
        listniv = dao.list("Niveauacces.findAll", new String[]{}, new Object[]{});
    }

    public void reset() {
        niveau = new Niveau();
    }
    
    //inserer et mettre à jour
    public void saveNiveau() {
        Niveauacces nivacces = new Niveauacces();
        nivacces.setId(niveau.getId());
        nivacces.setLibelle(niveau.getLibelle());
        if (niveau.getId() > 0) {
            dao.update(nivacces);
        } else {
            nivacces.setId(null);
            nivacces = (Niveauacces) dao.insert(nivacces);
        }
        niveau.setId(nivacces.getId());
        //vérifier si la liste est vide avant d'ajouter a la liste
        int index = listniv.indexOf(nivacces);
        if (index > -1) {
            listniv.set(index, nivacces);
        } else {
            listniv.add(nivacces);
        }
        reset();
        succes();
    }

    public void delNiveau(Niveauacces pniveau) {
        dao.delete(pniveau);
        listniv.remove(pniveau);
    }

    public void unselectNiveau(UnselectEvent ev) {
        reset();
    }

    public void selectNiveau(SelectEvent sev) {
        //l'evenement recupere une instance du niveauacces dans la bd sous forme d'objet 
        Niveauacces nivac = (Niveauacces) sev.getObject();
        niveau = new Niveau();
        niveau.setId(nivac.getId());
        niveau.setLibelle(nivac.getLibelle());
    }
}
