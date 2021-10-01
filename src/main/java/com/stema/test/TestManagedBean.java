/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.test;

import com.stema.backingbeans.Cyclist;
import com.stema.models.CyclistModelDAO;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.bson.types.ObjectId;

/**
 *
 * @author jerom
 */
@Named(value = "testManagedBean")
@Dependent
public class TestManagedBean {

    
    @EJB
    private CyclistModelDAO cyclistModel;
    
    
    
    /**
     * Creates a new instance of TestManagedBean
     */
    public TestManagedBean() {
        
    }
    
    
    public void testCreateCyclist(){
        System.out.println("Je suis dans testCreateCyclist");
        
        //créer un cycliste
        Cyclist cyclist=new Cyclist();
        cyclist.setFirstName("LAFOSSE"+new Date());
        cyclist.setLastName("JEROME");
        
        //enregisqtrer le cycliste
        cyclistModel.create(cyclist);
    }
    
    
    
    public void testReadCyclist(){
        System.out.println("Je suis dans testReadCyclist");
        //enregisqtrer le cycliste
        List<Cyclist> listeCyclists=cyclistModel.read();
        //afficher les cyclistes
        for(Cyclist c:listeCyclists){
            System.out.println(c);
        }
    }
    
    
    public void testUpdateCyclist(){
        System.out.println("Je suis dans testUpdateCyclist");
        
        //créer un cycliste
        Cyclist cyclist=cyclistModel.find(new ObjectId("61419d7211390062b7543f2e"));
        
        
        cyclist.setFirstName("MARTIN"+new Date());
        cyclist.setLastName("PIERRE");
        
        
        cyclistModel.update(cyclist);       
    }
    
    
    
    
   public void testDeleteCyclist(){
        System.out.println("Je suis dans testDeleteCyclist");
        
         //créer un cycliste
        Cyclist cyclist=cyclistModel.find(new ObjectId("61419d6911390062b7543f25"));
        
        //enregisqtrer le cycliste
        cyclistModel.delete(cyclist);
    } 
    
    
    
    
}
