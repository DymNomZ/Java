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
        mapTileNum = new int[gamePanel.maxScreenRow][gamePanel.maxScreenCol];

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

            while(row < gamePanel.maxScreenRow){
                String strip = bufferedReader.readLine();
                String rawTileType[] = strip.split(" ");

                while(col < gamePanel.maxScreenCol){
                    int tileType = Integer.parseInt(rawTileType[col]);
                    mapTileNum[row][col] = tileType;
                    col++;
                }

                if(col == gamePanel.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            bufferedReader.close();

        } catch (Exception e) {

        }
    }

    public void draw(Graphics graphics2D){
        int col = 0, row = 0, x = 0, y = 0;

        while(row < gamePanel.maxScreenRow){
            graphics2D.drawImage(tiles[mapTileNum[row][col]].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
            col++;
            x += gamePanel.tileSize;

            if(col == gamePanel.maxScreenCol){
                col = 0;
                x = 0;
                y += gamePanel.tileSize;
                row++;
            }
        }
    }
}
