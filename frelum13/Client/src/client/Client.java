package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.json.simple.JSONObject;


/**
 *
 * @author steiner
 */
public class Client
{
  private final String host;
  private final int port;

  public Client (String host, int port)
  {
    this.host = host;
    this.port = port;
  }
  
  public void start () throws IOException {
    final Socket socket = new Socket();
    try
    {
      JSONObject writee = client.Json_.write();
      String write = writee.toString();  
        
      socket.connect(new InetSocketAddress(host, port), 3000);
      socket.setSoTimeout(0);
      final BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      final BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      
      StringBuilder sb = new StringBuilder();
      
      sb.append(write);
      sb.append("\n");
      
      w.write(sb.toString());
      w.flush();
      String msg = r.readLine();
      System.out.println("Message from server: " + msg);
    }
    catch (IOException ex) 
    {
      System.out.println("Fehler aufgetreten");
      ex.printStackTrace(System.out);
    }
    finally
    {
      socket.close();
      System.out.println("socket closed");
    }
    
  }
  
  public static void main (String[] args) throws IOException
  {

    new Client("127.0.0.1", 1111).start();
  }
}
