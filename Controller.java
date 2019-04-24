package TestTwoDimensionalGraphic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class Controller extends KeyAdapter {

    private Player player;
    private Thread playerControllerThread;

    public Controller(Player player){
        this.player = player;
        playerControllerThread = new Thread(() -> {
            while (true){
                if(player.isBottomDirection()){
                    player.getModel().addY(1);
                }
                if(player.isLeftDirection()){
                    player.getModel().addX(-1);
                }
                if(player.isRightDirection()){
                    player.getModel().addX(1);
                }
                try {
                    playerControllerThread.sleep(Math.max(2, 10000/player.speed));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        player.setControllerThread(playerControllerThread);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(KeyEvent.VK_DOWN == e.getKeyCode() || KeyEvent.VK_S == e.getKeyCode()){
            player.setBottomDirection(true);
        }
        if(!player.isOnAir() && (KeyEvent.VK_UP == e.getKeyCode() || KeyEvent.VK_W == e.getKeyCode())){
            player.jump();
        }
        if(KeyEvent.VK_LEFT == e.getKeyCode() || KeyEvent.VK_A == e.getKeyCode()){
            player.setLeftDirection(true);
        }
        if(KeyEvent.VK_RIGHT == e.getKeyCode() || KeyEvent.VK_D == e.getKeyCode()){
            player.setRightDirection(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(KeyEvent.VK_DOWN == e.getKeyCode() || KeyEvent.VK_S == e.getKeyCode()){
            player.setBottomDirection(false);
        }
        if(!player.isOnAir() && (KeyEvent.VK_UP == e.getKeyCode() || KeyEvent.VK_W == e.getKeyCode())){
            player.setTopDirection(false);
        }
        if(KeyEvent.VK_LEFT == e.getKeyCode() || KeyEvent.VK_A == e.getKeyCode()){
            player.setLeftDirection(false);
        }
        if(KeyEvent.VK_RIGHT == e.getKeyCode() || KeyEvent.VK_D == e.getKeyCode()){
            player.setRightDirection(false);
        }
    }
}
