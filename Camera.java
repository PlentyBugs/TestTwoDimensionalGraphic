package TestTwoDimensionalGraphic;

public class Camera extends Thread{

    private int lastX;
    private int lastY;
    private int shift;

    public Camera(){
        lastX = MainPanel.startX;
        lastY = MainPanel.startY;
        shift = 100;
        start();
    }

    @Override
    public void run(){
        while(true){
            synchronized (this){
                if(Game.player.getModel().getX() > lastX + Game.width - shift){
                    lastX = MainPanel.startX;
                    MainPanel.startX = Game.player.getModel().getX() - Game.width + shift;
                } else if(Game.player.getModel().getX() < lastX + shift){
                    lastX = MainPanel.startX;
                    MainPanel.startX = Game.player.getModel().getX() - shift;
                }
                if(Game.player.getModel().getY() > lastY + Game.height - shift){
                    lastY = MainPanel.startY;
                    MainPanel.startY = Game.player.getModel().getY() - Game.height + shift;
                } else if(Game.player.getModel().getY() < lastY + shift){
                    lastY = MainPanel.startY;
                    MainPanel.startY = Game.player.getModel().getY() - shift;
                }
            }
        }
    }
}
