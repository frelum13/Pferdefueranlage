package server.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Logger;
import javax.json.JsonObject;
import org.json.simple.parser.JSONParser;
import server.main.Main;
import server.request.AbstractRequest;
import server.response.AbstractResponse;

public class ConnectionThreadServer implements Runnable
{
    private final static Logger log = Logger.getLogger(ConnectionThreadServer.class.getName());
    
    private final Socket socket;

    public ConnectionThreadServer(Socket socket) {
        this.socket = socket;
    }
    
    
    @Override
    public void run()
    {
    
        try{
           
            // Variablen Deklaration
            String[] str;
            JsonObject antwort = null;
            JsonObject obj = null;
            String stringantwort;
            JSONParser parser = new JSONParser();
            
            log.info("ConnectionThreadServer: Ein Client hat sich verbunden");
            
            final BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
            final BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));   
                     
            try
            {
                String requestString = r.readLine();
                log.info("Empfangenes Telegramm" + requestString);
                AbstractRequest req = AbstractRequest.createFromJsonString(requestString);
                AbstractResponse res = req.getResponse();
                JsonObject jsonObj = res.toJsonObject();
                String jsonString = jsonObj.toString();
                w.append(jsonString).append("\n");
                w.flush();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                Main.ERROR = String.valueOf(ex);
            }

        }
        catch (IOException ex) {
            log.severe("ConnectionThreadServer: IOException (Problem mit Buffer)");
        }         
        finally
        {
            try {
                socket.close();
                log.info("Thread erfolgreich geschlossen");
            } catch (IOException ex) {
                log.severe("ConnectionThreadServer: Problem beim Thread close");
            }
        }
        
        

    }
    
}
