package TestTwoDimensionalGraphic;

import TestTwoDimensionalGraphic.Animations.Animator;

import java.awt.*;

public class Game {

    public static Player player = new Player();
    public static Window window;
    public static int width = 720;
    public static int height = 480;
    public static ThatHowGravityWorks gravity;

    public static void main(String[] args){
        new Animator();
        Animator.addAnimation(() -> {
            player.getModel().setColor(new Color[]{Color.red, Color.cyan, Color.magenta, Color.ORANGE}[(int)(Math.random()*4)]);
        });
        window = new Window(player);
        gravity = new ThatHowGravityWorks();
        gravity.addCreature(player);
        gravity.start();
        new Camera();
    }
}
