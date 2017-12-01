/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.datenbank.DatabaseRead;
import server.main.Main;
import server.response.AbstractResponse;
import server.response.ResponseStart;

/**
 *
 * @author lukas
 */
public class RequestStart extends AbstractRequest
{
    private final String name;

    public RequestStart(String name) {
        this.name = name;
    }

    public RequestStart(JsonObject jsonObj) throws RequestException, Exception {
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
        
        DatabaseRead lesen = new DatabaseRead(name);
        Main.TIME = Integer.parseInt(lesen.getTime());
        Main.TURNAROUND = Integer.parseInt(lesen.getTurnaround());        
    }
    
    @Override
    public String getCommand() {
        return "start";
    }

    @Override
    public AbstractResponse getResponse() throws Exception {
        return new ResponseStart(this);
    }
    
    
    
}
