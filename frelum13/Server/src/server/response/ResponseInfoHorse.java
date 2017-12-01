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
    private final String time;
    private final String turnaround;
    
    public ResponseInfoHorse(String name, String time, String turnaround,AbstractRequest request) {
        super(request);
        
        this.name = name;
        this.time = time;
        this.turnaround = turnaround;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObjectBuilder b = Json.createObjectBuilder();
        b.add("command", request.getCommand());
        b.add("name", name);
        b.add("time", time);
        b.add("turnaround", turnaround);
        
        return b.build();
    }
}
