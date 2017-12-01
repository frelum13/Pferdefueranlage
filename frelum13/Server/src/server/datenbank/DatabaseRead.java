/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author marinaspari
 */
public class DatabaseRead
{
    private final String name;
    private String hname, time, turnaround;

    public DatabaseRead(String name) throws Exception {
        this.name = name;
        
        lesen();
    }

    public String getHname() {
        return hname;
    }

    public String getTime() {
        return time;
    }

    public String getTurnaround() {
        return turnaround;
    }
  
    private void lesen() throws Exception
    {
        Connect connect = new Connect();
        Connection conn = connect.getConn();
        Statement st = conn.createStatement();
        String sql =  "SELECT * FROM horses WHERE name = '" + name + "'";
        ResultSet myRs = st.executeQuery(sql);
       if(myRs.next() == true)
        {
            System.out.println("Hallo");
            hname = myRs.getString(2);
            time = myRs.getString(3);
            turnaround = myRs.getString(4);
        }
    }
}