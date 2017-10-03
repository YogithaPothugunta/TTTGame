package TTTpackage;

//import com.sun.tools.javac.comp.Flow;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class GameBoard extends Applet{
    
    Player[] players = new Player[2];
    int currentPlayer = 0;
    private JPanel topPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    Label turnLabel = new Label("Game Needs to be Stated");
    Button startButton = new Button("START GAME");
    
    TTTButton[] cellButton = new TTTButton[9];
    
   
    @Override
    public void init() {
        
        super.init();
       
        resize(260, 390);
        // Initialize players
       players[0] = new Player("Player1", "X");
       players[1] = new Player("Player2", "O");

        // Set top panel
        add(topPanel);
        
        topPanel.setPreferredSize(new Dimension(250, 40));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.add(turnLabel);        
        turnLabel.setFont(new Font("Serif", Font.BOLD, 18));
        turnLabel.setText("Game Needs to be Stated!!");
        turnLabel.setForeground(Color.blue);
             
        // Set board panel
        add(boardPanel);
        boardPanel.setPreferredSize(new Dimension(250, 250));
        boardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        for(int i = 0; i < 9; i++)
        {
           
            cellButton[i] = new TTTButton(i);
            cellButton[i].setPreferredSize(new Dimension(70, 70));
            boardPanel.add(cellButton[i]);
            
            cellButton[i].addMouseListener(new MouseListener() {
              
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                   
                    TTTButton button = (TTTButton) mouseEvent.getSource();
                    button.setEnabled(false);
                    //players[0].register(button, button.index);
                    //players[1].register(button, button.index);
                    players[currentPlayer].MarkCell(button.index); 
                    button.setLabel(players[currentPlayer].getSymbol());
                   
                    players[currentPlayer].amIaWinner(button.index);
                    
                     if(players[currentPlayer].amIaWinner(button.index)==true){
                       
                        JOptionPane.showMessageDialog(boardPanel,"Winner is " + players[currentPlayer].getName(),"CONGRATULATIONS", JOptionPane.INFORMATION_MESSAGE);
                      
                      for(int i=0;i<9;i++){
                            cellButton[i].setEnabled(false);
                          
                            }
                    }
                     
                   currentPlayer = currentPlayer == 1 ? 0 : 1;
                     
                    turnLabel.setText("It is " + players[currentPlayer].getName() + "'s Turn");
                  
            }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
    
                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {

                }
            
            });
        } 
       

        // Set top panel
        add(bottomPanel);
        bottomPanel.setPreferredSize(new Dimension(250, 100));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        startButton.setPreferredSize(new Dimension(200, 70));
        startButton.setForeground(Color.blue);
        startButton.setFont(new Font("Serif", Font.BOLD, 18));
        bottomPanel.add(startButton);
        startButton.addMouseListener(new MouseListener() {
            
                    
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
               
                for(int i=0;i<9;i++){
                cellButton[i].setLabel("");
                cellButton[i].setEnabled(true);
                players[0] = new Player("Player 1", "X");
                players[1] = new Player("Player 2", "O");
               players[0].register(cellButton[i], i);
               players[1].register(cellButton[i], i);
               }
             turnLabel.setText("It is "+players[currentPlayer].getName()+"'s turn");
                GameBoard gb=new GameBoard();
                gb.init();
                
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent){
                
            }

            
        });

    }

    
    }

