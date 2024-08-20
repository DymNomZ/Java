package main;

import object.DoorOBJ;
import object.ShamrockOBJ;

public class AssetSetter {

    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void setObjects(){

        gamePanel.worldObjects[0] = new ShamrockOBJ();
        gamePanel.worldObjects[0].x = 21 * gamePanel.tileSize;
        gamePanel.worldObjects[0].y = 2 * gamePanel.tileSize;

        gamePanel.worldObjects[1] = new ShamrockOBJ();
        gamePanel.worldObjects[1].x = 23 * gamePanel.tileSize;
        gamePanel.worldObjects[1].y = 2 * gamePanel.tileSize;
        
        gamePanel.worldObjects[2] = new ShamrockOBJ();
        gamePanel.worldObjects[2].x = 25 * gamePanel.tileSize;
        gamePanel.worldObjects[2].y = 2 * gamePanel.tileSize;

        gamePanel.worldObjects[3] = new ShamrockOBJ();
        gamePanel.worldObjects[3].x = 27 * gamePanel.tileSize;
        gamePanel.worldObjects[3].y = 2 * gamePanel.tileSize;

        gamePanel.worldObjects[4] = new ShamrockOBJ();
        gamePanel.worldObjects[4].x = 29 * gamePanel.tileSize;
        gamePanel.worldObjects[4].y = 2 * gamePanel.tileSize;

        gamePanel.worldObjects[5] = new DoorOBJ();
        gamePanel.worldObjects[5].x = 21 * gamePanel.tileSize;
        gamePanel.worldObjects[5].y = 13 * gamePanel.tileSize;

        gamePanel.worldObjects[6] = new DoorOBJ();
        gamePanel.worldObjects[6].x = 23 * gamePanel.tileSize;
        gamePanel.worldObjects[6].y = 13 * gamePanel.tileSize;

        gamePanel.worldObjects[7] = new DoorOBJ();
        gamePanel.worldObjects[7].x = 25 * gamePanel.tileSize;
        gamePanel.worldObjects[7].y = 13 * gamePanel.tileSize;

        gamePanel.worldObjects[8] = new DoorOBJ();
        gamePanel.worldObjects[8].x = 31 * gamePanel.tileSize;
        gamePanel.worldObjects[8].y = 13 * gamePanel.tileSize;
    }
}
