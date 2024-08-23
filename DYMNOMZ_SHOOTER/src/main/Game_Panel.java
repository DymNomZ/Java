package main;

import d_tile.Tile_Manager;
import entity.DYM_Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Game_Panel extends JPanel implements Runnable{

    //WINODW AND TILE SETTINGS
    final public int tile_size = 48;
    final int max_screen_column = 25;
    final int max_screen_row = 16;
    final public int screen_width = tile_size * max_screen_column;
    final public int screen_height = tile_size * max_screen_row;

    //WORLD VALUES
    public final int max_world_col = 50;
    public final int max_world_row = 50;
    public final int world_width = tile_size * max_world_col;
    public final int world_height = tile_size * max_world_row;

    //GAMEPANEL VARIABLES
    Thread game_thread;
    int FPS = 60;

    //GAME SYSTEM
    Tile_Manager TM = new Tile_Manager(this);
    Key_Handler KH = new Key_Handler();
    public Collision_Handler CH = new Collision_Handler(this);
    public DYM_Player player = new DYM_Player(this, KH);

    public Game_Panel(){
        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(KH);
    }

    public void start_game_thread(){
        game_thread = new Thread(this);
        game_thread.start();
    }

    //GAME CLOCK
    @Override
    public void run(){
        double drawInterval = 1000000000/FPS, delta = 0;
        long lastTime = System.nanoTime(), currentTime;
        long timer = 0;
        int drawCount = 0;

        while(game_thread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                player.update_player_pos();
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

    //PAINTER
    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D G2D = (Graphics2D)graphics;

        TM.draw(G2D);


        /*for(int i = 0; i < worldObjects.length; i++){
            if(worldObjects[i] != null) worldObjects[i].draw(graphics2D, this);
        }*/

        player.draw(G2D);
        //UI.draw(graphics2D);

        G2D.dispose();
    }

}
