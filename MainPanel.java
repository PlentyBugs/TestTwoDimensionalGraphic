package TestTwoDimensionalGraphic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPanel extends JPanel {

    private List<Model> shapes = new ArrayList<>();
    public static ArrayList<Creature> creatures = new ArrayList<>();

    public MainPanel() {
        setBackground(Color.BLACK);
        addCreature(Game.player);
        addCreature(new Platform());
        addCreature(new Platform(300,300,100,200));
        addCreature(new Platform(0,0,720,50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Model s : shapes) {
            s.draw(g);
        }
        for (Creature s : creatures) {
            s.getModel().draw(g);
        }
    }

    public void addModel(int maxX, int maxY) {
        Random random = new Random();
        shapes.add(new Model(random.nextInt(maxX), random.nextInt(maxY)));
        repaint();
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
