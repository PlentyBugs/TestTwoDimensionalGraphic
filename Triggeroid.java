package TestTwoDimensionalGraphic;

import TestTwoDimensionalGraphic.Triggers.Trigger;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Triggeroid extends Thread{

    private static Set<Trigger> creatures = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public Triggeroid(){
        start();
    }

    @Override
    public void run(){
        while (true){
            for(Trigger creature : creatures){
                if(creature.OnTriggerEnter()){
                    creature.OnTriggerActionOnEnter();
                }
                if(creature.OnTriggerQuit()){
                    creature.OnTriggerActionOnQuit();
                }
            }
        }
    }

    public static void addTrigger(Trigger creature){
        creatures.add(creature);
    }

    public static void removeTrigger(Trigger creature){
        creatures.remove(creature);
    }
}
