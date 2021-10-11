package Game;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Sudoku extends javax.swing.JFrame {

    public Sudoku(Home homePanel, Highscores scorePanel, int score) {
        initComponents();
        setBounds(300,300,600,434);
        setLocationRelativeTo(null);
        date();
        time();
        SudokuGame();
        this.homePanel = homePanel;
        this.scorePanel = scorePanel;
        this.score = score;
        totalScore = 0;
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

   private final int[][] solution =
      {{8, 3, 5, 4, 1, 6, 9, 2, 7},
       {2, 9, 6, 8, 5, 7, 4, 3, 1},
       {4, 1, 7, 2, 9, 3, 6, 5, 8},
       {5, 6, 9, 1, 3, 4, 7, 8, 2},
       {1, 2, 3, 6, 7, 8, 5, 4, 9},
       {7, 4, 8, 5, 2, 9, 1, 6, 3},
       {6, 5, 2, 7, 8, 1, 3, 9, 4},
       {9, 8, 1, 3, 4, 5, 2, 7, 6},
       {3, 7, 4, 9, 6, 2, 8, 1, 5}};
    
    public void SudokuGame() {
      panel.setLayout(new GridLayout(9, 9));
      panel.setBackground(Color.white);
      KeyListener checkCorrectInput = new KeyListener(){//input listener
          
          @Override
          public void keyTyped(KeyEvent event) {
             
          }

          @Override
          public void keyReleased(KeyEvent event) {//when the user release the key
              JTextField source = (JTextField) event.getSource();
              Component component = (Component) event.getSource();
              JFrame frame = (JFrame) SwingUtilities.getRoot(component);
              String temp = source.getText();
              int result;
              if (temp.length() > 0) {//determine whether the user input or not
                  try {
                      result = Integer.parseInt(temp);//convert to integer
                      if (result < 0 || result > 9) {//the range of the result should be larger than 0 and equal to 9, if not then pop up a warning dialog and clear the answer
                          JOptionPane.showMessageDialog(frame, "Invalid input, please try again", "Input warning", JOptionPane.WARNING_MESSAGE);
                          source.setText("");
                      }
                  } catch (NumberFormatException g) {//if the user input a non numeric answer, catch the exception and clear the answer.
                      JOptionPane.showMessageDialog(frame, "Invalid input, please try again", "Input warning", JOptionPane.WARNING_MESSAGE);
                      source.setText("");
                  }

              }
          }

          @Override
          public void keyPressed(KeyEvent event) {
              
          }
        
             
      };
      for (int row = 0; row < 9; ++row) {
         for (int col = 0; col < 9; ++col) {
            textField[row][col] = new JTextField();
            textField[row][col].setHorizontalAlignment(JTextField.CENTER);
            textField[row][col].setFont(new java.awt.Font("Tahoma", 2, 18));
            panel.add(textField[row][col]);
            if (hide[row][col]) {
               textField[row][col].setText("");
               textField[row][col].setEditable(true);
               textField[row][col].setBackground(Color.white);
               textField[row][col].addKeyListener(checkCorrectInput);//input listener
             } else {
               textField[row][col].setText(solution[row][col] + "");
               textField[row][col].setEditable(false);
               textField[row][col].setBackground(Color.white);
               textField[row][col].setForeground(Color.black);
            }
         }
      }
    }
    
    
    
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
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        time.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        time.setForeground(new java.awt.Color(51, 102, 255));
        time.setText("{time}");
        getContentPane().add(time);
        time.setBounds(500, 0, 100, 40);

        date.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        date.setForeground(new java.awt.Color(51, 102, 255));
        date.setText("{date}");
        getContentPane().add(date);
        date.setBounds(360, 0, 130, 40);

        title.setFont(new java.awt.Font("Bauhaus 93", 2, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 102, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("SUDOKU");
        title.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(title);
        title.setBounds(0, 0, 130, 40);

        submit.setBackground(new java.awt.Color(51, 102, 255));
        submit.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        submit.setText("SUBMIT");
        submit.setToolTipText("Check your answer");
        submit.setVerifyInputWhenFocusTarget(false);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(460, 310, 110, 30);

        quit.setBackground(new java.awt.Color(51, 102, 255));
        quit.setFont(new java.awt.Font("Bauhaus 93", 2, 18)); // NOI18N
        quit.setText("QUIT");
        quit.setToolTipText("Quit sudoku game");
        quit.setVerifyInputWhenFocusTarget(false);
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        getContentPane().add(quit);
        quit.setBounds(460, 360, 110, 30);

        panel.setToolTipText("Enter your number choices in the boxes");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(panel);
        panel.setBounds(130, 60, 300, 300);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        boolean temp = false;
        boolean overAll = true;//determine if the user have all correct 
        Component component = (Component)evt.getSource();
        JFrame frame = (JFrame)SwingUtilities.getRoot(component);
        
        if(!submited){
            totalScore = sudokuScore;
            try {//check if the answer is correct
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        temp = hide[i][j];

                        if (textField[i][j].getText().length() > 0) {
                            if (temp == true) {
                                if (Integer.parseInt(textField[i][j].getText()) != solution[i][j]) {//get text from textField and covert it to integer, if the input match the answer then do nothing.
                                    totalScore = totalScore - 10;
                                    overAll = false;
                                }
                            }
                        } else {
                            overAll = false;
                            totalScore = totalScore - 10;
                        }
                    }
                }
            } catch (NumberFormatException e) {//if the user have non-numeric answer then catch the exception and pop up a warning dialog
                JOptionPane.showMessageDialog(frame, "Invalid input, please try again", "Input warning", JOptionPane.WARNING_MESSAGE);
            }

            if (!overAll) {//tell the user to try again
                JOptionPane.showMessageDialog(frame, "Please check your answer", "Answer Incorrect", JOptionPane.INFORMATION_MESSAGE);
            } else {//if all answer correct, then maybe go to the end page
                JOptionPane.showMessageDialog(frame, "Congraduation, you got all correct", "Congraduation", JOptionPane.PLAIN_MESSAGE);

            }
            submited = true;
        }
        else{
            try {//check if the answer is correct
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        temp = hide[i][j];

                        if (textField[i][j].getText().length() > 0) {
                            if (temp == true) {
                                if (Integer.parseInt(textField[i][j].getText()) != solution[i][j]) {//get text from textField and covert it to integer, if the input match the answer then do nothing.
                                    overAll = false;
                                }
                            }
                        } else {
                            overAll = false;
                        }
                    }
                }
            } catch (NumberFormatException e) {//if the user have non-numeric answer then catch the exception and pop up a warning dialog
                JOptionPane.showMessageDialog(frame, "Invalid input, please try again", "Input warning", JOptionPane.WARNING_MESSAGE);
            }

            if (!overAll) {//tell the user to try again
                JOptionPane.showMessageDialog(frame, "Please check your answer", "Answer Incorrect", JOptionPane.INFORMATION_MESSAGE);
            } else {//if all answer correct, then maybe go to the end page
                JOptionPane.showMessageDialog(frame, "Congraduation, you got all correct", "Congraduation", JOptionPane.PLAIN_MESSAGE);

            }
        }
        
    }//GEN-LAST:event_submitActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        totalScore = totalScore + score;
        new GameOver(homePanel, scorePanel, totalScore).setVisible(true);
        this.setVisible(false);
        getContentPane().remove(this);
    }//GEN-LAST:event_quitActionPerformed

    private final boolean[][] hide =
      {{false, true, true, false, true, false, true, true, false},
       {true, true, true, true, true, true, false, true, true},
       {true, false, true, true, true, true, false, false, true},
       {false, true, false, true, false, true, false, false, true},
       {true, true, true, true, false, true, true, true, true},
       {true, false, false, true, false, true, false, true, false},
       {true, false, false, true, true, true, true, false, true},
       {true, true, false, true, true, true, true, true, true},
       {false, true, true, false, true, false, true, true, false}};
    private JTextField[][] textField = new JTextField[9][9]; 
    private final int sudokuScore = 540;
    private int totalScore;
    private int score;
    private boolean submited = false;
    private final Home homePanel;
    private final Highscores scorePanel;    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton quit;
    private javax.swing.JButton submit;
    private javax.swing.JLabel time;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
