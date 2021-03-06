package levels;

import Collision.RabbitCollision;
import bodies.MegaMan;
import bodies.Rabbit;
import game.Game;
import game.GameLevel;
import Collision.HPCollision;
import Collision.WalkerCollision;
import game.RabbitAI;
import org.jbox2d.common.Vec2;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;


public class Level2 extends GameLevel {

    Rabbit rabbit = new Rabbit(this);

    public Level2(Game game){
        super(game);

        new LevelBGMHandler();

        // Make ground
        Shape shape = new BoxShape(50, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -19.5f));

        // Make platforms
        Shape platformShape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(30, 2f));


        Shape platform2Shape = new BoxShape(8,0.5f);
        StaticBody platform2 = new StaticBody(this,platform2Shape);
        platform2.setPosition(new Vec2(-35,-12));

        // Angled platform loop
        Shape shape3 = new BoxShape(0.5f, 6f); //Makes 4 platforms on left side with gaps in between to jump through
        for (int y = 0; y < 10; y = y + 10) {
            for (int x = -10; x < 45; x = x + 15) {
                StaticBody box = new StaticBody(this, shape3);
                box.setAngle(-1);
                box.setPosition(new Vec2(x - 17, y ));
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
        getMegaMan().setPosition(new Vec2(37, 15));
        getWalkerBot().setPosition(new Vec2(30, -15));

        getMegaMan().addCollisionListener(new HPCollision(getMegaMan()));

        getWalkerBot().addCollisionListener(new WalkerCollision(getWalkerBot()));

        Game.getLevel().addStepListener(new RabbitAI(rabbit));

        rabbit.addCollisionListener(new RabbitCollision(rabbit));

        getExitPortal().setPosition(new Vec2(30, 5));

    }
    @Override
    public boolean isComplete() {
        return MegaMan.getHealthPoints() < 11;
    }
}

