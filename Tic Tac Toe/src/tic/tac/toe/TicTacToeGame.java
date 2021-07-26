
package tic.tac.toe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToeGame implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel txtAreaPanel = new JPanel();
    JPanel btnPanel = new JPanel();
    JLabel txtArea = new JLabel();
    JButton[] btns = new JButton[9];

    boolean playerOneTurn;

    // constructor
    TicTacToeGame() {

        // creating the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(new Color(30, 61, 89));
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setVisible(true);

        // text fields
        txtArea.setBackground(new Color(255, 110, 64));
        txtArea.setForeground(new Color(245, 240, 225));
        txtArea.setFont(new Font("Poppins", Font.BOLD, 55));
        txtArea.setHorizontalAlignment(JLabel.CENTER);
        txtArea.setText("Tic Tac Toe");
        txtArea.setOpaque(true);

        // text area panel
        txtAreaPanel.setLayout(new BorderLayout());
        txtAreaPanel.setBounds(0, 0, 600, 100);
        txtAreaPanel.setBackground(new Color(255, 110, 64));

        // buttons
        btnPanel.setLayout(new GridLayout(3, 3));
        btnPanel.setBackground(new Color(30, 61, 89));

        for (int i = 0; i < 9; i++) {
            btns[i] = new JButton();
            btns[i].setPreferredSize(new Dimension(20, 20));
            btnPanel.add(btns[i]);
            btns[i].setFont(new Font("MV Boli", Font.BOLD, 80));
            btns[i].setFocusable(false);
            btns[i].addActionListener(this);
        }

        txtAreaPanel.add(txtArea);
        frame.add(txtAreaPanel, BorderLayout.NORTH);
        frame.add(btnPanel);

        firstPlayer();
    }

    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == btns[i]) {
                if (playerOneTurn) {
                    if (btns[i].getText() == "") {
                        btns[i].setForeground(new Color(30, 61, 89));
                        btns[i].setText("X");
                        playerOneTurn = false;
                        txtArea.setText("Player 2 - O");
                        check();
                    }
                } else {
                    if (btns[i].getText() == "") {
                        btns[i].setForeground(new Color(255, 193, 59));
                        btns[i].setText("O");
                        playerOneTurn = true;
                        txtArea.setText("Player 1 - X");
                        check();
                    }
                }
            }
        }

    }

    // first turn
    public void firstPlayer() {

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // create two random number between 0 and 1 to decide player turn
        // player one is 'X' and player two is 'O'
        if (random.nextInt(2) == 0) {
            playerOneTurn = true;
            txtArea.setText("Player 1 - X");

        } else {
            playerOneTurn = false;
            txtArea.setText("Player 2 - O");
        }
    }

    // check winning conditions
    public void check() {

        // check X wins (player one)
        if ((btns[0].getText() == "X") && (btns[1].getText() == "X") && (btns[2].getText() == "X")) {
            playerOneWin(0, 1, 2);
        }
        if ((btns[3].getText() == "X") && (btns[4].getText() == "X") && (btns[5].getText() == "X")) {
            playerOneWin(3, 4, 5);
        }
        if ((btns[6].getText() == "X") && (btns[7].getText() == "X") && (btns[8].getText() == "X")) {
            playerOneWin(6, 7, 8);
        }
        if ((btns[0].getText() == "X") && (btns[3].getText() == "X") && (btns[6].getText() == "X")) {
            playerOneWin(0, 3, 6);
        }
        if ((btns[1].getText() == "X") && (btns[4].getText() == "X") && (btns[7].getText() == "X")) {
            playerOneWin(1, 4, 7);
        }
        if ((btns[2].getText() == "X") && (btns[5].getText() == "X") && (btns[8].getText() == "X")) {
            playerOneWin(2, 5, 8);
        }
        if ((btns[0].getText() == "X") && (btns[4].getText() == "X") && (btns[8].getText() == "X")) {
            playerOneWin(0, 4, 8);
        }
        if ((btns[2].getText() == "X") && (btns[4].getText() == "X") && (btns[6].getText() == "X")) {
            playerOneWin(2, 4, 6);
        }

        // check O wins (player two)
        if ((btns[0].getText() == "O") && (btns[1].getText() == "O") && (btns[2].getText() == "O")) {
            playerTwoWin(0, 1, 2);
        }
        if ((btns[3].getText() == "O") && (btns[4].getText() == "O") && (btns[5].getText() == "O")) {
            playerTwoWin(3, 4, 5);
        }
        if ((btns[6].getText() == "O") && (btns[7].getText() == "O") && (btns[8].getText() == "O")) {
            playerTwoWin(6, 7, 8);
        }
        if ((btns[0].getText() == "O") && (btns[3].getText() == "O") && (btns[6].getText() == "O")) {
            playerTwoWin(0, 3, 6);
        }
        if ((btns[1].getText() == "O") && (btns[4].getText() == "O") && (btns[7].getText() == "O")) {
            playerTwoWin(1, 4, 7);
        }
        if ((btns[2].getText() == "O") && (btns[5].getText() == "O") && (btns[8].getText() == "O")) {
            playerTwoWin(2, 5, 8);
        }
        if ((btns[0].getText() == "O") && (btns[4].getText() == "O") && (btns[8].getText() == "O")) {
            playerTwoWin(0, 4, 8);
        }
        if ((btns[2].getText() == "O") && (btns[4].getText() == "O") && (btns[6].getText() == "O")) {
            playerTwoWin(2, 4, 6);
        }

    }

    // X or player one win
    public void playerOneWin(int a, int b, int c) {
        btns[a].setOpaque(true);
        btns[b].setOpaque(true);
        btns[c].setOpaque(true);
        btns[a].setBackground(new Color(7, 123, 138));
        btns[b].setBackground(new Color(7, 123, 138));
        btns[c].setBackground(new Color(7, 123, 138));

        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }

        txtArea.setText("Player One (X) Won");

    }

    // O or player two win
    public void playerTwoWin(int a, int b, int c) {
        btns[a].setOpaque(true);
        btns[b].setOpaque(true);
        btns[c].setOpaque(true);
        btns[a].setBackground(new Color(27, 101, 53));
        btns[b].setBackground(new Color(7, 123, 138));
        btns[c].setBackground(new Color(7, 123, 138));

        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }

        txtArea.setText("Player Two (O) Won");
    }
}
