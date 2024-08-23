package d_tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.Game_Panel;

public class Tile_Manager {
    Game_Panel game_panel;
    public D_Tile[] tiles;
    public int map_tile[][];

    public Tile_Manager(Game_Panel gp){
        game_panel = gp;
        tiles = new D_Tile[2];
        map_tile = new int[gp.max_world_row][gp.max_world_row];

        get_tile_image();
        load_tiles();
    }

    public void get_tile_image(){
        try{
            tiles[0] = new D_Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("../../assets/tiles/floor.png"));
            tiles[0].name = "floor";
            tiles[1] = new D_Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("../../assets/tiles/border.png"));
            tiles[1].name = "border";
        }catch (IOException e){
            System.out.println("Wrong tile file path");
            e.printStackTrace();
        }
    }

    public void load_tiles(){
        try {
            
            BufferedReader map_info = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("../../assets/map/world.txt")));
            int col = 0, row = 0;

            while(row < game_panel.max_world_row){
                String strip = map_info.readLine();
                String raw_tile_type[] = strip.split(" ");

                while(col < game_panel.max_world_col){
                    int tile_type = Integer.parseInt(raw_tile_type[col]);
                    map_tile[row][col] = tile_type;
                    col++;
                }

                if(col == game_panel.max_world_col){
                    col = 0;
                    row++;
                }
            }
            map_info.close();

        } catch (Exception e) {
            System.out.println("Wrong Map file destination");
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D G2D){
        int world_col = 0, world_row = 0;

        while(world_row < game_panel.max_world_row){
            int worldX = world_col * game_panel.tile_size;
            int worldY = world_row * game_panel.tile_size;
            int screenX = worldX - game_panel.player.pos_x + game_panel.player.screen_x;
            int screenY = worldY - game_panel.player.pos_y + game_panel.player.screen_y;

            if(worldX + game_panel.tile_size > game_panel.player.pos_x - game_panel.player.screen_x && 
                worldX - game_panel.tile_size < game_panel.player.pos_x + game_panel.player.screen_x && 
                worldY + game_panel.tile_size > game_panel.player.pos_y - game_panel.player.screen_y && 
                worldY - game_panel.tile_size < game_panel.player.pos_y + game_panel.player.screen_y){
                   G2D.drawImage(tiles[map_tile[world_row][world_col]].image, screenX, screenY, game_panel.tile_size,game_panel.tile_size, null); 
                }
            
            world_col++;
            
            if(world_col == game_panel.max_world_col){
                world_col = 0;
                world_row++;
            }
        }
    }

}
