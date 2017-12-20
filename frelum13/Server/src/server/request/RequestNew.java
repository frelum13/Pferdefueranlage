/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.request;

import javax.json.JsonObject;
import server.datenbank.Database;
import server.response.AbstractResponse;
import server.response.ResponseNew;

/**
 *
 * @author lukas
 */
public class RequestNew extends AbstractRequest{

    private final String name;
    private final int time;
    private final int turnaround;
    private final int speed;
    
    public RequestNew(String name, int time, int turnaround, int speed) {
        this.name = name;
        this.time = time;
        this.turnaround = turnaround;
        this.speed = speed;
    }

    public RequestNew(JsonObject jsonObj) throws RequestException{
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
            Database.getInstance().wirte("INSERT INTO horses (name,time,turnaround,speed) VALUES ('" + name + "','" + time + "','" + turnaround + "','"+ speed +"')");
        } 
        catch (Exception e) 
        {
            throw new RequestException("writing problem");
        }   
    }

    public String getName() {
        return name;
    }


    public int getTime ()
    {
      return time;
    }


    public int getTurnaround ()
    {
      return turnaround;
    }


    public int getSpeed ()
    {
      return speed;
    }

    @Override
    public String getCommand() {
        return "new";
    }

    @Override
    public AbstractResponse getResponse() throws RequestException{
        return new ResponseNew(this);
    }  

}
