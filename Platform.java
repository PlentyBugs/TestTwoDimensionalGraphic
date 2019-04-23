package TestTwoDimensionalGraphic;

public class Platform extends Creature{

    public Platform(){
        model = new Cube(0, Game.height-80, Game.width, 50);
        collision = true;
    }

    public Platform(int x, int y, int width, int height){
        model = new Cube(x,y,width,height);
        collision = true;
    }
}
