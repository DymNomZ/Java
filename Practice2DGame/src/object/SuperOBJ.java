package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;

public class SuperOBJ {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int x, y;
    //Adjust each object's hitbox manually in respective class if want
    public Rectangle hitBox = new Rectangle(0, 0, 48, 48);
    public int hitBoxDefX = 0;
    public int hitBoxDefY = 0;

    public void draw(Graphics graphics2D, GamePanel gamePanel){
        int screenX = x - gamePanel.player.x + gamePanel.player.screenX;
        int screenY = y - gamePanel.player.y + gamePanel.player.screenY;

        if(x + gamePanel.tileSize > gamePanel.player.x - gamePanel.player.screenX && 
            x - gamePanel.tileSize < gamePanel.player.x + gamePanel.player.screenX && 
            y + gamePanel.tileSize > gamePanel.player.y - gamePanel.player.screenY && 
            y - gamePanel.tileSize < gamePanel.player.y + gamePanel.player.screenY){
            graphics2D.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null); 
        }
    }
}
