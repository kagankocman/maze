package app;

import javax.swing.*;

public class Button extends JButton {

    private int koordinatX;
    private int koordinatY;
    public Button(int row, int col){
        this.koordinatX = row;
        this.koordinatY = col;
    }
    public int getKoordinatX() {
        return koordinatX;
    }
    public int getKoordinatY() {
        return koordinatY;
    }

}
