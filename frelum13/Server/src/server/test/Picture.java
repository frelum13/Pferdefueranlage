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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author lukas
 */
public class Picture {
    
    
    
    public static void main(String[] args) {
        
        Dimension cs = WebcamResolution.VGA.getSize();
        Webcam wCam = Webcam.getDefault();
        WebcamPanel wCamPanel = new WebcamPanel(wCam, false);
        
        wCamPanel.start();
        File file = new File(String.format("capture-%d.jpg", System.currentTimeMillis()));
        BufferedImage image = wCam.getImage();
        WritableRaster raster = image.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
        
        byte[] bild = data.getData();
        System.out.println(bild.length);
        wCamPanel.stop();
    }
}
