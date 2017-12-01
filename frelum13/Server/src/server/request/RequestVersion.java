/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.main.Main;
import server.response.AbstractResponse;
import server.response.ResponseVersion;

/**
 *
 * @author lukas
 */
public class RequestVersion extends AbstractRequest{
    
    
    public RequestVersion() {        
        
    }

    public RequestVersion(JsonObject jsonObj) throws RequestException {
        super(jsonObj);
        
        if(jsonObj.size() != 1)
            throw new RequestException("wrong number of attributes");   
    }

    @Override
    public String getCommand() {
        return "version";
    }

    @Override
    public AbstractResponse getResponse() {
        return new ResponseVersion(this, Main.VERSION);
    }
    
    
}
