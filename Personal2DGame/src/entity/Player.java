package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler){
        
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth/2 - (gamePanel.tileSize/2);
        screenY = gamePanel.screenHeight/2 - (gamePanel.tileSize/2);

        //adjust as needed
        // width and height rely on tile size (meaning scale has already been applied)
        // make sure to update values when changing scale value
        hitbox = new Rectangle(8, 16, 32, 32);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = gamePanel.tileSize * 23;
        y = gamePanel.tileSize * 23;
        speed = 4;
        direction = "down";
    }
    // /res/player/peep
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("../../res/player/peep_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("../../res/player/peep_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("../../res/player/peep_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("../../res/player/peep_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("../../res/player/peep_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("../../res/player/peep_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("../../res/player/peep_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("../../res/player/peep_right_2.png"));
        }catch(IOException e){
            System.out.println("wrong path");
            e.printStackTrace();
        }
    }

    public void updatePlayerPos(){
        //Could separate elses in different ifs
        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            if(keyHandler.upPressed){ direction = "up";
            }else if(keyHandler.leftPressed){ direction = "left";
            }else if(keyHandler.downPressed){ direction = "down";
            }else if(keyHandler.rightPressed){ direction = "right";
            }

            onCollision = false;
            gamePanel.collisionChecker.checkTile(this);

            if(!onCollision){
                switch(direction){
                    case "up" -> y -= speed;
                    case "left" -> x -= speed;
                    case "down" -> y += speed;
                    case "right" -> x += speed;
                }
            }
    
            spriteCounter++;
            if(spriteCounter > 13){
                if(spriteNum == 1) spriteNum = 2;
                else spriteNum = 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics graphics2D){
        //background of tile
        //graphics2D.setColor(Color.white);
        //graphics2D.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);

        BufferedImage image = null;

        switch(direction){
            case "up" -> {
                if(spriteNum == 1) image = up1;
                else image = up2;
            }
            case "left" -> {
                if(spriteNum == 1) image = left1;
                else image = left2;
            }
            case "right" -> {
                if(spriteNum == 1) image = right1;
                else image = right2;
            }
            case "down" -> {
                if(spriteNum == 1) image = down1;
                else image = down2;
            }
        }

        graphics2D.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        graphics2D.fillRect(screenX + hitbox.x, screenY + hitbox.y, hitbox.width, hitbox.height); 
    }
}
