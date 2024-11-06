/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

public class Square implements Serializable{

    public SquareType type;

    public Square(SquareType type) {
        this.type = type;
    }

    public SquareType getType() {
        return type;
    }

    public void setType(SquareType type) {
        this.type = type;
    }

    void reset() {
//        isFlag = false;
//        isMine = false;
//        isOpen = false;
//        minesNearBy = 0;
//        isOpen2=false ;
//        isFlag2=false;
//          numperofplayer =0;
    }

}
