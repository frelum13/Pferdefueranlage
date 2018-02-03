package server.datenbank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
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
    return myStmt.executeUpdate(insertQuery);
  }
  
  public int update(String updateQuery) throws SQLException
  {
    myStmt = instance.myCon.createStatement();
    return myStmt.executeUpdate(updateQuery);
  }
  
  public int delete(String deleteQuery) throws SQLException
  {
      myStmt = instance.myCon.createStatement();
      return myStmt.executeUpdate(deleteQuery);
  }
  
  public Horse read(String readQuery) throws SQLException
  {
      myStmt= instance.myCon.createStatement();
      ResultSet myRs = myStmt.executeQuery(readQuery);
      Horse horse = new Horse();
      if(myRs.next())
      {
          horse.setId(myRs.getInt(1));
          horse.setName(myRs.getString(2));
          horse.setTime(myRs.getInt(3));
          horse.setTurnaround(myRs.getInt(4));
          horse.setSpeed(myRs.getDouble(5));
      }
      
      return horse;
  }
  private int maxId() throws SQLException
  {
      int idmax = 0;
      myStmt = instance.myCon.createStatement();
      try (ResultSet myRs = myStmt.executeQuery("SELECT MAX(id) FROM horses")) {
          if(myRs.next())
          {
              idmax = myRs.getInt(1);
          }
      }
      catch(Exception ex)
      {
          System.out.println("idmax");
      }
      return idmax;  
  }
          
  public List list () throws SQLException 
  {
        List<JsonObject> names = new ArrayList<>();
        JsonObjectBuilder b = Json.createObjectBuilder();
        for(int i = 0; i <= maxId() ; i++)
        {
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM horses WHERE id = '" + i + "'");
            if(myRs.next())
            {
                names.add(b.add("id", myRs.getString(1)).add("name", myRs.getString(2)).build());
            }
        }
    return names;
  }
}
