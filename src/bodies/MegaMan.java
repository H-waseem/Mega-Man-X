package bodies;

import city.cs.engine.*;

public class MegaMan extends Walker {
    private static final Shape MegaManShape = new PolygonShape(0.72f,2.37f, 2.13f,0.23f, 1.84f,-2.46f, -2.14f,-2.46f, -1.44f,0.34f, 0.28f,2.37f); //Megaman hitbox

    private static final BodyImage image =
            new BodyImage("data/XRight.png", 5f);

    private static int healthPoints; //Megaman's health points

    private static int kills;

    public MegaMan(World world) {
        super(world, MegaManShape);
        addImage(image);
        setGravityScale(9.81f); //Set Megaman's gravity
        healthPoints = 10;
        kills = 0;
    }

    public static int getKills() {
        return kills;
    }

    public static void setKills() {
        kills++;
    }

    public void RemoveHP() { //Function to remove HP when mega man gets hit
        healthPoints--;
        if (healthPoints <= 1) { //Ends game if HP is below 1
            System.out.println("GAME OVER");
            getWorld().stop(); //Make world stop
            System.exit(0);
        }
    }

    public static int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}