/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.response;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import server.request.AbstractRequest;

/**
 *
 * @author lukas
 */
public class ResponseMachine extends AbstractResponse{

    private final boolean water;
    private final int time,turnaround;
    private final String stop;
    private double speed;
    
    public ResponseMachine(AbstractRequest request, boolean water, int time, int turnaround, double speed, String stop) {
        super(request);
        
        this.water = water;
        this.time = time;
        this.turnaround = turnaround;
        this.stop = stop;
        this.speed = speed;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObjectBuilder b = Json.createObjectBuilder();
        b.add("command", request.getCommand());
        b.add("water", water);
        b.add("time", time);
        b.add("turnaround", turnaround);
        b.add("speed", speed);
        b.add("stop", stop);
        
        return b.build();
    }
    
        
}
