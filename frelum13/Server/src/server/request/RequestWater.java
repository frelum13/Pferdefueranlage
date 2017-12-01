/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.main.Main;
import server.response.AbstractResponse;
import server.response.ResponseWater;

/**
 *
 * @author lukas
 */
public class RequestWater extends AbstractRequest{

    private final boolean on;
    
    public RequestWater(boolean on) {
        
        this.on = on;
    }

    public RequestWater(JsonObject jsonObj) throws RequestException {
        super(jsonObj);
        if(jsonObj.size() != 2)
            throw new RequestException("wrong number of attributes");
        try 
        {  
            on = jsonObj.getBoolean("water");
        } 
        catch (Exception e) 
        {
            throw new RequestException("no attribute water", e);
        }
        Main.WATER = on;
    }

    public boolean isOn() {
        return on;
    }
    
    @Override
    public String getCommand() {
        return "water";
    }

    @Override
    public AbstractResponse getResponse() {
        return new ResponseWater(this);
    }
    
}
