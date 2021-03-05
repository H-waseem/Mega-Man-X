package game;

import bodies.MegaMan;
import city.cs.engine.UserView;
import city.cs.engine.World;
import levels.*;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

public class GameView extends UserView {
    public Image levelbg;

    private GameLevel level = Game.getLevel();
    public Image currentImg;

    public GameView(World w, int width, int height) {
        super(w, width, height);

        if (Game.level instanceof Level1) {
            levelbg = new ImageIcon("data/Storm Eagle Stage.png").getImage();
        }
        else if (Game.level instanceof Level2) {
            levelbg = new ImageIcon("data/Storm Eagle Stage Sky.png").getImage();
        }
        else if (Game.level instanceof Level3) {
            levelbg = new ImageIcon("data/Flame Mammoth stage.png").getImage();
        }
        else if (Game.level instanceof Level4) {
            levelbg = new ImageIcon("data/Boomer Kuwanger Stage.png").getImage();
        }
        else if (Game.level instanceof Level5) {
            levelbg = new ImageIcon("data/Chill Penguin Stage.png").getImage();
        }
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(levelbg, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.black);
        g.drawString("Kills: " + MegaMan.getKills(), 10, 20);
        g.drawString("HP: " + MegaMan.getHealthPoints(), 100, 20 );
        g.drawString("Boost: " + MegaManController.getBoost(), 1000, 20 );
    }
}
