package TestTwoDimensionalGraphic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    private Player player;

    public Controller(Player player){
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            player.getModel().addY(player.getSpeed());
        }
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            player.getModel().addY(-player.getSpeed());
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            player.getModel().addX(-player.getSpeed());
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            player.getModel().addX(player.getSpeed());
        }
        Game.window.drawWindow();
    }
}
