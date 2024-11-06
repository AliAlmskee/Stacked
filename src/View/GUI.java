package View;

import Controller.GameMaster;

import Model.Grid;
import Model.Square;
import Model.SquareType;
import javax.swing.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GUI extends JFrame {

    public JFrame frame = new JFrame(" Basket Ball");
    public JButton[][] buttonsGrid;
    int w, h;
    GameMaster gameMaster;

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public GUI(int w, int h, GameMaster gameMaster) {
        this.gameMaster = gameMaster;
        this.buttonsGrid = new JButton[w][h];
        this.w = w;
        this.h = h;
        frame.setFocusable(true);
        frame.addKeyListener(new View.KeyListener());
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                this.buttonsGrid[i][j] = new JButton();
            }
        }
    }

    public void setGameMaster(GameMaster gm) {
        this.gameMaster = gm;
    }

//    نحنا عم نخبر الكونترولر انو اليوزر اتفاعل مع الواجهة وكبس زر
    void onMouseClick(int x, int y, boolean isLeft) {
        try {
            this.gameMaster.onSequerClicked(x, y, isLeft);
        } catch (UnsupportedAudioFileException |LineUnavailableException |IOException ex) {
    }
     }
    public void setIconToButton(Square sq, JButton button, boolean gameended) {
        Icon numbericon = null;
        if(sq.type== SquareType.NOTHING)
        {
            ImageIcon img = new ImageIcon("Nothing.jpg");
            button.setIcon(img);

        }
        else if(sq.type== SquareType.BLUE)
            {
                ImageIcon img = new ImageIcon("blue.jpg");
                button.setIcon(img);

            }
        else if(sq.type== SquareType.PURPLE)
        {
            ImageIcon img = new ImageIcon("purple.jpg");
            button.setIcon(img);

        }
        else if(sq.type== SquareType.WHITE)
        {
            ImageIcon img = new ImageIcon("white.jpg");
            button.setIcon(img);

        }
        else if(sq.type== SquareType.ORANGE)
        {
            ImageIcon img = new ImageIcon("Orange.jpg");
            button.setIcon(img);

        }
        else if(sq.type== SquareType.EMPTY)
        {
            ImageIcon img = new ImageIcon("Empty.jpg");
            button.setIcon(img);

        }
        if (gameended) {

        }
    }

//    الكونترولر رح يخبرني عن طريق هي الميثود انو الموديل اتحدث وانا لازم حدث الواجهة
            public void refreshGUI (Grid grid,boolean gameended){

                for (int i = 0; i < this.w; i++) {
                    for (int j = 0; j < this.h; j++) {
                        Square sq = grid.squares[i][j];
                        setIconToButton(sq, this.buttonsGrid[i][j], gameended);

                    }
                }

                if (gameended) {
                    GameMaster.gameEnded = true;
                }
            }


            public void showgrid (Grid grid){
                final int EADG_SIZEX = 18;
                final int EADG_SIZEY = 40;
                final int SQ_SIZE = 60;
                // عدل الثوابت لمتغيرات نهائية
                frame.setSize(grid.w * SQ_SIZE + EADG_SIZEX, grid.h*SQ_SIZE + EADG_SIZEY);

                for (int i = 0; i < grid.w; i++) {
                    for (int j = 0; j < grid.h; j++) {

                        buttonsGrid[i][j].setBounds(i * SQ_SIZE, j * SQ_SIZE , SQ_SIZE, SQ_SIZE);
                        Square sq = grid.squares[i][j];
                        setIconToButton(sq, buttonsGrid[i][j], false);
                        frame.add(buttonsGrid[i][j]);

                    }
                }

                ImageIcon img = new ImageIcon("mainIcon.png");
                frame.setIconImage(img.getImage());
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setLayout(null);
                // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //frame.setResizable(false);
                frame.setVisible(true);

            }







}



