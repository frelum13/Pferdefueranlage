/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.response.AbstractResponse;
import server.response.ResponseInfoHorse;

/**
 *
 * @author lukas
 */
public class RequestInfoHorse extends AbstractRequest{

    private final String name;
    
    public RequestInfoHorse(String name) {
        this.name = name;
    }

    public RequestInfoHorse(JsonObject jsonObj) throws RequestException {
        super(jsonObj);
        
        if(jsonObj.size() != 2)
            throw new RequestException("wrong number of attributes");
        try 
        {  
            name = jsonObj.getString("name");
        } 
        catch (Exception e) 
        {
            throw new RequestException("no attribute name", e);
        }
        
        if(name == null || name.isEmpty())
            throw new RequestException("name must not be empty");
    }
    
    @Override
    public String getCommand() {
        return "infohorse";
    }

    @Override
    public AbstractResponse getResponse()
            throws Exception
    {
        return null;
    }
}
