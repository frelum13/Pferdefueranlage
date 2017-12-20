/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;
/**
    Java ECHO client with UDP sockets example
    Silver Moon (m00n.silv3r@gmail.com)
*/
 
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
 
public class Udp
{
    public static void main(String args[])
    {
        DatagramSocket sock = null;
        int port = 5555;
        String s;
         
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
         
        try
        {
            sock = new DatagramSocket();
            InetAddress host = InetAddress.getByName("127.0.0.1");
            byte[] b = new byte[1];    
            DatagramPacket  dp = new DatagramPacket(b , b.length , host , port);
                
            while(true)
            {  
                
                sock.send(dp);
                 
                //now receive reply
                //buffer to receive incoming data
                byte[] buffer = new byte[57600];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                sock.receive(reply);
                
                byte[] data = reply.getData();
                
                ByteArrayInputStream bais = new ByteArrayInputStream(data);
                
                BufferedImage bild = ImageIO.read(bais);
                
                File file = new File(String.format("capture-%d.jpg", System.currentTimeMillis()));
                ImageIO.write(bild, "JPG", file);
            }
        }             
         
        catch(IOException e)
        {
            System.err.println("IOException " + e);
        } 
    }
     
    //simple function to echo data to terminal
    public static void echo(String msg)
    {
        System.out.println(msg);
    }
}
