/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.managedbeans;

import com.stema.backingbeans.Cyclist;
import com.stema.models.CyclistModelDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jerom
 */
@Named(value = "cyclistManagedBean")
@RequestScoped
public class CyclistManagedBean {
    
    //mon modele
    @EJB
    private CyclistModelDAO cyclistModel;
    
    
    
    //mon bakcing bean
    private Cyclist cyclist=new Cyclist();
    
    //liste de cyclistes
    private List<Cyclist> listeCyclists;
    
    
    

    /**
     * Creates a new instance of CyclistManagedBean
     */
    public CyclistManagedBean() {
    }
    
    
    //formulaire d'edition
    public String formEdit(Cyclist cyclist){
        //backingbean c'est mon cycliste sélectionné
        this.cyclist=cyclist;
        //redirection
        return "editCyclist";
    }
    
    
    public String edit(){
        
        //creation du cycliste par le modèle
        if(cyclist.getId()!=null){
            cyclistModel.update(cyclist);
        }else {
         cyclistModel.create(cyclist);   
        }
        
        
        
        //mon message
        FacesMessage succes=new FacesMessage(FacesMessage.SEVERITY_INFO,"Merci d'avoir édité le cycliste : "+cyclist.getFirstName()+" "+cyclist.getLastName(),"Un mail vous sera envoyé prochainement");
        //ajouter à la pile des messages
        FacesContext.getCurrentInstance().addMessage("succes", succes);
        
        //vider le cycliste
        cyclist=new Cyclist();
        
        //redirection
        return "listCyclist";
    }
    
    

    public Cyclist getCyclist() {
        return cyclist;
    }

    public void setCyclist(Cyclist cyclist) {
        this.cyclist = cyclist;
    }

    public List<Cyclist> getListeCyclists() {
        listeCyclists=cyclistModel.read();
        return listeCyclists;
    }

    public void setListeCyclists(List<Cyclist> listeCyclists) {
        this.listeCyclists = listeCyclists;
    }

    
    public void delete(Cyclist cyclist){
        //mon message
        FacesMessage succes=new FacesMessage(FacesMessage.SEVERITY_INFO,"Merci d'avoir supprimé le cycliste : "+cyclist.getFirstName()+" "+cyclist.getLastName(),"Un mail vous sera envoyé prochainement");
        //ajouter à la pile des messages
        FacesContext.getCurrentInstance().addMessage("succes", succes);
        
        cyclistModel.delete(cyclist);
    }

    
    
    
    
    
    
    
}
