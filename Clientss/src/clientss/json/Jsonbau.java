/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientss.json;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author lukas
 */
public class Jsonbau {
    
    private JsonObjectBuilder b = Json.createObjectBuilder();
    private JsonObject build;
    
    private final int id,time,turnaround,speed;
    private final String name, command;
    private final Boolean water;

    public Jsonbau(int id, int time, int turnaround, int speed, String name, Boolean water, String command) {
        this.id = id;
        this.time = time;
        this.turnaround = turnaround;
        this.speed = speed;
        this.name = name;
        this.water = water;
        this.command = command;
        
        build();
    }
    
    private void build()
    {
        switch(command)
        {
            case "login":  
                b.add("command", command);
                build = b.build();
                break;
            
            case "delete": 
                b.add("command", command);
                b.add("id", id);
                build = b.build();
                break;
            case "new": 
                b.add("command", command);
                b.add("name", name);
                b.add("time", time);
                b.add("turnaround", turnaround);
                b.add("speed", speed);
                build = b.build();
                break;
            case "all": 
                b.add("command", command);
                build = b.build();
                break;
            case "info": 
                b.add("command", command);
                b.add("id", id);
                build = b.build();
                break;
            case "get": 
                b.add("command", command);
                build = b.build();
                break;
            case "water": 
                b.add("command", command);
                b.add("water", water);
                build = b.build();
            case "start": 
                b.add("command", command);
                b.add("id", id);
                build = b.build();
                break;
            case "stop": 
                b.add("command", command);
                b.add("id", id);
                build = b.build();
                break;
            case "version": 
                b.add("command", command);
                build = b.build();
                break;
        }
    }

    public JsonObject getBuild() {
        return build;
    }
}
