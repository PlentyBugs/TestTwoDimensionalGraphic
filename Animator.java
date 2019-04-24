package TestTwoDimensionalGraphic;

import java.util.ArrayList;

public class Animator {

    private static ArrayList<Animation> animations = new ArrayList<>();

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
}
