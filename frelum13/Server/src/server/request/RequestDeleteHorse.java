/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.datenbank.Database;
import server.response.AbstractResponse;
import server.response.ResponseDeleteHorse;

/**
 *
 * @author lukas
 */
public class RequestDeleteHorse extends AbstractRequest{

    private final int id;
    
    public RequestDeleteHorse(int name) {
        this.id = name;
    }

    public RequestDeleteHorse(JsonObject jsonObj) throws RequestException {
        super(jsonObj);
        
        if(jsonObj.size() != 2)
            throw new RequestException("wrong number of attributes");
        try 
        {  
            id = jsonObj.getInt("id");
        } 
        catch (Exception e) 
        {
            throw new RequestException("no attribute name", e);
        }
        
        if(id == 0)
            throw new RequestException("name must not be empty");
        
        try 
        {
            Database.getInstance().delete("'" + id + "'");
        } 
        catch (Exception e) 
        {
            throw new RequestException("delte problem");
        }
    }

    @Override
    public String getCommand() {
        return "delete";
    }

    @Override
    public AbstractResponse getResponse() {
        return new ResponseDeleteHorse(this);
    }
    
       
}
