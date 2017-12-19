/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import server.datenbank.Database;
import server.response.AbstractResponse;
import server.response.ResponseAll;

/**
 *
 * @author lukas
 */
public class RequestAll extends AbstractRequest{

    public RequestAll() {}

    public RequestAll(JsonObject jsonObj) throws RequestException {
        super(jsonObj);
        
        if(jsonObj.size() != 1)
            throw new RequestException("wrong number of attributes");  
    }
    
    @Override
    public String getCommand() {
        return "all";
    }

    @Override
    public AbstractResponse getResponse() throws Exception 
    {
        
        List<JsonObject> names = Database.getInstance().list();
        
        JsonArrayBuilder a = Json.createArrayBuilder();
        for (int i = 0; i < names.size(); i++)
        {
            a.add(names.get(i));
        }
        
        return new ResponseAll(this, a.build());
    }
        
}
