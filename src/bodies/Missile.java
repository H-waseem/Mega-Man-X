package bodies;

import city.cs.engine.*;

public class Missile extends DynamicBody {

    private static final Shape missileShape = new PolygonShape(-1.74f,0.25f, 1.52f,1.1f, 1.65f,-1.04f, -1.78f,-0.19f); //Missile hitbox
    private static final BodyImage image =
            new BodyImage("data/Missile.png", 2f);

    public Missile(World w) {
        super(w,missileShape);
        setGravityScale(0);
        addImage(image);
    }
}
