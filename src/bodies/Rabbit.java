package bodies;

import city.cs.engine.*;
import game.RabbitAI;
import game.WalkerBotAI;

public class Rabbit extends Walker {

    private static final Shape WalkerBotShape = new PolygonShape(0.9f,1.47f, 1.07f,-2.38f, -1.0f,-2.31f, -0.84f,1.43f, 0.04f,2.0f); //Walker hitbox

    private int hp;

    public int getHp() {
        return hp;
    } //Getter for walker HP

    public void setHp(int hp) {
        this.hp = hp;
    } // Setter for walker HP

    private static final BodyImage image =
            new BodyImage("data/Rabbit.png", 5f);

    public Rabbit(World world) { //Constructor which sets the gravity and hp of the walker bot
        super(world,WalkerBotShape);
        addImage(image);
        setGravityScale(9.81f);
        hp = 5;
    }

    @Override
    public void destroy(){
        super.destroy();
        RabbitAI.setRabbit(null);
    }
}
