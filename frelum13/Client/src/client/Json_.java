/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import org.json.simple.JSONObject;

public class Json_{

    public static JSONObject write() 
    {
        JSONObject obj = new JSONObject();
        obj.put("command", "update");      
        obj.put("name", "fabio");
        obj.put("time", 2);
        obj.put("turnaround", 4);
        obj.put("speed", 4);
        
        
        
        System.out.println(obj);
        return obj;
    }

}