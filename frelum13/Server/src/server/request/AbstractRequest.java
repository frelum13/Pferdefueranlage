/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import server.response.AbstractResponse;

/**
 *
 * @author lukas
 */
public abstract class AbstractRequest {
    
    public static AbstractRequest createFromJsonString (String json) throws RequestJsonException
    {
        try 
        {
            JsonReader jsonReader = Json.createReader(
                    new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8.name())));
            final JsonObject jsonObj = jsonReader.readObject();
            String cmd = jsonObj.getString("command");
            
            AbstractRequest rv;
            switch(cmd)
            {
                case "version": rv = new RequestVersion(jsonObj); break;
                case "water": rv = new RequestWater(jsonObj); break;
                case "stop": rv = new RequestStop(jsonObj); break;
                case "delete": rv = new RequestDeleteHorse(jsonObj); break;
                case "infohorse": rv = new RequestInfoHorse(jsonObj); break;
                case "new": rv = new RequestNew(jsonObj); break;
                case "update": rv = new RequestUpdateHorse(jsonObj); break;
                case "start": rv = new RequestStart(jsonObj); break;
                case "get": rv = new RequestMachine(jsonObj); break;
                case "all": rv = new RequestAll(jsonObj); break;
                default: throw new RequestJsonException(json, "invalid command");
            }
            return rv;
        } 
        catch (Exception e) 
        {
            throw new RequestJsonException(json, e);
        }
        
    }

    public AbstractRequest() {}
    
    public AbstractRequest(JsonObject jsonObj) throws RequestException
    {
      String cmd = jsonObj.getString("command");
      if(!cmd.equals(getCommand()))
          throw new RequestException("wrong command");
    }
        
    public abstract String getCommand();

    public abstract AbstractResponse getResponse() throws Exception;
    
}
