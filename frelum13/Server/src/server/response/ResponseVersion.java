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
public class ResponseVersion extends AbstractResponse{

    private final String version;
    
    public ResponseVersion(AbstractRequest request, String version) {
        super(request);
        if (version == null)
            throw new NullPointerException();
        if(version.isEmpty())
            throw new RuntimeException("version must not be empty");
        
        this.version = version;
       
    }
    
    @Override
    public JsonObject toJsonObject() {
        JsonObjectBuilder b = Json.createObjectBuilder();
        b.add("command", request.getCommand());
        b.add("version", version);
        
        return b.build();
    }
    
    
    
}
