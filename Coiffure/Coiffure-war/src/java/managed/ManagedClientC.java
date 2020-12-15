/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import bean.ClientsC;
import bean.TiersC;
import dbc.Client;
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
public class ManagedClientC extends Managed implements Serializable {
    
    private ClientsC clientsc = new ClientsC();
    
    private List<Client> listclients = new ArrayList<>();
    
    public ManagedClientC() {
    }
    
    public ClientsC getClientsc() {
        return clientsc;
    }
    
    public void setClientsc(ClientsC clientsc) {
        this.clientsc = clientsc;
    }
    
    public List<Client> getListclients() {
        return listclients;
    }
    
    public void setListclients(List<Client> listclients) {
        this.listclients = listclients;
    }
    
    public void loadListClients() {
        listclients = dao.list("Client.findAll", new String[]{}, new Object[]{});
    }
    
    public void saveClientC() {
        Client client = new Client();
        
        int id = clientsc.getId();
        String adresse = clientsc.getAdresse();
        String nom = clientsc.getTiers().getNom();
        String prenom = clientsc.getTiers().getPrenom();
        //affecter le client au tiers
        Tiers tiersid = new Tiers(clientsc.getTiers().getId());
        
        tiersid.setNom(nom);
        tiersid.setPrenom(prenom);
        
        client.setId(id);
        client.setAddresse(adresse);
        client.setTiersId(tiersid);
        
        if (id > 0) {
            dao.update(tiersid);
            dao.update(client);
        } else {
            
            Tiers tierclient = (Tiers) dao.one("Tiers.findByNomPrenom", new String[]{"name", "prenom"}, new Object[]{nom, prenom});//
//            System.out.println(tierclient);
            if (tierclient != null ? tierclient.getId() < 1 : true) {//tiers inexistant
                //creation du tiers//
                tiersid.setId(null);
                tierclient = (Tiers) dao.insert(tiersid);
            } else {//tiers existe
                Client cli = (Client) dao.one("Client.findByTiersId", new String[]{"tiersid"}, new Object[]{tierclient});//
//                System.out.println(cli);
                if (cli != null ? cli.getId() > 0 : false) {
                    getErrorMessage("Ce tiers est deja rattaché à un client");
                    return;
                }
            }
            client.setTiersId(tierclient);
            client.setId(null);
            client = (Client) dao.insert(client);
        }
        int id1 = client.getId();
        clientsc.setId(id1);
        int index = listclients.indexOf(client);
        if (index > -1) {
            listclients.set(index, client);
        } else {
            listclients.add(client);
        }
        
        reset();
        succes();
    }
    
    public void reset() {
        clientsc = new ClientsC();
    }
    
    public void delClients(Client pclient) {
        dao.delete(pclient);
        listclients.remove(pclient);
    }
    
    public void unSelectClientc(UnselectEvent ev) {
        reset();
    }
    
    public void selectClientC(SelectEvent ev) {
        Client client = (Client) ev.getObject();
        
        TiersC tierc = new TiersC();
        
        int id = client.getId();
        String adresse = client.getAddresse();
        
        String nom = client.getTiersId().getNom();
        String prenom = client.getTiersId().getPrenom();
        int tierId = client.getTiersId().getId();
        
        tierc.setNom(nom);
        tierc.setPrenom(prenom);
        tierc.setId(tierId);
        
        clientsc.setId(id);
        clientsc.setAdresse(adresse);
        clientsc.setTiers(tierc);       
    }
    
}
