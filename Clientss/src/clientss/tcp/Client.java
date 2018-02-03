package clientss.tcp;

import clientss.gui.UDPClient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;


/**
 *
 * @author steiner
 */
public class Client implements Runnable
{
    private final JsonObject build;

    public Client(JsonObject build) {
        this.build = build;
    }
    
  @Override
    public void run() {
        final Socket socket = new Socket();
        try
        {
            String write = build.toString();  
        
            socket.connect(new InetSocketAddress("10.200.111.177", 1111), 3000);
            socket.setSoTimeout(0);
            final BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      
            StringBuilder sb = new StringBuilder();
      
            sb.append(write);
            sb.append("\n");
      
            w.write(sb.toString());
            w.flush();
            String msg = r.readLine();
            
            UDPClient.NAME = msg;
            
        }
        catch (IOException ex) 
        {
            System.out.println("Fehler aufgetreten");
            ex.printStackTrace(System.out);
        }
        finally
        {
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("socket closed");
        }
    }    
}
