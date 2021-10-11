/*
 * edited by ChengZhi Zhao
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
/**
 *
 * @author Arsh
 */
public class StartUp extends javax.swing.JFrame {
    
    //Creates new form StartUp
    public StartUp() {
        initComponents();
        setBounds(300,300,600,434);
        setLocationRelativeTo(null);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Exit");
          getRootPane().getActionMap().put("Exit", new AbstractAction() { 
              public void actionPerformed(ActionEvent e) {
                  System.exit(0);
              }
       });
       getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "Credits");
          getRootPane().getActionMap().put("Credits", new AbstractAction() { 
              public void actionPerformed(ActionEvent e) {
                  JOptionPane.showMessageDialog(getRootPane(), "CS2450 Swing Project\n"
                                                             + "Spring 2021\n"
                                                             + "Arsh Chaudhry  #014897038\n"
                                                             + "Yuqing Han        #011964602\n"
                                                             + "Danielle Yap      #3014946308\n"
                                                             + "Chengzhi Zhao  #014347567");
              }
       });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        teamName = new javax.swing.JLabel();
        backGround = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        title.setFont(new java.awt.Font("Bauhaus 93", 2, 50)); // NOI18N
        title.setForeground(new java.awt.Color(51, 102, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("CS2450 Swing Project");
        title.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(title);
        title.setBounds(0, 0, 600, 150);

        teamName.setFont(new java.awt.Font("Bauhaus 93", 2, 22)); // NOI18N
        teamName.setForeground(new java.awt.Color(51, 102, 255));
        teamName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamName.setText("BY: TRYING HARD");
        getContentPane().add(teamName);
        teamName.setBounds(0, 330, 600, 33);
        getContentPane().add(backGround);
        backGround.setBounds(-6, -6, 610, 410);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StartUp start = new StartUp();
                Home home;
                File file = new File("score.txt");
                if(!file.exists()){
                    try {
                        file.createNewFile();
                    } catch (IOException ex) {
                        Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    home = new Home();
                    
                    ActionListener al = new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        home.setVisible(true);
                        start.setVisible(false);
                        }
                     };
                
                    //set up the timer to set the start up panel to false and show the home panel to true.
                    Timer timer = new Timer(3000, al);
                    timer.setRepeats(false);
                    timer.start();
                
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                start.setVisible(true);
                //edited from original code.
                
                
            }
        });
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backGround;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel teamName;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}