/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientss;

import clientss.connection.DataRef;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;


/**
 *
 * @author lukas
 */
public class UDPClient extends javax.swing.JFrame 
{
  
    private int TIME = 0;
    
    public UDPClient() {
        initComponents();
        new Thread(new Dauer()).start();
        System.out.println("Hallo");
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel = new javax.swing.JPanel();
        slow = new javax.swing.JButton();
        fast = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanImage = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        getContentPane().add(jPanel, java.awt.BorderLayout.PAGE_END);

        jPanImage.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanImage, java.awt.BorderLayout.CENTER);

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
    
    private void slowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slowActionPerformed
        TIME = 2000;
    }//GEN-LAST:event_slowActionPerformed

    private void fastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastActionPerformed
        TIME = 500;
    }//GEN-LAST:event_fastActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TIME = 0;
        jPanImage.removeAll();
        pack();
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
    private javax.swing.JButton fast;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanImage;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JButton slow;
    // End of variables declaration//GEN-END:variables
}
