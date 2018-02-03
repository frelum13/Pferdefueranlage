/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.response;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import server.request.AbstractRequest;

/**
 *
 * @author lukas
 */
public class ResponseAll extends AbstractResponse{    

    JsonArray names;
    
    public ResponseAll(AbstractRequest request, JsonArray names) {
        super(request);
        if (names == null)
            throw new NullPointerException();
        if(names.isEmpty())
            throw new RuntimeException("version must not be empty");
        
        this.names = names;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObjectBuilder b = Json.createObjectBuilder();
        
        b.add("command", request.getCommand());
        b.add("names", names);
     
        return b.build();
    }
}
