/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.main.Main;
import server.response.AbstractResponse;
import server.response.ResponseStart;

/**
 *
 * @author lukas
 */
public class RequestStart extends AbstractRequest
{
    private final int id;
      
    public RequestStart(int id) {
        this.id = id;
    }

    public RequestStart(JsonObject jsonObj) throws RequestException, Exception {
        super(jsonObj);
        
        if(jsonObj.size() != 2)
            throw new RequestException("wrong number of attributes");
        try 
        {  
            id = jsonObj.getInt("id");
        } 
        catch (Exception e) 
        {
            throw new RequestException("no attribute id", e);
        }
        
        if(id == 0)
            throw new RequestException("id must not be empty");
        
        Main.ID = id;
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
