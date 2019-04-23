package TestTwoDimensionalGraphic;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Model {

    protected int x,y,width,height;
    protected Color color;

    public Model(int x, int y){
        this.x = x;
        this.y = y;
        width = 50;
        height = 100;
        color = Color.red;
    }

    public Model(){
        this(200, 200);
    }

    public void draw(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        Rectangle2D.Double model = new Rectangle2D.Double(x, y, width, height);

        graphics2D.setColor(color);
        graphics2D.fill(model);
    }

    public Model setY(int y) {
        this.y = y;
        return this;
    }

    public Model setX(int x) {
        this.x = x;
        return this;
    }

    public Model addY(int y) {
        boolean col = false;
        for (Creature s : MainPanel.creatures){
            if(s.getModel() != this && checkOnCollisionY(s.getModel(), this, y)){
                col = true;
                break;
            }
        }
        if(!col){
            this.y += y;
        }
        return this;
    }

    public Model addX(int x) {
        boolean col = false;
        for (Creature s : MainPanel.creatures){
            if(s.getModel() != this && checkOnCollisionX(s.getModel(), this, x)){
                col = true;
                break;
            }
        }
        if(!col){
            this.x += x;
        }
        return this;
    }

    private boolean checkOnCollisionY(Model one, Model two, int speed){
        return (one.x < two.x && two.x < one.x+one.width
                && one.y < two.y + speed && two.y+speed < one.y+one.height)
                ||
                (one.x < two.x && two.x < one.x+one.width
                && one.y < two.y + two.height + speed && two.y + two.height + speed < one.y+one.height)
                ||
                (one.x < two.x+two.width && two.x+two.width < one.x+one.width
                && one.y < two.y + speed && two.y + speed < one.y+one.height)
                ||
                (one.x < two.x+two.width && two.x+two.width < one.x+one.width
                && one.y < two.y + two.height + speed && two.y + two.height + speed < one.y+one.height);
    }

    private boolean checkOnCollisionX(Model one, Model two, int speed){
        return (one.x < two.x + speed && two.x + speed < one.x+one.width
                && one.y < two.y && two.y < one.y+one.height)
                ||
                (one.x < two.x + two.width + speed && two.x + two.width + speed < one.x+one.width
                && one.y < two.y && two.y < one.y+one.height)
                ||
                (one.x < two.x + speed && two.x + speed < one.x+one.width
                && one.y < two.y+two.height && two.y+two.height < one.y+one.height)
                ||
                (one.x < two.x + two.width + speed && two.x + two.width + speed < one.x+one.width
                && one.y < two.y+two.height && two.y+two.height < one.y+one.height);
    }
}
