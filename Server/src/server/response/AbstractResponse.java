/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.response;

import javax.json.JsonObject;
import server.request.AbstractRequest;

/**
 *
 * @author lukas
 */
public abstract class AbstractResponse {
    
    protected final AbstractRequest request;

    public AbstractResponse(AbstractRequest request) {
        if (request == null) 
            throw new NullPointerException(); 
        this.request = request;
    }

    public AbstractRequest getRequest() {
        return request;
    }
    
    public abstract JsonObject toJsonObject();
    
    
}
