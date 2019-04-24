package TestTwoDimensionalGraphic;

public class Creature {

    protected int speed;
    protected int acceleration;
    protected int mass;
    protected int jumpPower;
    protected Model model;
    protected boolean onAir;
    protected boolean collision;
    protected boolean topDirection = false;
    protected boolean bottomDirection = false;
    protected boolean leftDirection = false;
    protected boolean rightDirection = false;

    public void setBottomDirection(boolean bottomDirection) {
        this.bottomDirection = bottomDirection;
    }

    public void setLeftDirection(boolean leftDirection) {
        this.leftDirection = leftDirection;
    }

    public void setRightDirection(boolean rightDirection) {
        this.rightDirection = rightDirection;
    }

    public void setTopDirection(boolean topDirection) {
        this.topDirection = topDirection;
    }

    public boolean isBottomDirection() {
        return bottomDirection;
    }

    public boolean isLeftDirection() {
        return leftDirection;
    }

    public boolean isRightDirection() {
        return rightDirection;
    }

    public boolean isTopDirection() {
        return topDirection;
    }

    public void setJumpPower(int jumpPower) {
        this.jumpPower = jumpPower;
    }

    public int getJumpPower() {
        return jumpPower;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void jump(){
        if(!onAir){
            onAir = true;
            Thread thread = new Thread(() -> {
                for(int i = 0; i < jumpPower; i++){
                    model.addY(-1);
                    Game.window.drawWindow();
                }
            });
            thread.start();
        }
    }

    public boolean isOnAir(){
        return onAir;
    }

    public void setOnAir(boolean onAir) {
        this.onAir = onAir;
    }
}
