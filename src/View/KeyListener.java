package View;

import Controller.GameMaster;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class KeyListener extends JFrame implements java.awt.event.KeyListener {

    public KeyListener() {
        setTitle("Arrow Key Listener Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true); // Make sure the frame can receive key events
        addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                GameMaster.getInstance(null,null).applyAction('U');
                break;
            case KeyEvent.VK_DOWN:
                GameMaster.getInstance(null,null).applyAction('D');
                break;
            case KeyEvent.VK_LEFT:
                GameMaster.getInstance(null,null).applyAction('L');
                break;
            case KeyEvent.VK_RIGHT:
                GameMaster.getInstance(null,null).applyAction('R');
                break;
            case KeyEvent.VK_H:
                GameMaster.getInstance(null,null).applyAction('H');
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // You can handle key release events if needed
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // You can handle key typed events if needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KeyListener example = new KeyListener();
        });
    }
}