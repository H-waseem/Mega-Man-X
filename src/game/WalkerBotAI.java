package game;

import collision.MissileCollision;
import bodies.Missile;
import bodies.WalkerBot;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class WalkerBotAI implements StepListener {

    private static bodies.WalkerBot WalkerBot;

    public static void setWalkerBot(bodies.WalkerBot walkerBot) {
        WalkerBot = walkerBot;
    }

    public double setNextMove(){
        return Math.ceil(Math.random() * 300);
    }

    public WalkerBotAI(WalkerBot w){
        WalkerBot = w;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

        if(WalkerBot == null){
            return;
        }
        double nextMove = setNextMove();

        if (nextMove <= 5){
            WalkerBot.stopWalking();
            WalkerBot.startWalking(5);
            setNextMove();
        }
        if (nextMove == 2){
            Vec2 selfPoint = WalkerBot.getPosition().add(new Vec2(-3.6f, 0)); //Position projectile right out of walker's hitbox
            Missile missile = new Missile(WalkerBot.getWorld()); //Create new instance of missile
            //shot.addImage(shot3Right); //Add image of right shot
            missile.setPosition(selfPoint); //position projectile on co ords
            missile.setLinearVelocity(new Vec2(-20, 0)); // Give the shot some speed
            MissileCollision missileCollision = new MissileCollision(missile); //Adds wall collision
            missile.addCollisionListener(missileCollision); //Wall collision listener
            setNextMove();
        }
        if (nextMove <= 10 && nextMove > 5) {
            WalkerBot.stopWalking();
            WalkerBot.startWalking(-5);
            setNextMove();
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }
}
