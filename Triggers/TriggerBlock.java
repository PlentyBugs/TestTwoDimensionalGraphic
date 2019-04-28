package TestTwoDimensionalGraphic.Triggers;

import TestTwoDimensionalGraphic.*;

import java.awt.*;
import java.util.ArrayList;

public class TriggerBlock extends Creature implements Trigger {

    private ArrayList<Creature> objectsIn = new ArrayList<>();

    public TriggerBlock(){
        this(0, Game.height-80, Game.width, 50);
    }

    public TriggerBlock(int x, int y, int width, int height){
        model = new Cube(x,y,width,height, this);
        collision = false;

        model.setColor(Color.blue);

        Triggeroid.addTrigger(this);
    }

    public boolean OnTriggerEnter(){
        boolean creatureIn = false;
        for (Creature s : MainPanel.creatures){
            if(!objectsIn.contains(s) && s.getModel() != model && (model.checkOnCollisionY(model, s.getModel(), 0) || model.checkOnCollisionY(s.getModel(), model, 0))){
                creatureIn = true;
                objectsIn.add(s);
                break;
            }
        }
        return creatureIn;
    }

    public boolean OnTriggerQuit(){
        boolean creatureIn = false;
        for (Creature s : MainPanel.creatures){
            if(objectsIn.contains(s) && s.getModel() != model && !(model.checkOnCollisionY(model, s.getModel(), 0) || model.checkOnCollisionY(s.getModel(), model, 0))){
                creatureIn = true;
                objectsIn.remove(s);
                break;
            }
        }
        return creatureIn;
    }

    public void OnTriggerActionOnEnter(){
        System.out.println(123);
    }

    public void OnTriggerActionOnQuit(){
        System.out.println(321);
    }
}
