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
public class ResponseLogin extends AbstractResponse
{

    private String pwd;
    
    public ResponseLogin(AbstractRequest request, String pwd) {
        super(request);
        
        this.pwd = pwd;
    }
    
    @Override
    public JsonObject toJsonObject() {
        
        JsonObjectBuilder b = Json.createObjectBuilder();
        
        b.add("command", request.getCommand());
        b.add("password", pwd);
        
        return b.build();
    }
    
}
