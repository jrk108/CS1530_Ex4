import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
  JButton[] _buttons = new JButton[9];
  JButton game;

  TicTacToe(){

    JFrame _frame = new JFrame("Tic-Tac-Toe");
    _frame.setVisible(true);
    _frame.setSize(400, 400);
    _frame.setVisible(true);
    _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel _ttt = new JPanel();
    JPanel _newPanel = new JPanel();
    _ttt.setLayout(new GridLayout(3, 3));
	  _newPanel.setLayout(new FlowLayout());
    // This will place the tic-tac-toe panel at the top of
	  // the frame and the newPanel panel at the bottom
	  _frame.add(_ttt, BorderLayout.NORTH);
	  _frame.add(_newPanel, BorderLayout.SOUTH);


    class GameListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {

          for (int j=0; j<9; j++) {
              _buttons[j].setText("_");
          }
      }
    }

    game = new JButton("new game");
    ActionListener buttonListener1 = new GameListener();
    game.addActionListener(buttonListener1);
    _newPanel.add(game);


    for (int j=0; j<9; j++) {
	    // Make a new button in the array location with text "_"
	    _buttons[j] = new JButton("_");
	    // Associate a new ButtonListener to the button (see below)
	    ActionListener buttonListener = new ButtonListener();
	    _buttons[j].addActionListener(buttonListener);
	    // Set the font on the button
	    _buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
	    // Add this button to the _ttt panel
	    _ttt.add(_buttons[j]);
	   }

   }

   boolean turn = true;
   class ButtonListener implements ActionListener {

   // Every time we click the button, it will perform
   // the following action.

     public void actionPerformed(ActionEvent e) {

         JButton source = (JButton) e.getSource();
         String currentText = source.getText();
         if (currentText.equals("_")) {
            if (turn == true){
              source.setText("X");
              turn = false;
            }
            else if (turn == false){
              source.setText("O");
              turn = true;
            }
         }
         else {

         }

      /*   if (currentText.equals("new game")) {
            for (int j=0; j<9; j++) {
                _buttons[j].setText("_");
            }
         }*/
     }
   }  // end ActionListener

    public static void main(String[] args) {
      new TicTacToe();



    } // end main

}
