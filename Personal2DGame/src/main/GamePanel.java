package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import object.SuperOBJ;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

    //TILE AND WINDOW SETTINGS
    final int origTileSize = 16;
    final int scale = 3;
    public final int tileSize = origTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol; //unused, pre-camera
    public final int worldHeight = tileSize * maxWorldRow; //unused, pre-camera

    //GAME SYSTEM
    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Sound BGM = new Sound();
    Sound SoundEffect = new Sound();
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    Thread gameThread;

    //ENTITIES AND OBJECTS
    public Player player = new Player(this, keyHandler);
    public SuperOBJ worldObjects[] = new SuperOBJ[10];
    public SuperOBJ playerINV[] = new SuperOBJ[10];

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setupGame(){
        assetSetter.setObjects();

        playMusic(0);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval = 1000000000/FPS, delta = 0;
        long lastTime = System.nanoTime(), currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        
        player.updatePlayerPos();
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics graphics2D = (Graphics2D)graphics;

        tileManager.draw(graphics2D);

        for(int i = 0; i < worldObjects.length; i++){
            if(worldObjects[i] != null) worldObjects[i].draw(graphics2D, this);
        }

        player.draw(graphics2D);
        graphics2D.dispose();
    }

    public void playMusic(int i){
        BGM.setSound(i);
        BGM.playSound();
        BGM.loopSound();
    }

    public void stopMusic(){
        BGM.stopSound();
    }

    public void playSoundEffect(int i){
        SoundEffect.setSound(i);
        SoundEffect.playSound();
    }
}
