/*hjhbj
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package mine3;

import Controller.GameMaster;
import Model.Grid;
import View.GUI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Ali-Almski
 */
public class Stacked {

    static int w = 0, h = 0, uniqueColorsCount = 0;

    static void play() {


        // E for not the playable square
        // N for the playable square
        // the others are the first char of the color

        char[][] squareType = {
                {'B', 'N', 'B', 'E'},
                {'E', 'N', 'E', 'E'},
                {'P', 'O', 'O', 'O'},
                {'P', 'E', 'E', 'B'},
                {'P', 'B', 'N', 'E'},
        };
        w = squareType[0].length;
        h = squareType.length;

        Grid grid = new Grid(w, h, squareType);
        GUI gui = new GUI(w, h, null);
        GameMaster gameMaster = GameMaster.getInstance(grid, gui);
        gui.setGameMaster(gameMaster);
        gui.showgrid(grid);
        System.out.println(Arrays.deepToString(grid.getInitialSquareType()));

    }

    public static void main(String[] args) {
        play();

    }


}
