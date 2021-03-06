package Collision;

import bodies.MegaMan;
import bodies.Rabbit;
import bodies.Shot;
import bodies.WalkerBot;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.RabbitAI;

public class RabbitCollision implements CollisionListener {

    private final Rabbit rabbit;

    public RabbitCollision(Rabbit r){
        this.rabbit = r;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Shot) { // if the walker bot gets hit by a shot it loses HP and the shot is removed
            e.getOtherBody().destroy();
            rabbit.setHp(rabbit.getHp()-1);
        }
        if (e.getOtherBody() instanceof Shot && rabbit.getHp() <= 0) { //Destroy walker bot if it gets hit by shot and is at ot below 0 HP
            MegaMan.setKills();
            rabbit.destroy();
        }
    }
}
