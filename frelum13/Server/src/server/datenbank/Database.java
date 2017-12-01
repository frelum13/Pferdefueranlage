package server.datenbank;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author ...
 */
public class Database
{
  private static Database instance;
  
  private final Connection myCon;
  private Statement myStmt;
  
  // public static synchronized Database getInstance() 
  public static Database getInstance() throws Exception 
  {
    if (instance == null)
    {
      instance = new Database();
    }
    return instance;
  }
  
  private Database () 
          throws Exception 
  {
    Connect connect = new Connect();
    myCon = connect.getConn();
  }
  
  public void wirte(String insertQuery) throws SQLException
  {
    myStmt = instance.myCon.createStatement();        
    myStmt.executeUpdate("INSERT INTO horses (name,time,turnaround,speed) VALUES ("+ insertQuery +")");
    myStmt.close();
  }
  
  public int update(String updateQuery) throws SQLException
  {
    myStmt = instance.myCon.createStatement();
    return myStmt.executeUpdate("UPDATE horses SET " + updateQuery);
    
  }
  
  public Object read (String id) 
  {
    return null;
  }
}
