/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.datenbank.Database;
import server.response.AbstractResponse;
import server.response.ResponseUpdateHorse;

/**
 *
 * @author lukas
 */
public class RequestUpdateHorse extends AbstractRequest{

    private final String name;
    private final int time, turnaround,speed;
    
    public RequestUpdateHorse(String name, int time, int turnaround, int speed) {
        this.name = name;
        this.time = time;
        this.turnaround = turnaround;
        this.speed = speed;
    }

    public RequestUpdateHorse(JsonObject jsonObj) throws RequestException {
        super(jsonObj);
        
        if(jsonObj.size() != 5)
            throw new RequestException("wrong number of attributes");
        try 
        {  
            name = jsonObj.getString("name");
            time = jsonObj.getInt("time");
            turnaround = jsonObj.getInt("turnaround");
            speed = jsonObj.getInt("speed");
        } 
        catch (Exception e) 
        {
            throw new RequestException("no attribute name or time or turnaround", e);
        } 
        if(name == null || name.isEmpty())
            throw new RequestException("name must not be empty");
        if(time <= 0)
            throw new RequestException("time must not be empty");
        if(turnaround <= 0)
            throw new RequestException("turnaround must not be empty");
        if(speed <= 0)
            throw new RequestException("speed must not be empty");
        
        try 
        {
           Database.getInstance().update("speed = '"+ speed + "', time = '" + time + "', turnaround = '" + turnaround + "' Where name='" + name +"'");
        } 
        catch (Exception e) 
        {
            throw new RequestException("update problem");
        }   
    }
    @Override
    public String getCommand() {
        return "update";
    }

    @Override
    public AbstractResponse getResponse() {
        return new ResponseUpdateHorse(this);
    }
    
    
    
}
