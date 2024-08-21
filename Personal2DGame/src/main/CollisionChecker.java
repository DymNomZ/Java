package main;
import entity.Entity;

public class CollisionChecker {
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity){

        int hitBoxLeft = entity.x + entity.hitBox.x;
        int hitBoxRight = entity.x + entity.hitBox.x + entity.hitBox.width;
        int hitBoxTop = entity.y + entity.hitBox.y;
        int hitBoxBottom = entity.y + entity.hitBox.y + entity.hitBox.height;

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

    public int checkObject(Entity entity, boolean isPlayer){
        // any number will do as long as number is not within range of worldObjects array size
        int idx = 999;

        for (int i = 0; i < gamePanel.worldObjects.length; i++) {
            if(gamePanel.worldObjects[i] != null){
                //get entity's hitBox position
                entity.hitBox.x += entity.x;
                entity.hitBox.y += entity.y;
                //get object's hitBox position
                gamePanel.worldObjects[i].hitBox.x += gamePanel.worldObjects[i].x;
                gamePanel.worldObjects[i].hitBox.y += gamePanel.worldObjects[i].y;

                switch(entity.direction){
                    case "up" -> {
                        entity.hitBox.y -= entity.speed;
                        if(entity.hitBox.intersects(gamePanel.worldObjects[i].hitBox)){
                            System.out.println("up collision");
                            if(gamePanel.worldObjects[i].collision) entity.onCollision = true;
                            if(isPlayer) idx = i;
                        }
                    }
                    case "left" -> {
                        entity.hitBox.x -= entity.speed;
                        if(entity.hitBox.intersects(gamePanel.worldObjects[i].hitBox)){
                            System.out.println("left collision");
                            if(gamePanel.worldObjects[i].collision) entity.onCollision = true;
                            if(isPlayer) idx = i;
                        }
                    }
                    case "down" -> {
                        entity.hitBox.y += entity.speed;
                        if(entity.hitBox.intersects(gamePanel.worldObjects[i].hitBox)){
                            System.out.println("down collision");
                            if(gamePanel.worldObjects[i].collision) entity.onCollision = true;
                            if(isPlayer) idx = i;
                        }
                    }
                    case "right" -> {
                        entity.hitBox.x += entity.speed;
                        if(entity.hitBox.intersects(gamePanel.worldObjects[i].hitBox)){
                            System.out.println("right collision");
                            if(gamePanel.worldObjects[i].collision) entity.onCollision = true;
                            if(isPlayer) idx = i;
                        }
                    }
                }
                entity.hitBox.x = entity.hitboxDefX;
                entity.hitBox.y = entity.hitboxDefY;
                gamePanel.worldObjects[i].hitBox.x = gamePanel.worldObjects[i].hitBoxDefX;
                gamePanel.worldObjects[i].hitBox.y = gamePanel.worldObjects[i].hitBoxDefY;
            }
        }

        return idx;
    }
}
