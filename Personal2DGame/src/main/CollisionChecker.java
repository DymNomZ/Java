package main;
import entity.Entity;

public class CollisionChecker {
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity){

        int hitBoxLeft = entity.x + entity.hitbox.x;
        int hitBoxRight = entity.x + entity.hitbox.x + entity.hitbox.width;
        int hitBoxTop = entity.y + entity.hitbox.y;
        int hitBoxBottom = entity.y + entity.hitbox.y + entity.hitbox.height;

        int hitBoxLeftCol = hitBoxLeft/gamePanel.tileSize;
        int hitBoxRightCol = hitBoxRight/gamePanel.tileSize;
        int hitBoxTopRow = hitBoxTop/gamePanel.tileSize;
        int hitBoxBottomRow = hitBoxBottom/gamePanel.tileSize;

        int tile_1, tile_2;

        switch(entity.direction){
            case "up" -> {
                hitBoxTopRow = (hitBoxTop - entity.speed) / gamePanel.tileSize;
                tile_1 = gamePanel.tileManager.mapTileNum[hitBoxTopRow][hitBoxLeftCol];
                tile_2 = gamePanel.tileManager.mapTileNum[hitBoxTopRow][hitBoxRightCol];
                if(gamePanel.tileManager.tiles[tile_1].collision == true 
                || gamePanel.tileManager.tiles[tile_2].collision == true){
                    entity.onCollision = true;
                }
            }
            case "left" -> {
                hitBoxLeftCol = (hitBoxLeft - entity.speed) / gamePanel.tileSize;
                tile_1 = gamePanel.tileManager.mapTileNum[hitBoxTopRow][hitBoxLeftCol];
                tile_2 = gamePanel.tileManager.mapTileNum[hitBoxBottomRow][hitBoxLeftCol];
                if(gamePanel.tileManager.tiles[tile_1].collision == true 
                || gamePanel.tileManager.tiles[tile_2].collision == true){
                    entity.onCollision = true;
                }
            }
            case "down" -> {
                hitBoxBottomRow = (hitBoxBottom + entity.speed) / gamePanel.tileSize;
                tile_1 = gamePanel.tileManager.mapTileNum[hitBoxBottomRow][hitBoxLeftCol];
                tile_2 = gamePanel.tileManager.mapTileNum[hitBoxBottomRow][hitBoxRightCol];
                if(gamePanel.tileManager.tiles[tile_1].collision == true 
                || gamePanel.tileManager.tiles[tile_2].collision == true){
                    entity.onCollision = true;
                }
            }
            case "right" -> {
                hitBoxRightCol = (hitBoxRight + entity.speed) / gamePanel.tileSize;
                tile_1 = gamePanel.tileManager.mapTileNum[hitBoxTopRow][hitBoxRightCol];
                tile_2 = gamePanel.tileManager.mapTileNum[hitBoxBottomRow][hitBoxRightCol];
                if(gamePanel.tileManager.tiles[tile_1].collision == true 
                || gamePanel.tileManager.tiles[tile_2].collision == true){
                    entity.onCollision = true;
                }
            }
        }
    }
}
