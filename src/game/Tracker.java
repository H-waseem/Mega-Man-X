package game;

import bodies.MegaMan;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Tracker implements StepListener {
    private GameView view;
    private MegaMan megaMan;
    private JFrame frame;

    public Tracker() {
        this.view = Game.getView();
        this.megaMan = Game.getLevel().getMegaMan();
        this.frame = Game.getFrame();
    }
    public void preStep(StepEvent e) {

    }

    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(megaMan.getPosition()));

    }

}
