/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.response;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import server.request.AbstractRequest;

/**
 *
 * @author lukas
 */
public class ResponseNew extends AbstractResponse{

    public ResponseNew(AbstractRequest request) {
        super(request);
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObjectBuilder b = Json.createObjectBuilder();
        b.add("command", request.getCommand());
        
        return b.build();
    }
    
    
    
}
