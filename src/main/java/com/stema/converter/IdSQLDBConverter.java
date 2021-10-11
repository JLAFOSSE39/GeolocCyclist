/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.bson.types.ObjectId;

/**
 *
 * @author jerom
 */
@Converter(autoApply = true)
public class IdSQLDBConverter implements AttributeConverter<ObjectId, String> {

    @Override
    public String convertToDatabaseColumn(ObjectId x) {
        return x.toString();
    }

    @Override
    public ObjectId convertToEntityAttribute(String y) {
        //on veut un objet de la classe BSON.OBJECTID et pas une String
        ObjectId monObjet = new ObjectId(y);
        return monObjet;
    }

}
