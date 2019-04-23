package TestTwoDimensionalGraphic;

public class Player extends Creature{

    private Controller controller;
    private int speed;

    public Player() {
        setModel(new Model(10,100));
        controller = new Controller(this);
        setSpeed(15);
        setAcceleration(0);
        setMass(5);
    }

    public Controller getController() {
        return controller;
    }
}
