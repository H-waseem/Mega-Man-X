package levels;

import Collision.HPCollision;
import Collision.WalkerCollision;
import bodies.MegaMan;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.Game;
import game.GameLevel;
import org.jbox2d.common.Vec2;

public class Level3 extends GameLevel {

    public Level3(Game game){

        super(game);

        new LevelBGMHandler();

        // Make ground
        Shape groundShape = new BoxShape(25, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-25f, -19.5f));


        StaticBody ground2 = new StaticBody(this,groundShape);
        ground2.setPosition(new Vec2(25,-25));

        // Make platform
        Shape platformShape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(36, 2f));

        Shape platformShape2 = new BoxShape(3f, 0.5f);
        StaticBody platform2 = new StaticBody(this, platformShape2);
        platform2.rotateDegrees(90);
        platform2.setPosition(new Vec2(0,-22f));


        // platform loop
        Shape shape2 = new BoxShape(4f, 0.5f); //Makes 4 platforms on left side with gaps in between to jump through
        for (int y = 0; y < 10; y = y + 8) {
            for (int x = -20; x < 40; x = x + 15) {
                StaticBody box = new StaticBody(this, shape2);
                box.setPosition(new Vec2(x - 17, y - 12));
            }
        }

        //Make left wall
        Shape wallShape = new BoxShape(0.5f, 15f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-49.5f, -5));

        // Make right wall
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(49.5f, -10));

        //Make inter wall
        StaticBody wall3 = new StaticBody(this, wallShape);
        wall3.setPosition(new Vec2(25, 0));

        getMegaMan().setPosition(new Vec2(-40, -15));
        getWalkerBot().setPosition(new Vec2(30, -15));
        getExitPortal().setPosition(new Vec2(48, -22));

        getMegaMan().addCollisionListener(new HPCollision(getMegaMan()));
        getWalkerBot().addCollisionListener(new WalkerCollision(getWalkerBot()));

    }
    @Override
    public boolean isComplete() {
        return MegaMan.getKills() == 1;
    }
}
