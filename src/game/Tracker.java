package game;

import bodies.MegaMan;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Tracker implements StepListener {
    private final GameView view;
    private final MegaMan megaMan;

    public Tracker() {
        this.view = Game.getView();
        this.megaMan = Game.getLevel().getMegaMan();
        JFrame frame = Game.getFrame();
    }
    public void preStep(StepEvent e) {

    }

    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(megaMan.getPosition()));

    }

}
