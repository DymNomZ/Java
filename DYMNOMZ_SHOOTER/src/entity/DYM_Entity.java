package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class DYM_Entity {
    public BufferedImage image;
    public String direction;
    public int pos_x, pos_y, speed;
    public Rectangle hitbox;
    public int hitbox_default_x, hitbox_default_y;
    public boolean is_colliding = false;
}
