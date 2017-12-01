/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.main.Main;
import server.response.AbstractResponse;
import server.response.ResponseMachine;

/**
 *
 * @author lukas
 */
public class RequestMachine extends AbstractRequest{

    private final String error;
    
    public RequestMachine(String error) {
        this.error = error;
    }

    public RequestMachine(JsonObject jsonObj) throws RequestException {
        super(jsonObj);
        
        if(jsonObj.size() != 2)
            throw new RequestException("wrong number of attributes");
        try 
        {  
            error = jsonObj.getString("error");
        } 
        catch (Exception e) 
        {
            throw new RequestException("no attribute error", e);
        }
        
        Main.ERROR = error;
    }

    @Override
    public String getCommand() {
        return "get";
    }

    @Override
    public AbstractResponse getResponse() throws Exception {
        return new ResponseMachine(this, Main.WATER, Main.TIME, Main.TURNAROUND, Main.STOP);
    }
}
