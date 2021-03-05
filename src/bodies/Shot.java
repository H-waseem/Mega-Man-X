package bodies;

import city.cs.engine.*;

public class Shot extends DynamicBody {

    private static final Shape shotShape = new PolygonShape(-2.08f,0.04f, 0.34f,1.95f, 2.2f,0.12f, 0.4f,-1.76f); //Shape of projectile 

    private static final BodyImage image =
            new BodyImage("data/shot3Right.gif", 2f);

    public Shot(World w) {
        super(w,shotShape);
        setGravityScale(0);
        addImage(image);
    }
}
