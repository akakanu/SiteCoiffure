/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import jcoiffure.Idbc;

/**
 *
 * @author Alex
 */
public abstract class Managed {

    @EJB
    protected Idbc dao;

    public void getException(String message, Throwable ex) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, message, ex);
    }

    public void getMessage(String message, String detail, FacesMessage.Severity severity) {
        FacesMessage msg = new FacesMessage(severity, message, detail);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void getErrorMessage(String message, String detail) {
        getMessage(message, detail, FacesMessage.SEVERITY_ERROR);
    }

    public void getErrorMessage(String message) {
        getErrorMessage("Erreur", message);
    }

    public void getFatalMessage(String message, String detail) {
        getMessage(message, detail, FacesMessage.SEVERITY_FATAL);
    }

    public void getFatalMessage(String message) {
        getFatalMessage("Attention", message);
    }

    public void getWarningMessage(String message, String detail) {
        getMessage(message, detail, FacesMessage.SEVERITY_WARN);
    }

    public void getWarningMessage(String message) {
        getWarningMessage("Attention", message);
    }

    public void getInfoMessage(String message, String detail) {
        getMessage(message, detail, FacesMessage.SEVERITY_INFO);
    }

    public void getInfoMessage(String message) {
        getInfoMessage("Information", message);
    }

    public void succes() {
        getInfoMessage("Succes !");
    }

}
