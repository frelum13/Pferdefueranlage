/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

/**
 *
 * @author lukas
 */
public class ReadObject {
 
    private final String name;
    private final int time, turnaround, speed;

    public ReadObject(String name, int time, int turnaround, int speed) {
        this.name = name;
        this.time = time;
        this.turnaround = turnaround;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getTurnaround() {
        return turnaround;
    }

    public int getSpeed() {
        return speed;
    }
}
