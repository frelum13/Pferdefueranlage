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
public class Horse 
{
    private int id;
    private String name;
    private int time;
    private int turnaround;
    private double speed;

    public void setId(int data) {
            id = data;
    }
    
    public void setName(String data) {
            name = data;
    }

    public void setTime(int data) {
            time = data;
    }

    public void setTurnaround(int data) {
            turnaround = data;
    }

    public void setSpeed(double data) {
            speed = data;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getTime() { return time; }
    public int getTurnaround() { return turnaround; }
    public double getSpeed() { return speed; }
}
