/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;
import server.server.ConnectionThreadServer;

/**
 *
 * @author Lukas
 */
public class Connect {
    
    
        private final String hostname = "109.73.158.173";
        private final String port = "3306";
        private final String dbname = "horse";
        private final String user = "root";
        private final String password = "Campus02";
        private Connection conn;
        private String error = null;
        
        private final static Logger log = Logger.getLogger(Connect.class.getName());

        public Connect() throws Exception {  
            conection();
        }
        
        private void conection()
                throws Exception
        {           
            log.info("Connect: Beim verbinden");   
                
            Properties connectionProps = new Properties();
            connectionProps.put("user", user);
            connectionProps.put("password", password);
            DriverManager.setLoginTimeout(1);


            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?useSSL=false";
                
            conn = DriverManager.getConnection(url, connectionProps); 
        }

    public Connection getConn() {
        return conn;
    } 
}
