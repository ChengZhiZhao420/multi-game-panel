package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.util.Random;

public class Pong extends javax.swing.JFrame {

    public Pong() {
        initComponents();
        setBounds(300,300,600,434);
        setLocationRelativeTo(null);
        date();
        time();
        underlineTitles();
        pongPanel.add(pongGame);
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
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sDate = new SimpleDateFormat("hh:mm:ss");
                Date dTime = new Date();
                time.setText(sDate.format(dTime));
            }
        });
        t.start();    
    } 
    
    // underlines the player titles
    public void underlineTitles() {
        Font font1 = p1Title.getFont();
        Font font2 = p2Title.getFont();
        Map attributes1 = font1.getAttributes();
        Map attributes2 = font2.getAttributes();
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        p1Title.setFont(font1.deriveFont(attributes1));
        p2Title.setFont(font2.deriveFont(attributes1));
    }  
    
    public void setScore(int userNum, int score){
        if(userNum == 2){
            p1Score.setText("" + score);
        }
        else if(userNum == 1){
            p2Score.setText("" + score);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pongTitle = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        p1Title = new javax.swing.JLabel();
        p2Title = new javax.swing.JLabel();
        p1Score = new javax.swing.JLabel();
        p2Score = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        pongPanel = new PongGame(this);
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pongTitle.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        pongTitle.setForeground(new java.awt.Color(255, 255, 255));
        pongTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pongTitle.setText("PONG");
        getContentPane().add(pongTitle);
        pongTitle.setBounds(10, 10, 80, 30);

        time.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("[time]");
        getContentPane().add(time);
        time.setBounds(500, 10, 100, 30);

        date.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("[date]");
        getContentPane().add(date);
        date.setBounds(350, 10, 160, 30);

        p1Title.setFont(new java.awt.Font("Bauhaus 93", 2, 22)); // NOI18N
        p1Title.setForeground(new java.awt.Color(255, 51, 102));
        p1Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Title.setText("PLAYER 1");
        getContentPane().add(p1Title);
        p1Title.setBounds(70, 320, 140, 30);

        p2Title.setFont(new java.awt.Font("Bauhaus 93", 2, 22)); // NOI18N
        p2Title.setForeground(new java.awt.Color(51, 102, 255));
        p2Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2Title.setText("PLAYER 2");
        getContentPane().add(p2Title);
        p2Title.setBounds(390, 320, 140, 30);

        p1Score.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        p1Score.setForeground(new java.awt.Color(255, 51, 102));
        p1Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Score.setText("0");
        getContentPane().add(p1Score);
        p1Score.setBounds(90, 345, 100, 30);

        p2Score.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        p2Score.setForeground(new java.awt.Color(51, 102, 255));
        p2Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2Score.setText("0");
        getContentPane().add(p2Score);
        p2Score.setBounds(410, 345, 100, 30);

        quitButton.setBackground(new java.awt.Color(51, 102, 255));
        quitButton.setFont(new java.awt.Font("Bauhaus 93", 2, 14)); // NOI18N
        quitButton.setText("QUIT");
        quitButton.setToolTipText("End Pong game, return to home");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(quitButton);
        quitButton.setBounds(265, 360, 65, 29);

        pongPanel.setBackground(new java.awt.Color(204, 204, 204));
        pongPanel.setToolTipText("Game of pong!");

        javax.swing.GroupLayout pongPanelLayout = new javax.swing.GroupLayout(pongPanel);
        pongPanel.setLayout(pongPanelLayout);
        pongPanelLayout.setHorizontalGroup(
            pongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        pongPanelLayout.setVerticalGroup(
            pongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        getContentPane().add(pongPanel);
        pongPanel.setBounds(75, 40, 450, 280);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        try {
            new Home().setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_quitButtonActionPerformed

    private PongGame pongGame = new PongGame(this);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel p1Score;
    private javax.swing.JLabel p1Title;
    private javax.swing.JLabel p2Score;
    private javax.swing.JLabel p2Title;
    private javax.swing.JPanel pongPanel;
    private javax.swing.JLabel pongTitle;
    private javax.swing.JButton quitButton;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}


class PongGame extends javax.swing.JPanel implements Runnable, KeyListener{
    private boolean start = false;
    private Ball b1 = new Ball();
    private static boolean reset;
    private static int p1Score;
    private static int p2Score;
    private Paddle p1 = new Paddle(10, 90, 1);
    private Paddle p2 = new Paddle(425, 90, 2);
    private Thread thread;
    private Pong pongPanel;
    
    public PongGame(Pong pongPanel){
        init();
        this.pongPanel = pongPanel;
    }
    
    public void init(){
        thread = new Thread(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        thread.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        b1.draw(g);
        p1.draw(g);
        p2.draw(g);
        
        if(!start){
            g.setColor(Color.BLACK);
            g.drawString("Press Space to Begin", 180, 140);

        }
    }
    
    public void reset() {
        start = false;
        reset = true;
        p1.setY(90);
        p2.setY(90);
        b1.setX(225);
        b1.setY(140);
    }
    
    @Override
    public void run() {
        for (;;) {
            if (start) {
                p1.move();
                p2.move();
                b1.move();
                b1.checkCollion(p1, p2);

                if (b1.getX() >= 444) {
                    p2Score += 10;
                    pongPanel.setScore(2, p2Score);
                    reset();
                } else if (b1.getX() < -6) {
                    p1Score += 10;
                    pongPanel.setScore(1, p1Score);
                    reset();
                }
                if (p1Score >= 100) {
                    JOptionPane.showMessageDialog(getRootPane(), "Player 2 Wins!");
                    p1Score = 0;
                    p2Score = 0;
                    pongPanel.setScore(1, p1Score);
                    pongPanel.setScore(2, p2Score);
                    reset();
                }
                if (p2Score >= 100) {
                    JOptionPane.showMessageDialog(getRootPane(), "Player 1 Wins!");
                    p1Score = 0;
                    p2Score = 0;
                    pongPanel.setScore(1, p1Score);
                    pongPanel.setScore(2, p2Score);
                    reset();
                }

            }
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_W -> p1.setMoveUpward(true);
            case KeyEvent.VK_S -> p1.setMoveDownward(true);
            case KeyEvent.VK_UP -> p2.setMoveUpward(true);
            case KeyEvent.VK_DOWN -> p2.setMoveDownward(true);
            case KeyEvent.VK_SPACE -> start = true;
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_W -> p1.setMoveUpward(false);
            case KeyEvent.VK_S -> p1.setMoveDownward(false);
            case KeyEvent.VK_UP -> p2.setMoveUpward(false);
            case KeyEvent.VK_DOWN -> p2.setMoveDownward(false);
            default -> {
            }
        }
    }
        
      
}
	
class Ball {
    private double x, y, xVel, yVel;

    public Ball(){
        x = 225;
        y = 140;
        xVel = -2;
        yVel = 1;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillOval((int)x, (int)y, 12, 12);
    }
    
    public void move(){
        x += xVel;
        y += yVel;
        
        if(y < 12 || y > 268){
            yVel = -yVel;
        }
               
    }
    
    public int getX(){
        return (int)x;
    }
    
    public int getY(){
        return (int)y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void checkCollion(Paddle p1, Paddle p2){//pass in the Paddle object, uses for if the ball the paddle then the ball will bounce another direction
        if(x <= 31){//check if the ball is on the left range, 31 = width of the paddle + the location of x-axis of the paddle + the radius of the ball
            if(y >= p1.getY() && y <= p1.getY() + 50){//paddle range, 50 is the height of the paddle
                xVel = -xVel;//bounce to another direction
            }
        }else if (x >= 404){
            if(y >= p2.getY() && y <= p2.getY() + 50){
                xVel = -xVel;
            }
        }
    }
    
    
}

   class Paddle {

    /*
        x = x coordinate of paddle
        y = y coordinate of paddle
        player = used to distunguish player on left (player 1) and right (player 2)
     */
    int x, player;
    double y, yVel;
    boolean moveUp = false, moveDown = false;

    public Paddle(int x, double y, int player) {
        this.x = x;
        this.y = y;
        this.player = player;

    }

    public int getY() {
        return (int) y;
    }

    public void setY(int newY) {
        y = newY;
    }

    // draws paddles
    public void draw(Graphics p) {
        if (player == 1) {
            p.setColor(Color.red);
        }
        if (player == 2) {
            p.setColor(Color.blue);
        }
        p.fillRect(x, (int) y, 15, 50);
    }

    // moves paddle when called
    public void move() {
        if (moveUp) {
            yVel -= 2;
        } else if (moveDown) {
            yVel += 2;
        } else if (!moveUp && !moveDown) {
            yVel = 0;
        }

        y += yVel;
        // prevents from moving past boundaries
        if (y >= 230) {
            y = 230;
        }
        if (y <= 0) {
            y = 0;
        }
    }

    public void setMoveUpward(boolean input) {
        moveUp = input;
    }

    public void setMoveDownward(boolean input) {
        moveDown = input;
    }

}
