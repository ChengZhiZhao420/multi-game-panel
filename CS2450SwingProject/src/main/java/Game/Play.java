package Game;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Play extends javax.swing.JFrame {

    public Play(Home homePanel, Highscores scorePanel) {
        initComponents();
        setBounds(300,300,600,434);
        setLocationRelativeTo(null);
        date();
        time();
        createDash(randomWord);
        createAlphabet();
        this.homePanel = homePanel;
        this.scorePanel = scorePanel;     
        picLabel = new JLabel(image1);
        picLabel.setBounds(120, 60, 360, 190);        
        add(picLabel);
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
    
    // creates blank guessing space
    public void createDash(String randomWord) {
        dashLine = new JLabel[randomWord.length()];
        Container container = new Container();
        
        container.setLayout(new GridLayout(1, randomWord.length()));
        container.setBounds(100, 254, 400, 40);
        
        for(int i = 0; i < randomWord.length(); i++){
            dashLine[i] = new JLabel("_");
            container.add(dashLine[i]);
        }       
        getContentPane().add(container);
    }
    
    // sets up buttons and takes in user input
    public ArrayList<javax.swing.JButton> createAlphabet()
    {
        ArrayList<javax.swing.JButton> alphabetB = new ArrayList<>();
        int [] original = {5,300,40,40};
        int x = 5;
        int y = 300;
        int length = 40;
        int width = 40;
        int startButton = 1;
        
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++)
        {
            javax.swing.JButton alphaButtons = new javax.swing.JButton();
            alphaButtons.setBorder(null);
            alphaButtons.setFont(new java.awt.Font("Bauhaus 93", 2, 19));
            alphaButtons.setBackground(new java.awt.Color(0,0,0));
            alphaButtons.setForeground(new java.awt.Color(51, 102, 255));
            alphaButtons.setText("" + alphabet);
            alphaButtons.setOpaque(true);
            alphaButtons.setBounds(x, y, length, width);
            alphaButtons.setToolTipText("Click to make your letter selection");
            getContentPane().add(alphaButtons);
            x += 45;
            if(startButton == 13)
            {
                x = original[0];
                y += 50;
            }
            startButton++;
            alphabetB.add(alphaButtons);
            alphaButtons.setVisible(true);

            alphaButtons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllButtonActionPerformed(evt);
            }
                private void AllButtonActionPerformed(ActionEvent evt) {                    
                    if(error == 0 && !(randomWord.contains(alphaButtons.getText()))){
                        picLabel.setIcon(image2);
                        score -= 10;
                        error++;
                        userScore.setText(Integer.toString(score));
                        alphaButtons.setVisible(false);
                    }
                    else if(error == 1 && !(randomWord.contains(alphaButtons.getText()))){
                        picLabel.setIcon(image3);
                        score -= 10;
                        error++;
                        userScore.setText(Integer.toString(score));
                        alphaButtons.setVisible(false);
                    }
                    else if(error == 2 && !(randomWord.contains(alphaButtons.getText()))){
                        picLabel.setIcon(image4);
                        score -= 10;
                        error++;
                        userScore.setText(Integer.toString(score));
                        alphaButtons.setVisible(false);
                    }
                    else if(error == 3 && !(randomWord.contains(alphaButtons.getText()))){
                        picLabel.setIcon(image5);
                        score -= 10;
                        error++;
                        userScore.setText(Integer.toString(score));
                        alphaButtons.setVisible(false);
                    }
                    else if(error == 4 && !(randomWord.contains(alphaButtons.getText()))){
                        picLabel.setIcon(image6);
                        score -= 10;
                        error++;
                        userScore.setText(Integer.toString(score));
                        alphaButtons.setVisible(false);
                    }
                    else if(error == 5 && !(randomWord.contains(alphaButtons.getText()))){
                        picLabel.setIcon(image7);
                        score -= 10;
                        error++;
                        userScore.setText(Integer.toString(score));
                        alphaButtons.setVisible(false);
                    }
                    else if(error < 6 && (randomWord.contains(alphaButtons.getText()))){
                        for (int i = 0; i < randomWord.length(); i++) {
                            if (alphaButtons.getText().toLowerCase().charAt(0) == randomWord.charAt(i)) {
                                dashLine[i].setText(alphaButtons.getText());
                                counter[i] = true;
                        }
                        alphaButtons.setVisible(false);
                        }
                    }
                   
                    boolean win = true;
                    for(int i = 0; i < counter.length; i++){
                        if(!counter[i]){
                            win = false;
                        }
                    }
                    
                    if(win == true){
                        PlayColor colorPanel = new PlayColor(homePanel, scorePanel, score);
                        colorPanel.setVisible(true);
                        disposeObject();
                        
                    }
                    
                    if(error == 6){
                        PlayColor colorPanel = new PlayColor(homePanel, scorePanel, score);
                        colorPanel.setVisible(true);
                        disposeObject();
                        
                    }                    
                }
            });
        }
        return alphabetB;
    }
    
    public int getScore(){
        return score;
    }
  
    public void disposeObject(){
        this.setVisible(false);
        getContentPane().remove(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        skipButton = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        hangMan = new javax.swing.JLabel();
        scoreTitle = new javax.swing.JLabel();
        userScore = new javax.swing.JLabel();
        hiddenWordLabel = new javax.swing.JLabel();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        skipButton.setBackground(new java.awt.Color(51, 102, 255));
        skipButton.setFont(new java.awt.Font("Bauhaus 93", 2, 14)); // NOI18N
        skipButton.setText("SKIP");
        skipButton.setToolTipText("Skip the hangman game (score will be set to zero)");
        skipButton.setBorder(null);
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });
        getContentPane().add(skipButton);
        skipButton.setBounds(520, 30, 60, 29);

        date.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        date.setForeground(new java.awt.Color(51, 102, 255));
        date.setText("[date]");
        getContentPane().add(date);
        date.setBounds(340, 5, 170, 30);

        time.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        time.setForeground(new java.awt.Color(51, 102, 255));
        time.setText("[time]");
        getContentPane().add(time);
        time.setBounds(500, 5, 100, 30);

        title.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 102, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("HANGMAN");
        getContentPane().add(title);
        title.setBounds(10, 10, 120, 40);
        getContentPane().add(hangMan);
        hangMan.setBounds(120, 60, 360, 190);

        scoreTitle.setFont(new java.awt.Font("Bauhaus 93", 2, 20)); // NOI18N
        scoreTitle.setForeground(new java.awt.Color(51, 102, 255));
        scoreTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreTitle.setText("SCORE:");
        getContentPane().add(scoreTitle);
        scoreTitle.setBounds(230, 30, 80, 30);

        userScore.setFont(new java.awt.Font("Bauhaus 93", 2, 20)); // NOI18N
        userScore.setForeground(new java.awt.Color(51, 102, 255));
        userScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userScore.setText("100");
        getContentPane().add(userScore);
        userScore.setBounds(310, 30, 40, 30);

        hiddenWordLabel.setFont(new java.awt.Font("Bauhaus 93", 2, 26)); // NOI18N
        hiddenWordLabel.setForeground(new java.awt.Color(51, 102, 255));
        hiddenWordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hiddenWordLabel);
        hiddenWordLabel.setBounds(100, 254, 400, 40);

        backGround.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    // sets score to 0 and goes to game over screen
    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        score = 0;
        new PlayColor(homePanel, scorePanel, score).setVisible(true);
        disposeObject();
    }//GEN-LAST:event_skipButtonActionPerformed
    
    private Random rand = new Random();
    private String[] wordBank = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
    private String randomWord = wordBank[rand.nextInt(wordBank.length)];
    private JLabel[] dashLine;
    private JLabel picLabel;
    private boolean[] counter = new boolean[randomWord.length()];
    public int score = 100;
    private Home homePanel;
    private Highscores scorePanel;
    private BufferedImage pic = null;
    private int error = 0;
    private final ImageIcon image1 = new ImageIcon("Hangman-0.png");
    private ImageIcon image2 = new ImageIcon("Hangman-1.png");
    private ImageIcon image3 = new ImageIcon("Hangman-2.png");
    private ImageIcon image4 = new ImageIcon("Hangman-3.png");
    private ImageIcon image5 = new ImageIcon("Hangman-4.png");
    private ImageIcon image6 = new ImageIcon("Hangman-5.png");
    private ImageIcon image7 = new ImageIcon("Hangman-6.png");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel date;
    private javax.swing.JLabel hangMan;
    private javax.swing.JLabel hiddenWordLabel;
    private javax.swing.JLabel scoreTitle;
    private javax.swing.JButton skipButton;
    private javax.swing.JLabel time;
    private javax.swing.JLabel title;
    public javax.swing.JLabel userScore;
    // End of variables declaration//GEN-END:variables
}
