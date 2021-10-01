/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.backingbeans;

import org.bson.types.ObjectId;

/**
 *
 * @author jerom
 */
public class Cyclist {
    
    
    private ObjectId _id;
    private String lastName;
    private String firstName;
    private boolean onLine;
    private String picture;
    private String email;
    private String password;
    
    //IoT
    private String latitude;
    private String longitude;
    
    
    
    

    public Cyclist() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

 

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isOnLine() {
        return onLine;
    }

    public void setOnLine(boolean onLine) {
        this.onLine = onLine;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Cyclist{" + "_id=" + _id + ", lastName=" + lastName + ", firstName=" + firstName + ", onLine=" + onLine + ", picture=" + picture + ", email=" + email + ", password=" + password + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

    
    
    
    
    
    
    
}
