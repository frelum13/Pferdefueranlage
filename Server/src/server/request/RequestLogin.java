/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.main.Main;
import server.response.AbstractResponse;
import server.response.ResponseLogin;

/**
 *
 * @author lukas
 */
public class RequestLogin extends AbstractRequest
{

    public RequestLogin() {
    }

    public RequestLogin(JsonObject jsonObj) throws RequestException {
        super(jsonObj);
        
        if(jsonObj.size() != 1)
            throw new RequestException("wrong number of attributes");
    }
    
    @Override
    public String getCommand() {
        return "login";
    }

    @Override
    public AbstractResponse getResponse() throws Exception {
        return new ResponseLogin(this, Main.PWD);
    }
    
}
