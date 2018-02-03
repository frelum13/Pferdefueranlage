/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientss.gui;

import clientss.connection.DataRef;
import clientss.data.Command;
import clientss.json.Jsonbau;
import java.util.concurrent.TimeUnit;
import javax.json.JsonObject;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;


/**
 *
 * @author lukas
 */
public class UDPClient extends javax.swing.JFrame 
{
    public static String NAME = "";
    private int TIME = 0;
    
    public UDPClient() {
        initComponents();
        new Thread(new Dauer()).start();
        new Thread(new Response()).start();
        fillComboBoxes();
        jName.setVisible(false);
        jtName.setVisible(false);
        jTime.setVisible(false);
        jtTime.setVisible(false);
        jTurnaround.setVisible(false);
        jtTurnaround.setVisible(false);
        jSpeed.setVisible(false);
        jtSpeed.setVisible(false); 
        jWater.setVisible(false);
        jtWater.setVisible(false);
        jid.setVisible(true);
        jtId.setVisible(true);
    }

    private void fillComboBoxes()
    {
        for(Command command : Command.values())
            cbCommand.addItem(command);
            
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel3 = new javax.swing.JPanel();
        jPanTCP = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanRequest = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanButton = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jtName = new javax.swing.JTextField();
        jName = new javax.swing.JLabel();
        jTime = new javax.swing.JLabel();
        jTurnaround = new javax.swing.JLabel();
        jtTime = new javax.swing.JFormattedTextField();
        jtTurnaround = new javax.swing.JFormattedTextField();
        jtSpeed = new javax.swing.JFormattedTextField();
        jSpeed = new javax.swing.JLabel();
        cbCommand = new javax.swing.JComboBox<>();
        jid = new javax.swing.JLabel();
        jtId = new javax.swing.JFormattedTextField();
        jtWater = new javax.swing.JCheckBox();
        jWater = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanResponse = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtResponse = new javax.swing.JTextField();
        jPanUDP = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        slow = new javax.swing.JButton();
        fast = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanImage = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1000, 500));

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanTCP.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Request", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanRequest.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("command");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanRequest.add(jLabel1, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(242, 17, 17));
        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton2.setText("Senden");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanButton.add(jButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(46, 11, 11, 11);
        jPanRequest.add(jPanButton, gridBagConstraints);

        jtName.setColumns(10);
        jtName.setText("Hallo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanRequest.add(jtName, gridBagConstraints);

        jName.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanRequest.add(jName, gridBagConstraints);

        jTime.setText("Time");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanRequest.add(jTime, gridBagConstraints);

        jTurnaround.setText("Turnaround");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanRequest.add(jTurnaround, gridBagConstraints);

        jtTime.setColumns(10);
        jtTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jtTime.setText("1");
        jtTime.setToolTipText("");
        jtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanRequest.add(jtTime, gridBagConstraints);

        jtTurnaround.setColumns(10);
        jtTurnaround.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jtTurnaround.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanRequest.add(jtTurnaround, gridBagConstraints);

        jtSpeed.setColumns(10);
        jtSpeed.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jtSpeed.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanRequest.add(jtSpeed, gridBagConstraints);

        jSpeed.setText("Speed");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanRequest.add(jSpeed, gridBagConstraints);

        cbCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCommandActionPerformed(evt);
            }
        });
        jPanRequest.add(cbCommand, new java.awt.GridBagConstraints());

        jid.setText("id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanRequest.add(jid, gridBagConstraints);

        jtId.setColumns(10);
        jtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jtId.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanRequest.add(jtId, gridBagConstraints);

        jtWater.setText("off");
        jtWater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtWaterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        jPanRequest.add(jtWater, gridBagConstraints);

        jWater.setText("water");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanRequest.add(jWater, gridBagConstraints);

        jPanel1.add(jPanRequest, java.awt.BorderLayout.CENTER);

        jPanTCP.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Response", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Response");
        jPanResponse.add(jLabel2);

        jtResponse.setColumns(50);
        jPanResponse.add(jtResponse);

        jPanel2.add(jPanResponse, java.awt.BorderLayout.SOUTH);

        jPanTCP.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.add(jPanTCP, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        jPanUDP.setLayout(new java.awt.BorderLayout());

        slow.setText("slow");
        slow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slowActionPerformed(evt);
            }
        });
        jPanel.add(slow);

        fast.setText("fast");
        fast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastActionPerformed(evt);
            }
        });
        jPanel.add(fast);

        jButton1.setText("stop");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel.add(jButton1);

        jPanUDP.add(jPanel, java.awt.BorderLayout.SOUTH);
        jPanUDP.add(jPanImage, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanUDP, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    public class Dauer implements Runnable
    {

        @Override
        public void run() 
        {
            try 
            {
                while(true)
                {
                    if(TIME == 0) 
                    {
                        System.out.print("");
                    }
                    else
                    {
                        new UDPWorker().execute();
                        TimeUnit.MILLISECONDS.sleep(TIME);
                    }     
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        
    }
    
    private class Response implements Runnable 
    {

        @Override
        public void run() {
            while(true)
            {
                
                jtResponse.setText(NAME);
            }
        }
        
    }
    
    private class UDPWorker extends SwingWorker<DataRef, Object>
    {

        @Override
        protected DataRef doInBackground() throws Exception {
            return new DataRef();
        }

        @Override
        protected void done() 
        {
            try 
            {
                final DataRef rechner = get();
                
                jPanImage.removeAll();
                jPanImage.add(new JLabel(new ImageIcon(rechner.getBild())));
                pack();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }   
        }
    }
    
    private void aufbau(String command) 
    {
        switch(command)
        {
            case "login":  
                jWater.setVisible(false);
                jtWater.setVisible(false);
                jid.setVisible(false);
                jtId.setVisible(false);
                jName.setVisible(false);
                jtName.setVisible(false);
                jTime.setVisible(false);
                jtTime.setVisible(false);
                jTurnaround.setVisible(false);
                jtTurnaround.setVisible(false);
                jSpeed.setVisible(false);
                jtSpeed.setVisible(false);
                break;
            
            case "delete": 
                jWater.setVisible(false);
                jtWater.setVisible(false);
                jid.setVisible(true);
                jtId.setVisible(true);
                jName.setVisible(false);
                jtName.setVisible(false);
                jTime.setVisible(false);
                jtTime.setVisible(false);
                jTurnaround.setVisible(false);
                jtTurnaround.setVisible(false);
                jSpeed.setVisible(false);
                jtSpeed.setVisible(false);
                break;
            case "new": 
                jWater.setVisible(false);
                jtWater.setVisible(false);
                jid.setVisible(false);
                jtId.setVisible(false);
                jName.setVisible(true);
                jtName.setVisible(true);
                jTime.setVisible(true);
                jtTime.setVisible(true);
                jTurnaround.setVisible(true);
                jtTurnaround.setVisible(true);
                jSpeed.setVisible(true);
                jtSpeed.setVisible(true);
                break;
            case "all": 
                jWater.setVisible(false);
                jtWater.setVisible(false);
                jid.setVisible(false);
                jtId.setVisible(false);
                jName.setVisible(false);
                jtName.setVisible(false);
                jTime.setVisible(false);
                jtTime.setVisible(false);
                jTurnaround.setVisible(false);
                jtTurnaround.setVisible(false);
                jSpeed.setVisible(false);
                jtSpeed.setVisible(false);
                break;
            case "info": 
                jWater.setVisible(false);
                jtWater.setVisible(false);
                jid.setVisible(true);
                jtId.setVisible(true);
                jName.setVisible(false);
                jtName.setVisible(false);
                jTime.setVisible(false);
                jtTime.setVisible(false);
                jTurnaround.setVisible(false);
                jtTurnaround.setVisible(false);
                jSpeed.setVisible(false);
                jtSpeed.setVisible(false);
                break;
            case "get": 
                jName.setVisible(false);
                jtName.setVisible(false);
                jTime.setVisible(false);
                jtTime.setVisible(false);
                jTurnaround.setVisible(false);
                jtTurnaround.setVisible(false);
                jSpeed.setVisible(false);
                jtSpeed.setVisible(false);
                break;
            case "water": 
                jWater.setVisible(true);
                jtWater.setVisible(true);
                jid.setVisible(false);
                jtId.setVisible(false);
                jName.setVisible(false);
                jtName.setVisible(false);
                jTime.setVisible(false);
                jtTime.setVisible(false);
                jTurnaround.setVisible(false);
                jtTurnaround.setVisible(false);
                jSpeed.setVisible(false);
                jtSpeed.setVisible(false);break;
            case "start": 
                jWater.setVisible(false);
                jtWater.setVisible(false);
                jid.setVisible(true);
                jtId.setVisible(true);
                jName.setVisible(false);
                jtName.setVisible(false);
                jTime.setVisible(false);
                jtTime.setVisible(false);
                jTurnaround.setVisible(false);
                jtTurnaround.setVisible(false);
                jSpeed.setVisible(false);
                jtSpeed.setVisible(false);
                break;
            case "stop": 
                jWater.setVisible(false);
                jtWater.setVisible(false);
                jid.setVisible(false);
                jtId.setVisible(false);
                jName.setVisible(true);
                jtName.setVisible(true);
                jTime.setVisible(false);
                jtTime.setVisible(false);
                jTurnaround.setVisible(false);
                jtTurnaround.setVisible(false);
                jSpeed.setVisible(false);
                jtSpeed.setVisible(false);
                break;
            case "version": 
                jWater.setVisible(false);
                jtWater.setVisible(false);
                jid.setVisible(false);
                jtId.setVisible(false);
                jName.setVisible(false);
                jtName.setVisible(false);
                jTime.setVisible(false);
                jtTime.setVisible(false);
                jTurnaround.setVisible(false);
                jtTurnaround.setVisible(false);
                jSpeed.setVisible(false);
                jtSpeed.setVisible(false);
                break;  
        }
    }
    
    private void slowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slowActionPerformed
        TIME = 2000;
    }//GEN-LAST:event_slowActionPerformed

    private void fastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastActionPerformed
        TIME = 1;
    }//GEN-LAST:event_fastActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TIME = 0;
        jPanImage.removeAll();
        pack();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int id=0 ,time= 0, speed= 0, turnaround= 0;
        boolean water = false;
        String name = "Hallo";
        String command = cbCommand.getSelectedItem().toString();
        
        try 
        {
            if(jtId.isVisible()==true)
                id = ((Number) jtId.getValue()).intValue();       
            if(jtTime.isVisible() == true)
                time = ((Number) jtTime.getValue()).intValue();
            if(jtTurnaround.isVisible() == true)
                turnaround = ((Number) jtTurnaround.getValue()).intValue();
            if(jtSpeed.isVisible() == true)
                speed = ((Number) jtSpeed.getValue()).intValue();
            if(jtWater.isVisible() == true)
                water = jtWater.isSelected();
            if(jtName.isVisible() == true)
                name = jtName.getText();
            
            Jsonbau bau = new Jsonbau(id, time, turnaround, speed, name, water, command);
            JsonObject build = bau.getBuild();
        
            new Thread(new clientss.tcp.Client(build)).start();
            
            jtResponse.setText(NAME);
        } 
        catch (NullPointerException e) 
        {
            JOptionPane.showMessageDialog(this, "Falsche Eingabe",e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCommandActionPerformed
        String command = cbCommand.getSelectedItem().toString();
        aufbau(command);
    }//GEN-LAST:event_cbCommandActionPerformed

    private void jtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTimeActionPerformed

    private void jtWaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtWaterActionPerformed
        
        if(jtWater.getText() == "on")
        {
            jtWater.setText("off");  
        }
        else
        {
            jtWater.setText("on");
        }
        
    }//GEN-LAST:event_jtWaterActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
       
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UDPClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UDPClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UDPClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UDPClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UDPClient().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Command> cbCommand;
    private javax.swing.JButton fast;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jName;
    private javax.swing.JPanel jPanButton;
    private javax.swing.JPanel jPanImage;
    private javax.swing.JPanel jPanRequest;
    private javax.swing.JPanel jPanResponse;
    private javax.swing.JPanel jPanTCP;
    private javax.swing.JPanel jPanUDP;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel jSpeed;
    private javax.swing.JLabel jTime;
    private javax.swing.JLabel jTurnaround;
    private javax.swing.JLabel jWater;
    private javax.swing.JLabel jid;
    private javax.swing.JFormattedTextField jtId;
    private javax.swing.JTextField jtName;
    private javax.swing.JTextField jtResponse;
    private javax.swing.JFormattedTextField jtSpeed;
    private javax.swing.JFormattedTextField jtTime;
    private javax.swing.JFormattedTextField jtTurnaround;
    private javax.swing.JCheckBox jtWater;
    private javax.swing.JButton slow;
    // End of variables declaration//GEN-END:variables
}
