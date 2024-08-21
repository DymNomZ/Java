package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

    GamePanel gamePanel;
    Font arial_40;
    public boolean displayMessage = false;
    public String message = "sample text";
    int messageDisplayTimer = 0;
    public boolean isGameComplete = false;

    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
    }

    public void showMessage(String message){
        this.message = message;
        displayMessage = true;
    }

    public void draw(Graphics2D graphics2D){

        if(isGameComplete){
            gamePanel.BGM.stopSound();
            gamePanel.gameThread = null;
        }

        graphics2D.setFont(arial_40);
        graphics2D.setColor(Color.white);
        //drawString() works different than normal drawing as the Y value bases on the text's baseline
        //So adjust accordingly
        graphics2D.drawString("Key = " + gamePanel.player.keyAmnt, 25, 100);

        if(displayMessage){
            //this shows that graphics2d only has one color per draw, have yet to discover more about the class. Tnx to flutter for the familiarity of the concept
            graphics2D.setColor(Color.black);
            graphics2D.fillRect(25, 500, 500, 250); 
            graphics2D.setColor(Color.white);
            graphics2D.drawString(message, 100, 600);

            messageDisplayTimer++;

            if(messageDisplayTimer > 120){ //120 for 2 seconds, this is based on the FPS set 
                messageDisplayTimer = 0;
                displayMessage = false;
            }
        }
    }
}
