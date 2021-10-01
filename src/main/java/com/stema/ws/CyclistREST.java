/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.ws;

import com.stema.backingbeans.Cyclist;
import com.stema.models.CyclistModelDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.types.ObjectId;

/**
 *
 * @author jerom
 */
@Path("/cyclist")
public class CyclistREST {

    
    //injecter le modele dans le contrôleur
    @EJB
    private CyclistModelDAO cyclistModel;


    @GET
    @Produces(MediaType.TEXT_HTML)
    public String test() {
        return "Serveur CYCLIST WS OK";
    }
    
    


    //READ
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cyclist> read() {
        return cyclistModel.read();
    }

    
    
    
    
    //CREATE
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Cyclist cyclist) {

//        System.out.println("Dans le POST CREATE : " + cyclist);

        //appel du modele
        cyclistModel.create(cyclist);

        //retour de la réponse HTTP
        Response reponse = Response.status(Response.Status.OK).build();
        return reponse;
    }

    
    
    
    
    
    //DELETE
    @DELETE
    @Path("/delete/{_id}")
    public Response delete(@PathParam("_id") String _id) {

        try {
            ObjectId cle = new ObjectId(_id);

            //creer un cycliste correspondant à l'id
            Cyclist cyclist = new Cyclist();
            cyclist.setId(cle);

            //supprimer le cycliste correspondant
            cyclistModel.delete(cyclist);
        } catch (Exception e) {

        }

        //reponse 200 OK
        Response reponse = Response.status(Response.Status.OK).build();
        return reponse;
    }
    
    
    

    //UPDATE
    @PUT
    @Path("/update/{_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Cyclist cyclist,@PathParam("_id") String _id) {
       
        //mettre l'id dans le vehicule en format adapté
        cyclist.setId(new ObjectId(_id));
        //appel du modele
        cyclistModel.update(cyclist);

        //retour de la réponse HTTP
        Response reponse = Response.status(Response.Status.OK).build();
        return reponse;
    }

    

}
