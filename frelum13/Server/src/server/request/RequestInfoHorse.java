/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.datenbank.Database;
import server.datenbank.Horse;
import server.response.AbstractResponse;
import server.response.ResponseInfoHorse;

/**
 *
 * @author lukas
 */
public class RequestInfoHorse extends AbstractRequest{

    private final int id;
    
    public RequestInfoHorse(int id) {
        this.id = id;
    }

    public RequestInfoHorse(JsonObject jsonObj) throws RequestException {
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
    }
    
    @Override
    public String getCommand() {
        return "info";
    }

    @Override
    public AbstractResponse getResponse()
            throws Exception
    {
        Horse horse = Database.getInstance().read("SELECT * FROM horses WHERE id = '" + id + "'");
        
        return new ResponseInfoHorse(horse.getName(), horse.getTime(), horse.getTurnaround(), horse.getId(), horse.getSpeed(), this);
    }
}
