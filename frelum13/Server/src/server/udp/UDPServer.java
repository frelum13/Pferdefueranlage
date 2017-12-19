/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.udp;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
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
        WebcamPanel wCamPanel = null;
        try {
            
            log.info("Server: Server gestarted");
            DatagramSocket sock = null;
         
            //1. creating a server socket, parameter is local port number
            sock = new DatagramSocket(port);
             
            //buffer to receive incoming data
            byte[] buffer = new byte[57600];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            
            Dimension ds = new Dimension(640, 480);
            Dimension cs = WebcamResolution.HD720.getSize();
            Webcam wCam = Webcam.getDefault();
            wCam.setViewSize(new Dimension(640, 480));
            
             wCamPanel = new WebcamPanel(wCam , ds ,false);
             wCamPanel.start();
   
            while(true)
            {       
                sock.receive(incoming); 
                log.info("UDP: Client hat sich verbunden");
                ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
                ImageIO.write(wCam.getImage(), "JPG", baos);
                baos.flush();
                byte[] bild = baos.toByteArray();
                DatagramPacket dp = new DatagramPacket(bild , bild.length , incoming.getAddress() , incoming.getPort());
                sock.send(dp);
            }
            
        } 
        catch (IOException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
}
