package Collision;

import bodies.Missile;
import bodies.Shot;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;

public class ShotCollision implements CollisionListener {

    private final Shot shot;

    public  ShotCollision( Shot s) { this.shot = s;}

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof StaticBody) { // if shot hits a wall,floor or platform it gets destroyed
            shot.destroy();
        }
        else if (e.getOtherBody() instanceof Missile){
            shot.destroy();
        }
    }
}
