package main;

import entity.DYM_Entity;

public class Collision_Handler {

    Game_Panel gp;

    public Collision_Handler(Game_Panel gp){
        this.gp = gp;
    }

    public void check_tile(DYM_Entity entity){

        int hitbox_left = entity.pos_x + entity.hitbox.x;
        int hitbox_right = entity.pos_x + entity.hitbox.x + entity.hitbox.width;
        int hitbox_top = entity.pos_y + entity.hitbox.y;
        int hitbox_bottom = entity.pos_y + entity.hitbox.y + entity.hitbox.height;

        int hitbox_left_col = hitbox_left/gp.tile_size;
        int hitbox_right_col = hitbox_right/gp.tile_size;
        int hitbox_top_row = hitbox_top/gp.tile_size;
        int hitbox_bottom_row = hitbox_bottom/gp.tile_size;

        int tile_1, tile_2;

        switch(entity.direction){
            case "up" -> {
                hitbox_top_row = (hitbox_top - entity.speed) / gp.tile_size;
                tile_1 = gp.TM.map_tile[hitbox_top_row][hitbox_left_col];
                tile_2 = gp.TM.map_tile[hitbox_top_row][hitbox_right_col];
                if(gp.TM.tiles[tile_1].name == "border" || gp.TM.tiles[tile_2].name == "border"){
                    entity.is_colliding = true;
                }
            }
            case "left" -> {
                hitbox_left_col = (hitbox_left - entity.speed) / gp.tile_size;
                tile_1 = gp.TM.map_tile[hitbox_top_row][hitbox_left_col];
                tile_2 = gp.TM.map_tile[hitbox_bottom_row][hitbox_left_col];
                if(gp.TM.tiles[tile_1].name == "border" || gp.TM.tiles[tile_2].name == "border"){
                    entity.is_colliding = true;
                }
            }
            case "down" -> {
                hitbox_bottom_row = (hitbox_bottom + entity.speed) / gp.tile_size;
                tile_1 = gp.TM.map_tile[hitbox_bottom_row][hitbox_left_col];
                tile_2 = gp.TM.map_tile[hitbox_bottom_row][hitbox_right_col];
                if(gp.TM.tiles[tile_1].name == "border" || gp.TM.tiles[tile_2].name == "border"){
                    entity.is_colliding = true;
                }
            }
            case "right" -> {
                hitbox_right_col = (hitbox_right + entity.speed) / gp.tile_size;
                tile_1 = gp.TM.map_tile[hitbox_top_row][hitbox_right_col];
                tile_2 = gp.TM.map_tile[hitbox_bottom_row][hitbox_right_col];
                if(gp.TM.tiles[tile_1].name == "border" || gp.TM.tiles[tile_2].name == "border"){
                    entity.is_colliding = true;
                }
            }
        }
    }
}
