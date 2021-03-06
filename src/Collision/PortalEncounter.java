package Collision;

import bodies.ExitPortal;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Game;
import game.GameLevel;


public class PortalEncounter implements CollisionListener {
    private final GameLevel level;
    private final Game game;

    public PortalEncounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public  void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof ExitPortal
                && level.isComplete()){
            game.goToNextLevel();
        }
    }
}
