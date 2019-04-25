package TestTwoDimensionalGraphic;

import TestTwoDimensionalGraphic.Animations.AnimationMoveToRegardingTheObject;
import TestTwoDimensionalGraphic.Animations.AnimationMoveToRegardingTheWorld;
import TestTwoDimensionalGraphic.Animations.Animator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel {

    private List<Model> shapes = new ArrayList<>();
    public static ArrayList<Creature> creatures = new ArrayList<>();
    public static int startX = 0;
    public static int startY = 0;

    public MainPanel() {
        setBackground(Color.BLACK);
        addCreature(Game.player);
        addCreature(new Platform(0, Game.height-80, 1440, 50));
        addCreature(new Platform(-50, 0, 50, 480));
        addCreature(new Platform(300,300,100,200));
        Platform platformOne = new Platform(800,300,100,100);
        Platform platformTwo = new Platform(1000,200,100,100);
        Platform platformThree = new Platform(1200,100,100,100);
        Platform platformFour = new Platform(1400,0,100,100);
        addCreature(platformOne);
        addCreature(platformTwo);
        addCreature(platformThree);
        addCreature(platformFour);
        addCreature(new Platform(0,0,720,50));
        Platform movablePlatform = new Platform(500, 200, 150, 10).setColor(Color.cyan);

        Platform hpPlatform = new Platform(Game.player.getModel().getX()-5, Game.player.getModel().getY()-10, 30, 5);
        hpPlatform.setCollision(false);
        addCreature(hpPlatform);
        Animator.addAnimation(new AnimationMoveToRegardingTheObject(hpPlatform, -5, -10, Game.player, false));

        Animator.addAnimation(new AnimationMoveToRegardingTheWorld(platformOne, platformOne.getModel().x + 50, platformOne.getModel().y - 50, true));
        Animator.addAnimation(new AnimationMoveToRegardingTheWorld(platformTwo, platformTwo.getModel().x + 50, platformTwo.getModel().y - 50, true));
        Animator.addAnimation(new AnimationMoveToRegardingTheWorld(platformThree, platformThree.getModel().x + 50, platformThree.getModel().y - 50, true));
        Animator.addAnimation(new AnimationMoveToRegardingTheWorld(platformFour, platformFour.getModel().x + 50, platformFour.getModel().y - 50, true));
        Animator.addAnimation(new AnimationMoveToRegardingTheWorld(movablePlatform, 350, movablePlatform.getModel().y, true));
        addCreature(movablePlatform);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,55000,50000);
        g.translate(-startX, -startY);
        super.paintComponent(g);
        for (Model s : shapes) {
            s.draw(g);
        }
        for (Creature s : creatures) {
            s.getModel().draw(g);
        }
    }

    public void addModel(int x, int y, Model model) {
        shapes.add(model.setX(x).setY(y));
        repaint();
    }

    public void addModel(Model model) {
        shapes.add(model);
        repaint();
    }

    public void addCreature(Creature creature){
        creatures.add(creature);
        repaint();
    }
}
