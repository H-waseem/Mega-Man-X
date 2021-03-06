package game;

import bodies.MegaMan;
import city.cs.engine.UserView;
import city.cs.engine.World;
import levels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.util.logging.Level;

public class GameView extends UserView {
    public Image levelbg;
    private GameLevel level = Game.getLevel();

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

        Graphics2D g2d = (Graphics2D)g;
        AffineTransform transform = g2d.getTransform();
        transform.translate(0, 35);
        g2d.transform(transform);
        g2d.setColor(Color.black);
        FontRenderContext frc = g2d.getFontRenderContext();
        TextLayout tl = new TextLayout("HP:" + MegaMan.getHealthPoints(), g.getFont().deriveFont(45F), frc);
        Shape shape = tl.getOutline(null);
        g2d.setStroke(new BasicStroke(2f));
        g2d.draw(shape);
        g2d.setColor(Color.green);
        g2d.fill(shape);


        Graphics2D g2d2 = (Graphics2D)g;
        AffineTransform transform2 = g2d2.getTransform();
        transform.translate(0, 35);
        g2d2.transform(transform2);
        g2d2.setColor(Color.black);
        FontRenderContext frc2 = g2d.getFontRenderContext();
        TextLayout tl2 = new TextLayout("Kills:" + MegaMan.getKills(), g.getFont().deriveFont(45F), frc2);
        Shape shape2 = tl2.getOutline(null);
        g2d2.setStroke(new BasicStroke(2f));
        g2d2.draw(shape2);
        g2d2.setColor(Color.red);
        g2d2.fill(shape2);


        Graphics2D g2d3 = (Graphics2D)g;
        AffineTransform transform3 = g2d3.getTransform();
        transform3.translate(920, -100);
        g2d3.transform(transform3);
        g2d3.setColor(Color.black);
        FontRenderContext frc3 = g2d3.getFontRenderContext();
        TextLayout tl3 = new TextLayout("Boost:" + MegaManController.getBoost(), g.getFont().deriveFont(45F), frc3);
        Shape shape3 = tl3.getOutline(null);
        g2d3.setStroke(new BasicStroke(2f));
        g2d3.draw(shape3);
        g2d3.setColor(Color.cyan);
        g2d3.fill(shape3);
    }
}
