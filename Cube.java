package TestTwoDimensionalGraphic;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Cube extends Model {

    public Cube(int x, int y, int width, int height, Creature creature){
        super(x,y,width,height,creature);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.creature = creature;
        color = Color.green;
    }

    public void draw(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        Rectangle2D.Double model = new Rectangle2D.Double(x, y, width, height);

        graphics2D.setColor(color);
        graphics2D.fill(model);
    }


    public Cube(Creature creature){
        this(200, 200, 100, 100, creature);
    }
}
