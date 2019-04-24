package TestTwoDimensionalGraphic.Animations;

import TestTwoDimensionalGraphic.Animations.Animation;
import TestTwoDimensionalGraphic.Animations.Animator;
import TestTwoDimensionalGraphic.Creature;

public class AnimationMoveTo implements Animation {

    private Creature creature;
    private int xStart;
    private int yStart;
    private int xGoal;
    private int yGoal;
    private boolean cycle;

    public AnimationMoveTo(Creature creature, int xGoal, int yGoal, boolean cycle){
        this.creature = creature;
        this.xStart = creature.getModel().getX();
        this.yStart = creature.getModel().getY();
        this.yGoal = yGoal;
        this.xGoal = xGoal;
        this.cycle = cycle;
    }

    public void play(){
        if(creature.getModel().getX() == xGoal && creature.getModel().getY() == yGoal){
            if(cycle){
                this.xGoal += xStart;
                this.yGoal += yStart;
                xStart = this.xGoal - xStart;
                yStart = this.yGoal - yStart;
                this.xGoal -= xStart;
                this.yGoal -= yStart;
            } else {
                Animator.removeAnimation(this);
            }
        } else {
            if (creature.getModel().getX() < xGoal)
                creature.getModel().addX(1);
            else if(creature.getModel().getX() > xGoal)
                creature.getModel().addX(-1);

            if (creature.getModel().getY() < yGoal)
                creature.getModel().addY(1);
            else if(creature.getModel().getY() > yGoal)
                creature.getModel().addY(-1);
        }
    }
}
