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
  
  public int wirte(String insertQuery) throws SQLException
  {
    myStmt = instance.myCon.createStatement();        
    return myStmt.executeUpdate("INSERT INTO horses (name,time,turnaround,speed) VALUES ("+ insertQuery +")");
  }
  
  public int update(String updateQuery) throws SQLException
  {
    myStmt = instance.myCon.createStatement();
    return myStmt.executeUpdate("UPDATE horses SET " + updateQuery);
  }
  
  public int delete(String deleteQuery) throws SQLException
  {
      myStmt = instance.myCon.createStatement();
    return myStmt.executeUpdate("DELETE FROM horses WHERE name =" + deleteQuery);
  }
  
  public Object read (String id) 
  {
    return null;
  }
}
