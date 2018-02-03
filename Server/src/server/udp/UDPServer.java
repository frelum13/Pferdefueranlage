/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.udp;

import com.hopding.jrpicam.RPiCamera;
import com.hopding.jrpicam.enums.AWB;
import com.hopding.jrpicam.enums.DRC;
import com.hopding.jrpicam.enums.Encoding;
import com.hopding.jrpicam.enums.Exposure;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author lukas
 */
public class UDPServer implements Runnable
{
    
    private final int port;
    
    private final static Logger log = Logger.getLogger(UDPServer.class.getName());
     
    public UDPServer(int port) {
        this.port = port;
    }
    
    @Override
    public void run()
    {

        try {
            
            log.info("Server: Server gestarted");
            DatagramSocket sock = null;
         
            
            sock = new DatagramSocket(port);
             
            byte[] buffer = new byte[576000];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            
            RPiCamera piCamera = new RPiCamera(null);
        
             // Change encoding of images to PNG
            
            while(true){
                sock.receive(incoming); 
                piCamera.turnOffPreview().setFullPreviewOff().enableBurst().setDateTimeOff().setHorizontalFlipOff().setTimestampOff().setTimeout(1).setISO(100).setQuality(100).setPreviewOpacity(100);
                log.info("UDP: Client hat sich verbunden");
                ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
                ImageIO.write(piCamera.takeBufferedStill(), "JPG", baos);
                baos.flush();
                byte[] bild = baos.toByteArray();
                DatagramPacket dp = new DatagramPacket(bild , bild.length , incoming.getAddress() , incoming.getPort());
                piCamera.stop();
                sock.send(dp);                
            }
            
        } 
        catch (IOException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FailedToRunRaspistillException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }        

    }
}
