package game;

import collision.MissileCollision;
import bodies.Missile;
import bodies.Rabbit;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class RabbitAI implements StepListener {

    private static bodies.Rabbit Rabbit;

    public static void setRabbit(bodies.Rabbit rabbit) { Rabbit = rabbit; }

    public double setNextMove(){
        return Math.ceil(Math.random() * 300);
    }

    public RabbitAI(Rabbit r){ Rabbit = r; }

    @Override
    public void preStep(StepEvent stepEvent) {

        if(Rabbit == null){
            return;
        }
        double nextMove = setNextMove();

        if (nextMove <= 5){ //Probability to move right 5/300 per step
            Rabbit.stopWalking();
            Rabbit.startWalking(5);
            setNextMove();
        }
        if (nextMove == 2){ //Shoot left if 1/300 prob has been reached per step
            Vec2 selfPoint = Rabbit.getPosition().add(new Vec2(-3.6f, 0)); //Position projectile right out of megaman's hitbox
            Missile missile = new Missile(Rabbit.getWorld()); //Create new instance of missile
            //shot.addImage(shot3Right); //Add image of right shot
            missile.setPosition(selfPoint); //position projectile on co ords
            missile.setLinearVelocity(new Vec2(-20, 0)); // Give the shot some speed
            MissileCollision missileCollision = new MissileCollision(missile); //Adds wall collision
            missile.addCollisionListener(missileCollision); //Wall collision listener
            setNextMove();
        }
        if (nextMove == 3) { //Jump if 1/300 prob has been reached per step
            Rabbit.jump(50);
            setNextMove();
        }

        if (nextMove <= 10 && nextMove > 5) { //probability to move left 5/300 per step
            Rabbit.stopWalking();
            Rabbit.startWalking(-5);
            setNextMove();
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
