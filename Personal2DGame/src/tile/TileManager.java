package tile;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tiles;
    int mapTileNum[][];

    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tiles = new Tile[10];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadTiles("../../res/maps/map01.txt");
    }

    public void getTileImage(){
        try {
            
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("../../res/tiles/grass.png"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("../../res/tiles/brick.png"));
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("../../res/tiles/water.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTiles(String mapFilePath){
        try {
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(mapFilePath)));
            int col = 0, row = 0;

            while(row < gamePanel.maxWorldRow){
                String strip = bufferedReader.readLine();
                String rawTileType[] = strip.split(" ");

                while(col < gamePanel.maxWorldCol){
                    int tileType = Integer.parseInt(rawTileType[col]);
                    mapTileNum[row][col] = tileType;
                    col++;
                }

                if(col == gamePanel.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            bufferedReader.close();

        } catch (Exception e) {

        }
    }

    public void draw(Graphics graphics2D){
        int worldCol = 0, worldRow = 0;

        while(worldRow < gamePanel.maxWorldRow){
            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.x + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.y + gamePanel.player.screenY;

            if(worldX + gamePanel.tileSize > gamePanel.player.x - gamePanel.player.screenX && 
                worldX - gamePanel.tileSize < gamePanel.player.x + gamePanel.player.screenX && 
                worldY + gamePanel.tileSize > gamePanel.player.y - gamePanel.player.screenY && 
                worldY - gamePanel.tileSize < gamePanel.player.y + gamePanel.player.screenY){
                   graphics2D.drawImage(tiles[mapTileNum[worldRow][worldCol]].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null); 
                }
            
            worldCol++;
            
            if(worldCol == gamePanel.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
