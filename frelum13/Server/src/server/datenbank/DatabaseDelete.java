/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Lukas
 */
public class DatabaseDelete {
    
    private final String name;
    
    private String check;

    public DatabaseDelete(String name) throws Exception {
        this.name = name;
        loeschen();
    }
    
    private void loeschen() throws Exception
    {   
        Connect connect = new Connect();
        Connection myCon = connect.getConn();
        Statement myStmt = myCon.createStatement();
        String sql = "DELETE FROM horses WHERE name = '" + name + "'";
        myStmt.executeUpdate(sql);
    }
}
