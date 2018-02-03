/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import java.util.logging.Logger;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import server.datenbank.Database;
import server.response.AbstractResponse;
import server.response.ResponseError;
import server.response.ResponseNew;
import server.server.ConnectionThreadServer;

/**
 *
 * @author lukas
 */
public class RequestNew extends AbstractRequest{

    private final static Logger log = Logger.getLogger(ConnectionThreadServer.class.getName());
    
    private String error;
    private String name;
    private int time;
    private int turnaround;
    private double speed;
    
    public RequestNew(String name, int time, int turnaround, double speed) {
        this.name = name;
        this.time = time;
        this.turnaround = turnaround;
        this.speed = speed;
    }

    public RequestNew(JsonObject jsonObj) throws RequestException{
        super(jsonObj);
        if(jsonObj.size() != 5)
        {
            error = "wrong number of attributes";
            log.severe("wrong number of attributes");
        }
        try 
        {  
            name = jsonObj.getString("name");
            time = jsonObj.getInt("time");
            turnaround = jsonObj.getInt("turnaround");
            JsonNumber number = jsonObj.getJsonNumber("speed");
            speed = number.doubleValue();
        } 
        catch (Exception e) 
        {
            error = "no attribute name or time or turnaround";
            log.severe(e.getMessage());
        } 
        if(name == null || name.isEmpty())
        {
            error = "name must not be empty";
            log.severe("name must not be empty");
        }
        if(time <= 0)
        {
            error = "time must not be empty";
            log.severe("time must not be empty");
        }
        if(turnaround <= 0)
        {
            error = "turnaround must not be empty";
            log.severe("turnaround must not be empty");
        }
        if(speed <= 0.0)
        {
            error = "speed must not be empty";
            log.severe("speed must not be empty");
        }
        if("".equals(error))
        {
            try 
            {
                Database.getInstance().wirte("INSERT INTO horses (name,time,turnaround,speed) VALUES ('" + name + "','" + time + "','" + turnaround + "','"+ speed +"')");
            } 
            catch (Exception e) 
            {
                error = e.getMessage();
                log.severe(e.getMessage());
            }
        }
    }

    @Override
    public String getCommand() {
        return "new";
    }

    @Override
    public AbstractResponse getResponse() throws RequestException{
        if("".equals(error))
            return new ResponseNew(this);
        else
            return new ResponseError(this, error);
    }  

}
