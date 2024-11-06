
package Controller;

import Model.Grid;

import Model.SquareType;
import View.GUI;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class GameMaster{


    private static GameMaster instance;
    public static boolean gameEnded;

    public Grid grid;
    GUI gui;

    private  GameMaster(Grid grid, GUI gui) {
        this.grid = grid;
        this.gui = gui;
    }

    public static GameMaster getInstance(Grid grid, GUI gui) {
        if (instance == null) {
            instance = new GameMaster(grid, gui);
        }
        return instance;
    }



    public void onSequerClicked(int x, int y, boolean isLeft) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (gameEnded) {
            return;
        }
            gui.refreshGUI(this.grid, false);

    }

       public void applyAction(char x) {
//        change the model based on the clicked sequer;
        int h = grid.squares[0].length , w =  grid.squares.length ;
            switch (x)
            {
                case 'U' :
                this.UpArrowMovement(w,h);
                break;
                case 'D' :
                    this.DownArrowMovement(w,h);
                    break;
                case 'L' :
                    this.LeftArrowMovement(w,h);
                    break;
                case 'R' :
                    this.RightArrowMovement(w,h);
                    break;
                case 'H' :
                    this.ResetMovement();
                    break;
            }
            gui.refreshGUI(grid,false);
            this.checkIfGameEnded();
        }

    private void ResetMovement() {
        grid.reset();
    }

    void UpArrowMovement(int w, int h) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (grid.squares[i][j].type != SquareType.NOTHING &&
                        grid.squares[i][j].type != SquareType.EMPTY) {
                    int k = j;
                    SquareType squareType = grid.squares[i][j].type;
                    while (k > 0) {
                        if (grid.squares[i][k - 1].type == SquareType.NOTHING) {
                            grid.squares[i][k - 1].type = squareType;
                            grid.squares[i][k].type = SquareType.NOTHING;
                            k--;
                        } else if (grid.squares[i][k - 1].type == squareType) {
                            grid.squares[i][k - 1].type = SquareType.NOTHING;
                            grid.squares[i][k].type = squareType;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }


    void DownArrowMovement(int w, int h) {
        for (int i = 0; i < w; i++) {
            for (int j = h - 1; j >= 0; j--) {
                if (grid.squares[i][j].type != SquareType.NOTHING &&
                        grid.squares[i][j].type != SquareType.EMPTY) {
                    int k = j;
                    SquareType squareType = grid.squares[i][j].type;
                    while (k < h - 1) {
                        if (grid.squares[i][k + 1].type == SquareType.NOTHING) {
                            grid.squares[i][k + 1].type = squareType;
                            grid.squares[i][k].type = SquareType.NOTHING;
                            k++;
                        } else if (grid.squares[i][k + 1].type == squareType) {
                            grid.squares[i][k + 1].type = SquareType.NOTHING;
                            grid.squares[i][k].type = squareType;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }



    void LeftArrowMovement(int w, int h) {
        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {
                if (grid.squares[i][j].type != SquareType.NOTHING &&
                        grid.squares[i][j].type != SquareType.EMPTY) {
                    int k = i;
                    SquareType squareType = grid.squares[i][j].type;
                    while (k > 0) { // Move left
                        if (grid.squares[k - 1][j].type == SquareType.NOTHING) {
                            grid.squares[k - 1][j].type = squareType;
                            grid.squares[k][j].type = SquareType.NOTHING;
                            k--;
                        } else if(grid.squares[k - 1][j].type ==  grid.squares[k][j].type) {
                            grid.squares[k][j].type = SquareType.NOTHING;

                        }else
                            break;
                        }
                    }

            }
        }
    }

    void RightArrowMovement(int w, int h) {
        for (int j = 0; j < h; j++) { // Iterate through each row
            for (int i = w - 1; i >= 0; i--) { // Iterate through each column from right to left
                if (grid.squares[i][j].type != SquareType.NOTHING &&
                        grid.squares[i][j].type != SquareType.EMPTY) {
                    int k = i;
                    SquareType squareType = grid.squares[i][j].type;
                    while (k < w - 1) { // Move right
                        if (grid.squares[k + 1][j].type == SquareType.NOTHING) {
                            grid.squares[k + 1][j].type = squareType;
                            grid.squares[k][j].type = SquareType.NOTHING;
                            k++;
                        } else if (grid.squares[k + 1][j].type == squareType) {
                            grid.squares[k + 1][j].type = SquareType.NOTHING;
                            grid.squares[k][j].type = squareType;

                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }


    private void checkIfGameEnded() {
        if (grid.uniqueColorsCount==grid.countTypes())
        {
            JFrame fr = new JFrame(" Congratulation ");
            fr.setSize(300, 340);
            fr.setLayout(null);
            fr.setLocationRelativeTo(null);
            fr.setVisible(true);
            fr.setResizable(false);
        }
    }
}


