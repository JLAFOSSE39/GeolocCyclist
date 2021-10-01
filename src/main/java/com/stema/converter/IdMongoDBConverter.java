/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.bson.types.ObjectId;

/**
 *
 * @author jerom
 */
@FacesConverter("com.stema.converter.IdMongoDBConverter")
public class IdMongoDBConverter implements Converter {

    //methode appelée lors de la lecture de l'ID d'un objet envoyé par un formulaire HTML
    // conversion de formulaire HTML donc STRING vers notre objet perso ObjectId
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        System.out.println("VOICI getAsObject : "+value);
        //en creation on n'a pas d'ID pour le converter
        if(value.equals("")){
            return null;
        }else{
            //on veut un objet de la classe BSON.OBJECTID et pas une String
            ObjectId monObjet=new ObjectId(value);
            return monObjet;
        }
    }

    
    //methode appelée lors de la lecture de l'ID d'un objet. Ex : <h:inputHidden value="#{cyclistManagedBean.cyclist.id}">
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        System.out.println("VOICI getAsString : "+value);
        return value.toString();
    }
}
