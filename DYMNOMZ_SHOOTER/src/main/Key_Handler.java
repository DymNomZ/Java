package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key_Handler implements KeyListener{

    public boolean up_pressed, left_pressed, down_pressed, right_pressed;

    @Override
    public void keyTyped(KeyEvent e) {
        //No definition but is needed because of interface
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_W -> up_pressed = true;
            case KeyEvent.VK_A -> left_pressed = true;
            case KeyEvent.VK_S -> down_pressed = true;
            case KeyEvent.VK_D -> right_pressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_W -> up_pressed = false;
            case KeyEvent.VK_A -> left_pressed = false;
            case KeyEvent.VK_S -> down_pressed = false;
            case KeyEvent.VK_D -> right_pressed = false;
        }
    }
}
