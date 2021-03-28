package collision;

import bodies.MegaMan;
import bodies.Missile;
import bodies.Rabbit;
import bodies.WalkerBot;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class HPCollision implements CollisionListener {

    private final bodies.MegaMan MegaMan;

    public HPCollision(MegaMan m){
        this.MegaMan = m;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Missile) { // if Megaman gets hit by a missile he loses HP and the missile is destroyed
            MegaMan.RemoveHP();
            e.getOtherBody().destroy();
        }
        if (e.getOtherBody() instanceof WalkerBot || e.getOtherBody() instanceof Rabbit){ //if Megaman gets hit by a bot he loses HP
            MegaMan.RemoveHP();
        }
    }
}