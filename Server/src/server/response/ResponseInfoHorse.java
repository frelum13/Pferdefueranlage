/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.response;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import server.request.AbstractRequest;

/**
 *
 * @author lukas
 */
public class ResponseInfoHorse extends AbstractResponse{

    private final String name;
    private final int time;
    private final int turnaround;
    private final int id;
    private final double speed;
    private final String error;
    
    public ResponseInfoHorse(String name, int time, int turnaround, int id, double speed, String error, AbstractRequest request) {
        super(request);
        
        this.name = name;
        this.time = time;
        this.turnaround = turnaround;
        this.id = id;
        this.speed = speed;
        this.error = error;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObjectBuilder b = Json.createObjectBuilder();
        b.add("command", request.getCommand());
        b.add("id", id);
        b.add("name", name);
        b.add("time", time);
        b.add("turnaround", turnaround);
        b.add("speed", speed);
        
        return b.build();
    }
}
