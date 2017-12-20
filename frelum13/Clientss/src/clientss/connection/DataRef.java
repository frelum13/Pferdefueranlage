package clientss.connection;


import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import clientss.UDPClient;
import clientss.UDPClient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukas
 */
public class DataRef {
    
        DatagramSocket sock = null;
        int port = 5555;
        String s;
        private BufferedImage bild;
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

    public DataRef() {
        
        data();
    }


    public BufferedImage getBild() {
        return bild;
    }       
        
        private void data() 
        {
            
            try
            {
                sock = new DatagramSocket();
                InetAddress host = InetAddress.getByName("192.168.0.115");
                byte[] b = new byte[1];    
                DatagramPacket  dp = new DatagramPacket(b , b.length , host , port);
                
                int count = 0;
           
                sock.send(dp);
                 
                //now receive reply
                //buffer to receive incoming data
                byte[] buffer = new byte[57600];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                sock.receive(reply);
                
                byte[] data = reply.getData();
                
                ByteArrayInputStream bais = new ByteArrayInputStream(data);
               
                bild = ImageIO.read(bais);
            } 
            catch (SocketException ex) 
            {
                Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (UnknownHostException ex) 
            {
                Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }
}
