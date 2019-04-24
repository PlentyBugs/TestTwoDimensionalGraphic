package TestTwoDimensionalGraphic;

import TestTwoDimensionalGraphic.Animations.AnimationMoveTo;
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
        addCreature(new Platform());
        addCreature(new Platform(300,300,100,200));
        addCreature(new Platform(0,0,720,50));
        Platform movablePlatform = new Platform(500, 200, 150, 10).setColor(Color.cyan);

        Animator.addAnimation(new AnimationMoveTo(movablePlatform, 350, movablePlatform.getModel().y, true));
        addCreature(movablePlatform);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,55000,50000);
        g.translate(startX,startY);
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
