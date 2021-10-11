/*
 * edited by Arsh Chaudhry
 */
package Game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.util.*;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * @author danie
 * 
 */

public class PlayColor extends javax.swing.JFrame {

    //Creates new form PlayColor
    public PlayColor(Home homePanel, Highscores scorePanel, int score) {
        initComponents();
        setBounds(300,300,600,434);
        setLocationRelativeTo(null);
        date();
        time();
        this.homePanel = homePanel;
        this.scorePanel = scorePanel;
        this.score = score;
        JButton[] buttonList = new JButton[5];
        components[0] = date; 
        components[1] = time; 
        components[2] = colorText; 
        for (int i=3; i<8; i++) {
            components[i] = colorText;
        }
        randomButtons();
        randomText();
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
    
    // sets and displays clock
    public void date() {
        SimpleDateFormat sDate = new SimpleDateFormat("MMMM dd, yyyy");
        Date dDate = new Date();
        date.setText(sDate.format(dDate));
    }  
    public void time() {
        Timer t = new Timer(0,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sDate = new SimpleDateFormat("hh:mm:ss");
                Date dTime = new Date();
                time.setText(sDate.format(dTime));
            }
        });
        t.start();    
    } 
    
    // creates randomizes button location for 5 buttons, takes in user input
    // adds color to button and updates text when button is clicked
    private void randomButtons() {
        for (int i=0; i<buttonList.length; i++) {
            buttonList[i] = new JButton();
            buttonList[i].setBackground(textColor[i]);
            
            do {
                buttonList[i].setBounds(rand.nextInt(500), rand.nextInt(300), 100, 100);
                buttonList[i].setToolTipText("Click to make your selection");
            } while(buttonIntersect(components, buttonList[i]));
            components[i+3] = buttonList[i];
            buttonList[i].setVisible(true);
            this.add(buttonList[i]);
            
            ActionListener buttonClicked = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = ((JComponent)e.getSource()).getBackground();
                Color color1 = colorText.getForeground();
                
                if(color == color1){
                    score += 100;
                }
                
                if (clickCount < 4) {
                    clickCount++;
                    removeButtons();
                    randomButtons();
                    randomText();
                }
                else {
                    clickCount = 0;
                    new Sudoku(homePanel, scorePanel, score).setVisible(true);
                    disposeObject();
                }
                
            }};
            
            buttonList[i].addActionListener(buttonClicked);
        }
    }
    
    // checks if buttons intersect with anything
    private boolean buttonIntersect(Component[] items, JButton button) {
        for (Component b : items) {
            if (button.getBounds().intersects(b.getBounds()))
                return true;
        }
        return false;
    }
    
    // removes all buttons from screen
    private void removeButtons(){
        for (int i=0; i<buttonList.length; i++) {
            buttonList[i].setEnabled(false);
            buttonList[i].setVisible(false);
            getContentPane().repaint();
        }
    }
    
    public void disposeObject(){
        this.setVisible(false);
        getContentPane().remove(this);
    }
    
    // Randomized text and color
    private void randomText() {
        colorText.setText(colorBank[rand.nextInt(colorBank.length)]);
        colorText.setForeground(textColor[rand.nextInt(colorBank.length)]);
        colorText.setFont(new java.awt.Font("Bauhaus 93", 2, 38));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        colorText = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        time.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        time.setForeground(new java.awt.Color(51, 102, 255));
        time.setText("[time]");
        getContentPane().add(time);
        time.setBounds(500, 0, 100, 30);

        date.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        date.setForeground(new java.awt.Color(51, 102, 255));
        date.setText("[date]");
        getContentPane().add(date);
        date.setBounds(334, 0, 160, 30);

        colorText.setFont(new java.awt.Font("Bauhaus 93", 2, 36)); // NOI18N
        colorText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        colorText.setText("[COLOR]");
        colorText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorText.setMaximumSize(new java.awt.Dimension(200, 100));
        colorText.setMinimumSize(new java.awt.Dimension(200, 100));
        colorText.setPreferredSize(new java.awt.Dimension(200, 100));
        getContentPane().add(colorText);
        colorText.setBounds(201, 140, 200, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private JButton[] buttonList = new JButton[5];
    private final Home homePanel;
    private final Highscores scorePanel;
    Random rand = new Random();
    private int clickCount = 0;
    private int score;
    private final String[] colorBank = {"RED", "YELLOW", "GREEN", "BLUE", "PURPLE"};
    private final Color [] textColor = {new Color(128,0,0), Color.yellow, new Color(0,100,0), new Color(0,0,205), new Color(75,0,130)};
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel colorText;
    private javax.swing.JLabel date;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
    private Component[] components = new Component[8];
}