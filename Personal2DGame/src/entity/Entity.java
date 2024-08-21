package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int x, y, speed, spriteCounter = 0, spriteNum = 1;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public Rectangle hitBox;
    public int hitboxDefX, hitboxDefY;
    public boolean onCollision = false;
    
}
