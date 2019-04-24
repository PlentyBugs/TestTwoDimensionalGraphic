package TestTwoDimensionalGraphic.Animations;

import TestTwoDimensionalGraphic.Game;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Animator {

    private static Set<Animation> animations = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public Animator(){
        Thread thread = new Thread(() -> {
            while(true) {
                for (Animation animation : animations)
                    animation.play();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(Game.window != null)
                    Game.window.drawWindow();
            }
        });
        thread.start();
    }

    public static void addAnimation(Animation animation){
        animations.add(animation);
    }

    public static void removeAnimation(Animation animation){
        animations.remove(animation);
    }
}
