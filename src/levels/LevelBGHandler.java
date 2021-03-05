package levels;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.Game;
import game.GameLevel;

import javax.swing.*;
import java.awt.*;

public class LevelBGHandler extends UserView {
    public Image level1bg;
    public Image level2bg;
    public Image level3bg;
    public Image level4bg;
    private GameLevel level = Game.getLevel();
    public static Image currentImg;

    public LevelBGHandler(World w, int width, int height) {
        super(w, width, height);

        level1bg = new ImageIcon("data/Storm Eagle Stage.png").getImage();
        level2bg = new ImageIcon("data/Flame Mammoth stage.png").getImage();
        level3bg = new ImageIcon("data/Flame Mammoth stage.png").getImage();
        level4bg = new ImageIcon("data/Flame Mammoth stage.png").getImage();


        if (level instanceof Level1) {
            currentImg = level1bg;
        }

        else if (level instanceof Level2) {
            currentImg = level2bg;
        }

        else if (level instanceof Level3) {
            currentImg = level3bg;
        }

        else if (level instanceof Level4) {
            currentImg = level4bg;
        }
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        new LevelBGHandler(Game.level,0,0);
        g.drawImage(level1bg, 0, 0, this);
    }

    public static Image getCurrentImg(){
         return currentImg;
    }
}
