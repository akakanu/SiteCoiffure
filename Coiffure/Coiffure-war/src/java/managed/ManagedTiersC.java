/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import bean.TiersC;
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
public class ManagedTiersC extends Managed implements Serializable {

    private TiersC tiersc = new TiersC();
    private List<Tiers> listtiers = new ArrayList<>();

    public ManagedTiersC() {
    }

    public TiersC getTiersc() {
        return tiersc;
    }

    public void setTiersc(TiersC tiersc) {
        this.tiersc = tiersc;
    }

    public List<Tiers> getListtiers() {
        return listtiers;
    }

    public void setListtiers(List<Tiers> listtiers) {
        this.listtiers = listtiers;
    }

    public void loadListTiers() {
        listtiers = dao.list("Tiers.findAll", new String[]{}, new Object[]{});
    }

    public void reset() {
        tiersc = new TiersC();
    }

    public void saveTierC() {
        Tiers tiers = new Tiers();

        int id = tiersc.getId();
        String name = tiersc.getNom();
        String surname = tiersc.getPrenom();
        tiers.setId(id);
        tiers.setNom(name);
        tiers.setPrenom(surname);

        if (id > 0) {
        dao.update(tiers);
        }else{
        tiers.setId(null);
        tiers = (Tiers)dao.insert(tiers);
        }
        int id1 = tiers.getId();
        tiersc.setId(id1);
        int index = listtiers.indexOf(tiers);
        if(index > -1){
            listtiers.set(index, tiers);           
        }else{
            listtiers.add(tiers);
        }
        
        reset();
        succes();        
    }
    
    public void delTiers(Tiers ptiers){
        dao.delete(ptiers);
        listtiers.remove(ptiers);
    }
    
    public void unSelectTierc(UnselectEvent ev){
        reset();
    }
    
    public void selectTiersc(SelectEvent ev){
        Tiers tiers = (Tiers)ev.getObject();
        int id = tiers.getId();
        String name = tiers.getNom();
        String surname = tiers.getPrenom();
        
        tiersc = new TiersC();
        tiersc.setId(id);
        tiersc.setNom(name);
        tiersc.setPrenom(surname);
        
    }
}
