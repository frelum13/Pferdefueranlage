/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.response;

import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import server.request.AbstractRequest;
import server.server.ConnectionThreadServer;

/**
 *
 * @author Lukas
 */
public class ResponseError extends AbstractResponse{

    
    private final String error;
    
    public ResponseError(AbstractRequest request, String error) {
        super(request);
        
        this.error = error;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObjectBuilder b = Json.createObjectBuilder();
        b.add("command", request.getCommand());
        b.add("error", error);
        
        return b.build();
    }
    
}
