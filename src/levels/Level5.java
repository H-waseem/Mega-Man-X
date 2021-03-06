package levels;

import Collision.RabbitCollision;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.Game;
import game.GameLevel;
import Collision.HPCollision;
import Collision.WalkerCollision;
import org.jbox2d.common.Vec2;

public class Level5 extends GameLevel {

    public Level5(Game game){

        super(game);

        new LevelBGMHandler();

        // Make ground
        Shape shape = new BoxShape(50, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -19.5f));


        // platform loop
        Shape shape2 = new BoxShape(4f, 0.5f); //Makes 4 platforms on left side with gaps in between to jump through
        for (int y = 0; y < 10; y = y + 8) {
            for (int x = -10; x < 45; x = x + 15) {
                StaticBody box = new StaticBody(this, shape2);
                box.rotateDegrees(25);
                box.setPosition(new Vec2(x - 17, y - 12));
            }
        }

        //Make left wall
        Shape wallShape = new BoxShape(0.5f, 15f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-49.5f, -5));

        // Make right wall
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(49.5f, -5));

        //getMegaMan().setPosition(new Vec2(-40, -15));
        getMegaMan().setPosition(new Vec2(40, 15));
        getWalkerBot().setPosition(new Vec2(30, -15));

        getMegaMan().addCollisionListener(new HPCollision(getMegaMan()));
        getWalkerBot().addCollisionListener(new WalkerCollision(getWalkerBot()));

        //getRabbit().addCollisionListener(new RabbitCollision(getRabbit()));
        getExitPortal().setPosition(new Vec2(48, -17));
    }
    @Override
    public boolean isComplete() {
        if (getMegaMan().getHealthPoints() < 11)
            return true;
        else
            return false;
    }
}