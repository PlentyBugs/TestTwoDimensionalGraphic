package TestTwoDimensionalGraphic;

import java.util.ArrayList;

public class ThatHowGravityWorks extends Thread {

    private static ArrayList<Creature> creatures = new ArrayList<>();
    private final int gravity = 9;

    @Override
    public void run(){
        while (true){
            for(Creature creature : creatures){
                creature.getModel().addY(1);
            }
            try {
                sleep(gravity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Game.window.drawWindow();
        }
    }

    public void addCreature(Creature creature){
        creatures.add(creature);
    }
}
