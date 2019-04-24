package TestTwoDimensionalGraphic;

import java.awt.*;

public class Platform extends Creature{

    public Platform(){
        model = new Cube(0, Game.height-80, Game.width, 50, this);
        collision = true;
    }

    public Platform(int x, int y, int width, int height){
        model = new Cube(x,y,width,height, this);
        collision = true;
    }

    public Platform setColor(Color color){
        model.setColor(color);
        return this;
    }
}
