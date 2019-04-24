package TestTwoDimensionalGraphic;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private MainPanel mainPanel = new MainPanel();
    private Player player;

    public Window(Player player){
        this.player = player;
        setPreferredSize(new Dimension(Game.width, Game.height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(player.getController());
        
        getContentPane().add(mainPanel);
        drawWindow();
    }

    public void drawWindow(){

        setResizable(false);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
   }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
