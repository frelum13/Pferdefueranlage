/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import java.sql.SQLException;
import java.util.logging.Logger;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import server.datenbank.Database;
import server.response.AbstractResponse;
import server.response.ResponseUpdateHorse;
import server.response.ResponseError;
import server.server.ConnectionThreadServer;

/**
 *
 * @author lukas
 */
public class RequestUpdateHorse extends AbstractRequest{

    private final static Logger log = Logger.getLogger(ConnectionThreadServer.class.getName());
    
    private String name="",geschwindigkeit="";
    private String error = "";
    private int id=0, time=0, turnaround = 0;
    private double speed = 0.0;
    
    public RequestUpdateHorse(String name, int time, int turnaround, double speed, int id) {
        this.name = name;
        this.time = time;
        this.turnaround = turnaround;
        this.speed = speed;
        this.id = id;
    }

    public RequestUpdateHorse(JsonObject jsonObj) throws RequestException {
        super(jsonObj);
        
        if(jsonObj.size() != 6)
        {
            error = "wrong number of attributes";
            log.severe("wrong number of attributes");
        }
        try 
        {  
            name = jsonObj.getString("name");
            time = jsonObj.getInt("time");
            turnaround = jsonObj.getInt("turnaround");
            id = jsonObj.getInt("id");
            JsonNumber number = jsonObj.getJsonNumber("speed");
            speed = number.doubleValue();
        } 
        catch (Exception e) 
        {
            error = "no attribute name or time or turnaround";
            log.severe(e.getMessage());
            // throw new RequestException("no attribute name or time or turnaround", e);
        } 
        
        if(name == null || name.isEmpty())
        {
            error = "name must not be empty";
            log.severe("name must not be empty");
             // throw new RequestException("name must not be empty");
        } 
        if(time <= 0)
        {
            error = "time must not be empty";
            log.severe("time must not be empty");
            // throw new RequestException("time must not be empty");
        }
        if(turnaround <= 0)
        {
            error = "turnaround must not be empty";
            log.severe("turnaround must not be empty");
            // throw new RequestException("turnaround must not be empty");
        }
        if(speed <= 0)
        {
            error = "speed must not be empty";
            log.severe("speed must not be empty");
            // throw new RequestException("speed must not be empty");
        }
        if(id <= 0.0)
        {
            error = "speed must not be empty";
            log.severe("speed must not be empty");
            // throw new RequestException("speed must not be empty");
        }
        
        try 
        {
           Database.getInstance().update("UPDATE horses SET speed = '"+ speed + "', time = '" + time + "', turnaround = '" + turnaround + "', name = '" + name + "' Where id ='" + id +"'");
        } 
        catch (Exception e) 
        {
            error = e.getMessage();
            log.severe(e.getMessage());
            // throw new RequestException("update problem");
        }   
    }
    @Override
    public String getCommand() {
        return "update";
    }

    @Override
    public AbstractResponse getResponse() {
        if(error == "")
            return new ResponseUpdateHorse(this);
        else
            return new ResponseError(this, error);
    }    
}
