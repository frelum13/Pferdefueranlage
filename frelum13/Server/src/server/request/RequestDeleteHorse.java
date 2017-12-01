/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.datenbank.DatabaseDelete;
import server.response.AbstractResponse;
import server.response.ResponseDeleteHorse;

/**
 *
 * @author lukas
 */
public class RequestDeleteHorse extends AbstractRequest{

    private final String name;
    
    public RequestDeleteHorse(String name) {
        this.name = name;
    }

    public RequestDeleteHorse(JsonObject jsonObj) throws RequestException {
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
        
        try 
        {
            DatabaseDelete loeschen = new DatabaseDelete(name);
        } 
        catch (Exception e) 
        {
            throw new RequestException("delte problem");
        }
    }

    @Override
    public String getCommand() {
        return "deletehorse";
    }

    @Override
    public AbstractResponse getResponse() {
        return new ResponseDeleteHorse(this);
    }
    
       
}
