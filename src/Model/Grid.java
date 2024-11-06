/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.GameMaster;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Grid implements Serializable {


    public int uniqueColorsCount;
    public Square[][] squares;
    char[][] initialSquareType;
    public int w;
    public int h;

    public Grid(int w, int h, char[][] squareType) {
        this.w = w;
        this.h = h;
        this.squares = new Square[w][h];
        this.initialSquareType = squareType;
        this.fillGrid(squareType);
        this.uniqueColorsCount = this.countUniqueTypes();

    }

    public boolean areEquals(Grid otherGrid) {
        if (this.w != otherGrid.w || this.h != otherGrid.h) {
            return false;
        }

        for (int i = 0; i < this.w; i++) {
            for (int j = 0; j < this.h; j++) {
                if (this.squares[i][j].getType() != otherGrid.squares[i][j].getType()) {
                    return false;
                }
            }
        }

        return true;
    }
    public char[][] getInitialSquareType() {
        return initialSquareType;
    }

    public void reset() {
        GameMaster.gameEnded = false;
        fillGrid(this.initialSquareType);

    }



    void fillGrid(char[][] squareType) {

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {

                squares[i][j] = new Square(this.match(squareType[j][i]));

            }
        }
    }
    public int countUniqueTypes() {
        Set<SquareType> uniqueTypes = new HashSet<>();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                if (squares[i][j].type != SquareType.EMPTY && squares[i][j].type != SquareType.NOTHING) {
                    uniqueTypes.add(squares[i][j].type);
                }
            }
        }

        return uniqueTypes.size();
    }
    public int countTypes() {
        LinkedList<SquareType> types = new LinkedList<>();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                if (squares[i][j].type != SquareType.EMPTY && squares[i][j].type != SquareType.NOTHING) {
                    types.add(squares[i][j].type);
                }
            }
        }

        return types.size();
    }

    private SquareType match(char c) {
        return switch (c) {
            case 'E' -> SquareType.EMPTY;
            case 'N' -> SquareType.NOTHING;
            case 'B' -> SquareType.BLUE;
            case 'O' -> SquareType.ORANGE;
            case 'P' -> SquareType.PURPLE;
            default -> throw new IllegalStateException();
        };

    }
}
