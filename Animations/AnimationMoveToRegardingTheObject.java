package TestTwoDimensionalGraphic.Animations;

import TestTwoDimensionalGraphic.Creature;

public class AnimationMoveToRegardingTheObject implements Animation {

    private Creature creature;
    private int xStart;
    private int yStart;
    private int xGoal;
    private int yGoal;
    private Creature relativeCreature;
    private boolean removeOnFinish;
    private int step;

    public AnimationMoveToRegardingTheObject(Creature creature, int xGoal, int yGoal, Creature relativeCreature, boolean removeOnFinish){
        this.creature = creature;
        this.xStart = creature.getModel().getX();
        this.yStart = creature.getModel().getY();
        this.relativeCreature = relativeCreature;
        this.yGoal = yGoal;
        this.xGoal = xGoal;
        this.removeOnFinish = removeOnFinish;
        step = 1;
    }

    public void play(){
        if(creature.getModel().getX() == xGoal + relativeCreature.getModel().getX() && creature.getModel().getY() == yGoal + relativeCreature.getModel().getY()){
            if(removeOnFinish)
                Animator.removeAnimation(this);
        } else {
            System.out.println();
            step = Math.max((int)(Math.sqrt((yGoal + relativeCreature.getModel().getY() - creature.getModel().getY())*(yGoal + relativeCreature.getModel().getY() - creature.getModel().getY()) + (xGoal + relativeCreature.getModel().getX() - creature.getModel().getX())*(xGoal + relativeCreature.getModel().getX() - creature.getModel().getX())))/5, 1);
            if (creature.getModel().getX() < xGoal + relativeCreature.getModel().getX())
                creature.getModel().addX(step);
            else if(creature.getModel().getX() > xGoal + relativeCreature.getModel().getX())
                creature.getModel().addX(-step);

            if (creature.getModel().getY() < yGoal + relativeCreature.getModel().getY())
                creature.getModel().addY(step);
            else if(creature.getModel().getY() > yGoal + relativeCreature.getModel().getY())
                creature.getModel().addY(-step);
        }
    }
}
