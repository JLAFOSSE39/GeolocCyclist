/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.models;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.stema.backingbeans.Cyclist;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author jerom
 */
@Stateless
public class CyclistModelDAO {

    // injecter l'EJB Singleton de connexion
    @EJB
    private MongoClientProvider mongoClientProvider;

    // variables mongodb
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Cyclist> collection;

    //methode lancée à l'initialisation
    @PostConstruct
    public void init() {
        mongoClient = mongoClientProvider.getMongoClient();
        //Mongo document to POJO conversion
        CodecRegistry codecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        //ouverture
        mongoDatabase = mongoClient.getDatabase("GeolocCyclist").withCodecRegistry(codecRegistry);
        collection = mongoDatabase.getCollection("cyclist", Cyclist.class);
    }

    // créer un objet
    public void create(Cyclist cyclist) {
        collection.insertOne(cyclist);
    }

    //lire mes enregistrements
    public List<Cyclist> read() {
        List<Cyclist> liste = new ArrayList<>();
        collection.find().iterator().forEachRemaining(liste::add);
        return liste;
    }

    // modifier un objet
    public void update(Cyclist cyclist) {
        //objet à modifier a partir de son ID
        Bson cle = eq("_id", new ObjectId(cyclist.getId().toString()));
        //remplacer l'objet concerné
        collection.findOneAndReplace(cle, cyclist);
    }

    //supprimer un enregistrement
    public void delete(Cyclist cyclist) {
        collection.deleteOne(eq("_id", cyclist.getId()));
    }

    //retourner un objet à partir d'un cycliste
    public Cyclist find(ObjectId id) {
        Cyclist c = (Cyclist) collection.find(eq("_id", id)).first();
        return c;
    }
    
    
    
    
    
    

    /*

    
    
     //collection.findOneAndReplace(eq("_id", vehicule.getId()), vehicule);
    //lire mes enregistrements
    public List<Vehicule> read(){
        List<Vehicule> liste=new ArrayList<>();
        collection.find().iterator().forEachRemaining(liste::add);
        return liste;
    }
    
    
    
    
    
    
    //retourner un objet à partir d'un vehicule
    public Vehicule find(ObjectId id) {       
        Vehicule v = (Vehicule) collection.find(eq("_id", id)).first();
        return v;
    }
    
    
     */
 /*
        public void create(Vehicule vehicule) {
//        Document document = new Document();
//        document.put("immatriculation", vehicule.getImmatriculation());
//        document.put("description", vehicule.getDescription());
//        document.put("dateAchat", vehicule.getDateAchat());
//        document.put("tarifActuel", vehicule.getTarifActuel());
//        document.put("kilometrage", vehicule.getKilometrage());
        collection.insertOne(vehicule);
    }*/
}
