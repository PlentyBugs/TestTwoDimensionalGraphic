package TestTwoDimensionalGraphic;

public class Player extends Creature{

    private Controller controller;
    private Thread controllerThread;

    public Player() {
        setModel(new Model(10,100, 20, 20, this));
        controller = new Controller(this);
        setSpeed(7000);
        setJumpPower(250);
        setAcceleration(0);
        setMass(8);
        setCollision(true);
    }

    public Controller getController() {
        return controller;
    }

    public void setControllerThread(Thread controllerThread) {
        this.controllerThread = controllerThread;
        this.controllerThread.start();
    }

    public Thread getControllerThread() {
        return controllerThread;
    }
}
