package Collision;

import bodies.Missile;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;

public class MissileCollision implements CollisionListener {

    private final Missile missile;

    public  MissileCollision( Missile m) { this.missile = m;}

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof StaticBody) { // if shot hits a wall,floor or platform it gets destroyed
            missile.destroy();
        }
    }
}
