package TestTwoDimensionalGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Model {

    protected int x,y,width,height;
    protected Color color;
    protected Creature creature;
    protected DrawModel drawModel;

    public Model(int x, int y, int width, int height, Creature creature){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.creature = creature;
        color = Color.red;
        drawModel = g -> {
            Graphics2D graphics2D = (Graphics2D) g;
            Rectangle2D.Double model = new Rectangle2D.Double(this.x, this.y, this.width, this.height);
            graphics2D.setColor(color);
            graphics2D.fill(model);
        };
    }

    public Model(int x, int y, Creature creature){
        this(x,y,50,100, creature);
    }

    public Model(Creature creature){
        this(200, 200, creature);
    }

    public void draw(Graphics g){
        drawModel.draw(g);
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
                if(y > 0){
                    creature.setOnAir(false);
                }
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

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public DrawModel getDrawModel() {
        return drawModel;
    }

    public void setDrawModel(DrawModel drawModel) {
        this.drawModel = drawModel;
    }
}
