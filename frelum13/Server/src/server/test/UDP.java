/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.test;


import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.*;
import javax.imageio.ImageIO;
 
public class UDP
{
    public static void main(String args[])
    {
        DatagramSocket sock = null;
         
        try
        {
            //1. creating a server socket, parameter is local port number
            sock = new DatagramSocket(7777);
             
            //buffer to receive incoming data
            byte[] buffer = new byte[57600];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
             
            //2. Wait for an incoming data
            echo("Server socket created. Waiting for incoming data...");
             
            //communication loop
            while(true)
            {
                sock.receive(incoming);
                Dimension cs = WebcamResolution.VGA.getSize();
                Webcam wCam = Webcam.getDefault();
                WebcamPanel wCamPanel = new WebcamPanel(wCam, false);
        
                wCamPanel.start();
                BufferedImage img = wCam.getImage();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();        
                ImageIO.write(img, "jpg", baos);
                baos.flush();
        
                byte[] bild = baos.toByteArray();
                System.out.println(bild.length);
                
                
                //echo the details of incoming data - client ip : client port - client message
                echo(incoming.getAddress().getHostAddress() + " : " + incoming.getPort());
                
                DatagramPacket dp = new DatagramPacket(bild , bild.length , incoming.getAddress() , incoming.getPort());
                sock.send(dp);
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