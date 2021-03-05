package levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.Game;
import game.GameLevel;
import Collision.HPCollision;
import Collision.WalkerCollision;
import org.jbox2d.common.Vec2;

public class Level4 extends GameLevel {

    public Level4(Game game){

        super(game);

        new LevelBGMHandler();

        getMegaMan().setPosition(new Vec2(1,1));
        getWalkerBot().setPosition(new Vec2(1,1));

        getMegaMan().addCollisionListener(new HPCollision(getMegaMan()));
        getWalkerBot().addCollisionListener(new WalkerCollision(getWalkerBot()));

        // make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make some walls
        Shape wallShape = new BoxShape(0.5f, 6f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-14.5f, -6));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(19.5f, -6));

        getExitPortal().setPosition(new Vec2(18,0));
    }
    @Override
    public boolean isComplete() {
        if (getMegaMan().getHealthPoints() < 11)
            return true;
        else
            return false;
    }
}
