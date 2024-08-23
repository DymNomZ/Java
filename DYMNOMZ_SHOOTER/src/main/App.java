package main;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Shooter Game Remastered");

        Game_Panel game_panel = new Game_Panel();
        window.add(game_panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        game_panel.start_game_thread();
    }
}
