/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * @author Arsh
 */

public class Credits extends javax.swing.JFrame {

    //Creates new form Credits
    public Credits(Home home) {
        initComponents();
        setBounds(300,300,600,434);
        setLocationRelativeTo(null);
        this.homePanel = home;
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

        creditTitle = new javax.swing.JLabel();
        arshName = new javax.swing.JLabel();
        arshID = new javax.swing.JLabel();
        hanName = new javax.swing.JLabel();
        hanID = new javax.swing.JLabel();
        yapName = new javax.swing.JLabel();
        yapID = new javax.swing.JLabel();
        zhaoName = new javax.swing.JLabel();
        zhaoID = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        backGround = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        creditTitle.setFont(new java.awt.Font("Bauhaus 93", 2, 58)); // NOI18N
        creditTitle.setForeground(new java.awt.Color(51, 102, 255));
        creditTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        creditTitle.setText("CREDITS");
        creditTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(creditTitle);
        creditTitle.setBounds(0, 40, 600, 80);

        arshName.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        arshName.setForeground(new java.awt.Color(51, 102, 255));
        arshName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arshName.setText("ARSH CHAUDHRY");
        arshName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(arshName);
        arshName.setBounds(70, 130, 200, 40);

        arshID.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        arshID.setForeground(new java.awt.Color(51, 102, 255));
        arshID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arshID.setText("BRONCO #014897038");
        arshID.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(arshID);
        arshID.setBounds(290, 130, 270, 40);

        hanName.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        hanName.setForeground(new java.awt.Color(51, 102, 255));
        hanName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hanName.setText("YUQING HAN");
        hanName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(hanName);
        hanName.setBounds(70, 170, 200, 40);

        hanID.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        hanID.setForeground(new java.awt.Color(51, 102, 255));
        hanID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hanID.setText("BRONCO #011964602");
        hanID.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(hanID);
        hanID.setBounds(290, 170, 270, 40);

        yapName.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        yapName.setForeground(new java.awt.Color(51, 102, 255));
        yapName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yapName.setText("DANIELLE YAP");
        yapName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(yapName);
        yapName.setBounds(70, 210, 200, 40);

        yapID.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        yapID.setForeground(new java.awt.Color(51, 102, 255));
        yapID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yapID.setText("BRONCO #014946308");
        yapID.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(yapID);
        yapID.setBounds(290, 210, 270, 40);

        zhaoName.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        zhaoName.setForeground(new java.awt.Color(51, 102, 255));
        zhaoName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zhaoName.setText("CHENGZHI ZHAO");
        zhaoName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(zhaoName);
        zhaoName.setBounds(70, 250, 200, 40);

        zhaoID.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        zhaoID.setForeground(new java.awt.Color(51, 102, 255));
        zhaoID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zhaoID.setText("BRONCO #014347567");
        zhaoID.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(zhaoID);
        zhaoID.setBounds(290, 250, 270, 40);

        backButton.setBackground(new java.awt.Color(51, 102, 255));
        backButton.setFont(new java.awt.Font("Bauhaus 93", 2, 14)); // NOI18N
        backButton.setText("BACK");
        backButton.setToolTipText("Move back to the home screen");
        backButton.setBorder(null);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(10, 370, 50, 21);

        backGround.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        backGround.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 600, 400);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // returns home when pressed
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        homePanel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private final Home homePanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arshID;
    private javax.swing.JLabel arshName;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel creditTitle;
    private javax.swing.JLabel hanID;
    private javax.swing.JLabel hanName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel yapID;
    private javax.swing.JLabel yapName;
    private javax.swing.JLabel zhaoID;
    private javax.swing.JLabel zhaoName;
    // End of variables declaration//GEN-END:variables
}
