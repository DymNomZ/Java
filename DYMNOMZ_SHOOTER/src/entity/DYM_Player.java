package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Game_Panel;
import main.Key_Handler;

public class DYM_Player extends DYM_Entity{

    Game_Panel gp;
    Key_Handler kh;

    public final int screen_x;
    public final int screen_y;

    public DYM_Player(Game_Panel gp, Key_Handler kh){
        this.gp = gp;
        this.kh = kh;
        screen_x =  gp.screen_width/2 - (gp.tile_size/2);
        screen_y = gp.screen_height/2 - (gp.tile_size/2);

        hitbox = new Rectangle(8, 16, 32, 32);
        hitbox_default_x = hitbox.x;
        hitbox_default_y = hitbox.y;

        set_default_values();
        get_player_sprite();
    }

    public void set_default_values(){
        pos_x = gp.tile_size * 23;
        pos_y = gp.tile_size * 23;
        speed = 4;
        direction = "down";
    }

    public void get_player_sprite(){
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../../assets/entity/player.png"));
        } catch (IOException e) {
            System.out.println("Wrong player sprite path");
            e.printStackTrace();
        }
    }

    public void update_player_pos(){
        //Could separate elses in different ifs
        if (kh.up_pressed || kh.down_pressed || kh.left_pressed || kh.right_pressed) {
            if(kh.up_pressed){ direction = "up";
            }else if(kh.left_pressed){ direction = "left";
            }else if(kh.down_pressed){ direction = "down";
            }else if(kh.right_pressed){ direction = "right";
            }

            is_colliding = false;
            //gp.collisionChecker.checkTile(this);

            //int objectIdx = gamePanel.collisionChecker.checkObject(this, true);
            //pickUpObj(objectIdx);

            if(!is_colliding){
                switch(direction){
                    case "up" -> pos_y -= speed;
                    case "left" -> pos_x -= speed;
                    case "down" -> pos_y += speed;
                    case "right" -> pos_x += speed;
                }
            }
        }
    }

    public void draw(Graphics2D G2D){

        G2D.drawImage(image, screen_x, screen_y, gp.tile_size, gp.tile_size, null);
        G2D.setColor(Color.white);
        G2D.drawRect(screen_x + hitbox.x, screen_y + hitbox.y, hitbox.width, hitbox.height);
    }
}
