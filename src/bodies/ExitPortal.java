package bodies;

import city.cs.engine.*;

public class ExitPortal extends StaticBody { //ExitPortal shape and images added below
    private static final Shape PortalShape = new PolygonShape(-1.11f,-2.26f, 0.9f,-2.29f, 1.08f,1.31f, -0.06f,2.35f, -1.31f,1.28f); //Portal hitbox

    private static final BodyImage image =
            new BodyImage("data/Portal.png", 5f);

    public ExitPortal(World world){
        super(world, PortalShape);
        addImage(image);
    }

}
