/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.main.Main;
import server.response.AbstractResponse;
import server.response.ResponseStop;

/**
 *
 * @author lukas
 */
public class RequestStop extends AbstractRequest{

    private final String stop;
    
    public RequestStop(String stop) 
    {
        this.stop = stop;
    }

    public RequestStop(JsonObject jsonObj) throws RequestException {
        super(jsonObj);
        
        if(jsonObj.size() != 2)
            throw new RequestException("wrong number of attributes");
        try 
        {  
            stop = jsonObj.getString("stop");
        } 
        catch (Exception e) 
        {
            throw new RequestException("no attribute water", e);
        }
        
        if(stop == null || stop.isEmpty())
            throw new RequestException("stop msut not be empty");
        
        Main.STOP = stop;
    }
    
    @Override
    public String getCommand() {
        return "stop";
    }

    @Override
    public AbstractResponse getResponse() {
        return new ResponseStop(this);
    }
    
}
