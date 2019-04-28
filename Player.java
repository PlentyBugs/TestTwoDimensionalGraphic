package TestTwoDimensionalGraphic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Player extends Creature{

    private Controller controller;
    private Thread controllerThread;
    private Thread jumpThread;
    private Set<Integer> jumps = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public Player() {
        setModel(new Model(10,100, 20, 20, this));
        controller = new Controller(this);
        setSpeed(7000);
        setJumpPower(250);
        setAcceleration(0);
        setMass(8);
        setCountOfJumps(2);
        setMaxCountOfJumps(2);
        setCollision(true);
        jumpThread = new Thread(() -> {
            while(true){
                for(Integer j : jumps){
                    for(int i = 0; i < j; i++){
                        model.addY(-1);
                        Game.window.drawWindow();
                    }
                    jumps.remove(j);
                }
            }
        });
        jumpThread.start();
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

    public void jump(){
        if(countOfJumps > 0){
            countOfJumps --;
            jumps.add(jumpPower);
        }
    }
}
